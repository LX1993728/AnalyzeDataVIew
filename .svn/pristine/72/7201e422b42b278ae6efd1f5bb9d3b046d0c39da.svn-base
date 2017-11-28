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

import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.service.AppInfoService;
import com.anrong.wulan.admin.service.SYSRoleService;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.service.SYSUserService;
import com.anrong.wulan.admin.vo.SYSUserVO;
import com.anrong.wulan.core.util.Page;

/**
 * 系统用户管理控制器
 * 
 * @author liuxun
 *
 */
@Controller
@RequestMapping(value = "/sysuser")
@RequiresPermissions("setting:user")
public class SYSUserController {
	@Autowired
	private SYSUserService sysUserService;

	@Autowired
	private SYSRoleService sysRoleService;

	@Autowired
	private AppInfoService appInfoService;
	
	@Autowired
	private SYSService sysService;

	/**
	 * 用户信息列表显示
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getSYSUsers(Model model, @ModelAttribute(value = "u") SYSUserVO sysUserVO) {
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		sysUserVO.setPageSize(10);
		Page<User> users = sysUserService.getUsersByCriteria(sysUserVO);
		model.addAttribute("page", users);
		model.addAttribute("roles", sysRoleService.findAllRoles());
		return "sys_user";
	}

	/**
	 * 新增用户页面
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String addUserPage(Model model, @ModelAttribute(value = "u") SYSUserVO sysUserVO) {
		if (sysUserVO.getId() != null) {
			return "404";
		}
		model.addAttribute("apps", appInfoService.getAllApp());
		model.addAttribute("roles", sysRoleService.findAllRoles());
		return "sys_user_resolve";
	}

	/**
	 * 检查用户名是否重复
	 */
	@RequestMapping(value = "/checkname")
	@ResponseBody
	public Map<String, String> checkUserName(Model model, SYSUserVO sysUserVO) {
		String errorMessage = "";
		Map<String, String> resp = new HashMap<>();
		if (sysUserVO.getUsername() == null || sysUserVO.getUsername().trim().length() == 0) {
			errorMessage = "用户名不可为空或空格";
		} else {
			Long countByUserName = sysUserService.getCountByUserName(sysUserVO);
			if (countByUserName.intValue() != 0) {
				errorMessage = "该用户名已经存在";
			}
		}
		resp.put("message", errorMessage);
		return resp;
	}

	private String validateForUpdateAndInsert(Model model, SYSUserVO sysUserVO, String message, int i) {
		if (sysUserVO.getUsername() == null || sysUserVO.getUsername().trim().length() == 0) {
			message = "用户名不能为空或者空格";
			model.addAttribute("message", message);
			return "sys_user_resolve";
		}
		if (i == 1 && (sysUserVO.getPassword() == null || sysUserVO.getPassword().trim().length() == 0)) {
			message = "密码不能为空或者空格";
			model.addAttribute("message", message);
			return "sys_user_resolve";
		}

		if (sysUserVO.getRoleIds().size() < 1) {
			message = "请为该用户分配角色";
			model.addAttribute("message", message);
			return "sys_user_resolve";
		}
		if (sysUserVO.getAppIds().size() < 1) {
			message = "请为该用户绑定平台";
			model.addAttribute("message", message);
			return "sys_user_resolve";
		}

		if (i == 1 && sysUserService.getCountByUserName(sysUserVO).intValue() != 0) { // 对于新增而言
			message = "该用户名已被注册";
			model.addAttribute("message", message);
			return "sys_user_resolve";
		}
		User user = sysUserVO.getId() == null ? null : sysUserService.getUserByUserId(sysUserVO.getId());
		if (i == 2 && user != null && (!user.getUsername().equals(sysUserVO.getUsername())
				&& sysUserService.getCountByUserName(sysUserVO).intValue() != 0)) {
			message = "该用户名已被注册";
			model.addAttribute("message", message);
			return "sys_user_resolve";
		}

		return null;
	}

	/**
	 * 为系统添加用户(管理员)
	 */
	@RequestMapping(value = "/adduser", method = { RequestMethod.GET, RequestMethod.POST })
	public String addUser(Model model, @ModelAttribute(value = "u") SYSUserVO sysUserVO) {
		model.addAttribute("apps", appInfoService.getAllApp());
		model.addAttribute("roles", sysRoleService.findAllRoles());
		String message = null;
		String validate = validateForUpdateAndInsert(model, sysUserVO, message, 1);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysUserService.addUser(sysUserVO);
		if (b) { // 增加成功
			return "redirect:/rest/sysuser/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_user_resolve";
	}

	/**
	 * 跳转用户修改页面
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateUserPage(Model model, SYSUserVO sysUserVO) {
		if (sysUserVO.getId() == null) {
			return "404";
		}
		// 查询该用户所具有的角色id数组
		List<Integer> uRoleIds = sysUserService.getRoleIdsByUserId(sysUserVO.getId());
		sysUserVO.setRoleIds(uRoleIds);

		// 查询该用户具有的app平台的ID数组
		List<Integer> uAppIds = sysUserService.getAppIdsByUserId(sysUserVO.getId());
		sysUserVO.setAppIds(uAppIds);

		// 查询该用户的基本信息 封装到UserVO中
		User user = sysUserService.getUserByUserId(sysUserVO.getId());
		if (user == null) {
			return "404";
		}
		// 将用户信息封装到UserVO中
		sysUserVO.setUserProperty(user);

		model.addAttribute("u", sysUserVO);
		// 查询所有的角色和app平台
		model.addAttribute("roles", sysRoleService.findAllRoles());
		model.addAttribute("apps", appInfoService.getAllApp());
		return "sys_user_resolve";
	}

	// 用户修改提交
	@RequestMapping(value = "/updateuser", method = { RequestMethod.GET })
	public String updateUser(Model model, @ModelAttribute(value = "u") SYSUserVO sysUserVO) {
		model.addAttribute("roles", sysRoleService.findAllRoles());
		model.addAttribute("apps", appInfoService.getAllApp());
		String message = null;
		String validate = validateForUpdateAndInsert(model, sysUserVO, message, 2);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysUserService.updateUser(sysUserVO);
		if (b) { // 修改成功
			// 修改成功后  强制该用户重新登录
			sysService.clearUserShiroSessionByUserName(sysUserVO.getUsername());
			return "redirect:/rest/sysuser/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_user_resolve";
	}

	// 删除用户
	@RequestMapping(value = "/deleteuser", method = { RequestMethod.GET })
	public String deleteUser(Integer id) {
		if (id == null) {
			return "404";
		}
		User user = sysUserService.getUserByUserId(id.longValue());
		Boolean b = sysUserService.deleteUser(id);
		if(b) {
			sysService.clearUserShiroSessionByUserName(user.getUsername());
		}
		return "redirect:/rest/sysuser/list";
	}

}
