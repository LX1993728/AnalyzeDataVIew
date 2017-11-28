package com.anrong.wulan.admin.controller;

import java.util.ArrayList;
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

import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.SYSRole;
import com.anrong.wulan.admin.service.SYSMenuService;
import com.anrong.wulan.admin.service.SYSPermissionService;
import com.anrong.wulan.admin.service.SYSRoleService;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.vo.SYSRoleVO;
import com.anrong.wulan.core.util.Page;

/**
 * 系统角色管理控制器
 * 
 * @author liuxun
 *
 */
@Controller
@RequestMapping(value = "/sysrole")
@RequiresPermissions("setting:role")
public class SYSRoleController {
	@Autowired
	private SYSRoleService sysRoleService;

	@Autowired
	private SYSPermissionService sysPermissionService;

	@Autowired
	private SYSMenuService sysMenuService;
	
	@Autowired
	private SYSService sysService;

	/**
	 * 展示系统角色列表
	 *
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getSYSUsers(Model model, @ModelAttribute(value = "r") SYSRoleVO sysRoleVO) {
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		sysRoleVO.setPageSize(10);
		Page<SYSRole> roles = sysRoleService.getRolesByCriteria(sysRoleVO);
		model.addAttribute("page", roles);
		return "sys_role";
	}

	/**
	 * 跳转到新增角色页面
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String addPage(Model model, @ModelAttribute(value = "r") SYSRoleVO sysRoleVO) {
		if (sysRoleVO.getId() != null) {
			return "404";
		}
		model.addAttribute("perms", sysPermissionService.findAllPerms()); // 获取所有权限
		// model.addAttribute("menus", sysMenuService.findAllMenus()); // 获取所有菜单
		return "sys_role_resolve";
	}

	/**
	 * 跳转到修改角色页面
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String updatePage(Model model, SYSRoleVO sysRoleVO) {
		if (sysRoleVO.getId() == null) {
			return "404";
		}
		SYSRole s = sysRoleService.getRolesByPrimaryId(sysRoleVO.getId());
		sysRoleVO.setName(s.getName());
		sysRoleVO.setCode(s.getCode());
		sysRoleVO.setDescription(s.getDescription());
		// 获取当前角色所具有的所有权限
		List<SYSPermission> sysPermissions = sysRoleService.getPermissionsOfRole(sysRoleVO.getId());
		List<Integer> permIds = new ArrayList<>();
		for (SYSPermission sysPermission : sysPermissions) {
			permIds.add(sysPermission.getId());
		}
		sysRoleVO.setPermIds(permIds);
		model.addAttribute("r", sysRoleVO);
		model.addAttribute("perms", sysPermissionService.findAllPerms()); // 获取所有权限
		return "sys_role_resolve";
	}

	/**
	 * 获取系统的所有菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/menus", method = { RequestMethod.GET })
	@ResponseBody
	public List<SYSMenu> getMenus() {
		return sysMenuService.findAllMenus();
	}

	/**
	 * 获取对应角色下的菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/menusOfRole", method = { RequestMethod.GET })
	public @ResponseBody List<SYSMenu> getMenusOfRole(SYSRoleVO sysRoleVO) {
		if (sysRoleVO.getId() == null) {
			return new ArrayList<>();
		}
		return sysMenuService.findMenusByRoleId(sysRoleVO.getId());
	}

	/**
	 * 为系统添加角色
	 * @param model
	 * @param sysRoleVO
	 * @return
	 */
	@RequestMapping(value = "/addrole", method = { RequestMethod.POST })
	public String addRole(Model model, @ModelAttribute(value = "r") SYSRoleVO sysRoleVO) {
		model.addAttribute("perms", sysPermissionService.findAllPerms()); // 获取所有权限
		String message = null;
		String validate = validateForUpdateAndInsert(model, sysRoleVO, 1);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysRoleService.addRole(sysRoleVO);
		if (b) { // 增加成功
			sysService.clearAllUserShiroSessions();
			return "redirect:/rest/sysrole/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_role_resolve";
	}
	

	/**
	 * 角色修改提交
	 * @param model
	 * @param sysRoleVO
	 * @return
	 */
	@RequestMapping(value = "/updaterole", method = { RequestMethod.POST })
	public String updateUser(Model model, @ModelAttribute(value = "r") SYSRoleVO sysRoleVO) {
		model.addAttribute("perms", sysPermissionService.findAllPerms()); // 获取所有权限
		String message = null;
		String validate = validateForUpdateAndInsert(model, sysRoleVO, 2);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysRoleService.updateRole(sysRoleVO);
		if (b) { // 修改成功
			sysService.clearAllUserShiroSessions();
			return "redirect:/rest/sysrole/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_role_resolve";
	}
	
	@RequestMapping(value = "/deleterole", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, String> deleteRole(Integer id) {
		 Map<String, String> result = new HashMap<>();
		if (id==null) {
			result.put("message", "该角色不存在");
			return result;
		}
		if (sysRoleService.isBindUsers(id)) {
			result.put("message", "该角色已被用户关联，不可删除！");
			return result;
		}
		if (!sysRoleService.deleteRole(id)) {
			result.put("message", "服务器内部出错");
			return result;
		}else {
			sysService.clearAllUserShiroSessions();
			result.put("message", "成功删除该角色");
			return result;
		}
	}

	private String validateForUpdateAndInsert(Model model, SYSRoleVO sysRoleVO, int i) { // i：1表示新增时提交表单的校验 2 修改提交
		if (sysRoleVO.getName() == null || sysRoleVO.getName().trim().length() == 0) {
			model.addAttribute("message", "角色名称不能为空或空格");
			return "sys_role_resolve";
		}

		if (sysRoleVO.getCode() == null || sysRoleVO.getCode().trim().length() == 0) {
			model.addAttribute("message", "角色编码不能为空或空格");
			return "sys_role_resolve";
		}

		// 获取所有的角色(因为角色一般不多 可以全部获取)
		List<SYSRole> findAllRoles = sysRoleService.findAllRoles();
		// 获取名称数组和编码数组
		List<String> roleNames = new ArrayList<>();
		List<String> roleCodes = new ArrayList<>();
		for (SYSRole sysRole : findAllRoles) {
			roleNames.add(sysRole.getName());
			roleCodes.add(sysRole.getCode());
		}
		// 如果是修改，则需要获取该角色原始数据
		SYSRole s = sysRoleVO.getId() == null ? null : sysRoleService.getRolesByPrimaryId(sysRoleVO.getId());

		// 新增
		if (i == 1 && roleNames.contains(sysRoleVO.getName())) {
			model.addAttribute("message", "该角色名已经存在");
			return "sys_role_resolve";
		}

		if (i == 1 && roleCodes.contains(sysRoleVO.getCode())) {
			model.addAttribute("message", "该角色编码已经存在");
			return "sys_role_resolve";
		}

		// 修改
		if (i == 2 && s != null
				&& (!s.getName().equals(sysRoleVO.getName()) && !roleNames.contains(sysRoleVO.getName()))) {
			model.addAttribute("message", "该角色名已经存在");
			return "sys_role_resolve";
		}

		if (i == 2 && s != null
				&& (!s.getCode().equals(sysRoleVO.getCode()) && !roleCodes.contains(sysRoleVO.getCode()))) {
			model.addAttribute("message", "该角色编码已经存在");
			return "sys_role_resolve";
		}

		if (sysRoleVO.getPermIds().size() == 0) {
			model.addAttribute("message", "请至少分配一个资源");
			return "sys_role_resolve";
		}

		if (sysRoleVO.getMenuIds().size() == 0) {
			model.addAttribute("message", "请至少分配一个菜单");
			return "sys_role_resolve";
		}

		return null;
	}

}
