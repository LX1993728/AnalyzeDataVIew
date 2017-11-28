package com.anrong.wulan.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.service.SYSPermissionService;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.vo.SYSPermissionVO;
import com.anrong.wulan.core.util.Page;

/**
 * 资源管理的控制器
 * 
 * @author liuxun
 *
 */
@Controller
@RequiresPermissions("setting:res")
@RequestMapping(value = "/syspermission")
public class SYSPermissionController {
	@Autowired
	private SYSPermissionService sysPermissionService;
	
	@Autowired
	private SYSService sysService;

	/**
	 * 资源信息列表显示
	 * 
	 * @param model
	 * @param sysPermissionVO
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getSYSUsers(Model model, @ModelAttribute(value = "p") SYSPermissionVO sysPermissionVO) {
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		sysPermissionVO.setPageSize(10);
		Page<SYSPermission> permsPage = sysPermissionService.getPermsByCriteria(sysPermissionVO);
		model.addAttribute("page", permsPage);
		return "sys_permission";
	}

	/**
	 * 跳转到资源新增页面
	 * 
	 * @param model
	 * @param sysPermissionVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public String addUserPage(Model model, SYSPermissionVO sysPermissionVO) {
		if (sysPermissionVO.getId() != null) {
			return "404";
		}
		return "sys_permission_resolve";
	}

	/**
	 * 跳转到资源修改页面
	 * 
	 * @param model
	 * @param sysPermissionVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET })
	public String updatePage(Model model, SYSPermissionVO sysPermissionVO) {
		if (sysPermissionVO.getId() == null) {
			return "404";
		}
		// 根据ID查询某资源的具体信息
		SYSPermission p = sysPermissionService.getPermissionByPrimaryKey(sysPermissionVO.getId());
		model.addAttribute("p", p);
		return "sys_permission_resolve";
	}

	/**
	 * 添加资源提交
	 * 
	 * @param model
	 * @param sysPermissionVO
	 * @return
	 */
	@RequestMapping(value = "/addpermission", method = { RequestMethod.POST })
	public String addPermission(Model model, @ModelAttribute(value = "p") SYSPermissionVO sysPermissionVO) {
		String message = null;
		String validate = validateForUpdateAndInsert(model, sysPermissionVO, 1);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysPermissionService.addPermission(sysPermissionVO);
		if (b) { // 增加成功
			sysService.clearAllUserShiroSessions();
			return "redirect:/rest/syspermission/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_permission_resolve";
	}

	/**
	 * 修改资源提交
	 * 
	 * @param model
	 * @param sysPermissionVO
	 * @return
	 */
	@RequestMapping(value = "/updatepermission", method = { RequestMethod.POST })
	public String updatePermission(Model model, @ModelAttribute(value = "p") SYSPermissionVO sysPermissionVO) {
		String message = null;
		String validate = validateForUpdateAndInsert(model, sysPermissionVO, 2);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysPermissionService.updatePermission(sysPermissionVO);
		if (b) { // 修改成功
			sysService.clearAllUserShiroSessions();
			return "redirect:/rest/syspermission/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_permission_resolve";
	}
	
    /**
     * 删除资源提交
     * @param id
     * @return
     */
	@RequestMapping(value = "/deletepermission", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, String> deletePermission(Integer id) {
		 Map<String, String> result = new HashMap<>();
		if (id==null) {
			result.put("message", "该资源不存在");
			return result;
		}
		if (sysPermissionService.isBindRoles(id)) {
			result.put("message", "该资源已被角色关联，不可删除！");
			return result;
		}
		if (!sysPermissionService.deletePermission(id)) {
			result.put("message", "服务器内部出错");
			return result;
		}else {
			sysService.clearAllUserShiroSessions();
			result.put("message", "成功删除该资源");
			return result;
		}
	}

	/**
	 * 新增和修改前的校验抽取
	 * 
	 * @param model
	 * @param sysPermissionVO
	 * @param i
	 * @return
	 */
	private String validateForUpdateAndInsert(Model model, SYSPermissionVO sysPermissionVO, int i) {
		if (sysPermissionVO.getName() == null || sysPermissionVO.getName().trim().length() == 0) {
			model.addAttribute("message", "资源名称不能为空或空格");
			return "sys_permission_resolve";
		}
		if (sysPermissionVO.getCode() == null || sysPermissionVO.getCode().trim().length() == 0) {
			model.addAttribute("message", "资源编码不能为空或空格");
			return "sys_permission_resolve";
		}
		// 校验编码是否重复
		// 首先查询所有的编码名称
		List<String> codes = sysPermissionService.getAllCodes();
		if (i == 1 && codes.contains(sysPermissionVO.getCode())) {
			model.addAttribute("message", "该资源编码已被使用");
			return "sys_permission_resolve";
		}
		SYSPermission sp = sysPermissionVO.getId() == null ? null
				: sysPermissionService.getPermissionByPrimaryKey(sysPermissionVO.getId());
		if (i == 2 && sp != null
				&& (!sysPermissionVO.getCode().equals(sp.getCode()) && codes.contains(sysPermissionVO.getCode()))) {
			model.addAttribute("message", "该资源编码已被使用");
			return "sys_permission_resolve";
		}

		return null;
	}

}
