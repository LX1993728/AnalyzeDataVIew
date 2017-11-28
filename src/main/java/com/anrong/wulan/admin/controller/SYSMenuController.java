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

import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.service.SYSMenuService;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.vo.SYSMenuVO;
import com.anrong.wulan.core.util.Page;

/**
 * 菜单管理的控制器
 * 
 * @author liuxun
 *
 */
@Controller
@RequiresPermissions("setting:menu")
@RequestMapping(value = "/sysmenu")
public class SYSMenuController {
	@Autowired
	private SYSMenuService sysMenuService;
	
	@Autowired
	private SYSService sysService;

	/**
	 * 菜单信息列表显示
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getSYSMenus(Model model, @ModelAttribute(value = "m") SYSMenuVO sysMenuVO) {
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		sysMenuVO.setPageSize(10);
		Page<SYSMenuVO> menus = sysMenuService.getMenusByCriteria(sysMenuVO);
		List<SYSMenu> pmenus = sysMenuService.getLevalOneMenus();
		model.addAttribute("page", menus);
		model.addAttribute("pmenus", pmenus);
		return "sys_menu";
	}

	/**
	 * 新增菜单页面
	 * 
	 * @param model
	 * @param sysMenuVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String addMenuPage(Model model, SYSMenuVO sysMenuVO) {
		if (sysMenuVO.getId() != null) {
			return "404";
		}

		List<SYSMenu> pmenus = sysMenuService.getLevalOneMenus();
		model.addAttribute("pmenus", pmenus);
		return "sys_menu_resolve";
	}

	/**
	 * 跳转到菜单修改页面
	 * 
	 * @param model
	 * @param sysMenuVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String updatePage(Model model, SYSMenuVO sysMenuVO) {
		if (sysMenuVO.getId() == null) {
			return "404";
		}
		// 根据主键查询具体菜单的信息
		SYSMenu sysMenu = sysMenuService.getMenuByPrimaryKey(sysMenuVO.getId());
		model.addAttribute("m", sysMenu);
		List<SYSMenu> pmenus = sysMenuService.getLevalOneMenus();
		model.addAttribute("pmenus", pmenus);
		return "sys_menu_resolve";
	}

	/**
	 * 新增菜单提交
	 * 
	 * @param model
	 * @param sysMenuVO
	 * @return
	 */
	@RequestMapping(value = "/addmenu", method = { RequestMethod.POST })
	public String addMenuSubmit(Model model, @ModelAttribute(value = "m") SYSMenuVO sysMenuVO) {
		String message = null;
		List<SYSMenu> pmenus = sysMenuService.getLevalOneMenus();
		model.addAttribute("pmenus", pmenus);
		String validate = validateForUpdateAndInsert(model, sysMenuVO, 1);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysMenuService.addMenu(sysMenuVO);
		if (b) { // 增加成功
			sysService.clearAllUserShiroSessions();
			return "redirect:/rest/sysmenu/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_menu_resolve";
	}

	/**
	 * 修改菜单提交
	 * 
	 * @param model
	 * @param sysMenuVO
	 * @return
	 */
	@RequestMapping(value = "/updatemenu", method = { RequestMethod.POST })
	public String updateMenuSubmit(Model model, @ModelAttribute(value = "m") SYSMenuVO sysMenuVO) {
		String message = null;
		List<SYSMenu> pmenus = sysMenuService.getLevalOneMenus();
		model.addAttribute("pmenus", pmenus);
		String validate = validateForUpdateAndInsert(model, sysMenuVO, 2);
		if (validate != null) {
			return validate;
		}
		Boolean b = sysMenuService.updateMenu(sysMenuVO);
		if (b) { // 修改成功
			sysService.clearAllUserShiroSessions();
			return "redirect:/rest/sysmenu/list";
		}
		message = "系统内部错误";
		model.addAttribute("message", message);
		return "sys_menu_resolve";
	}

	/**
	 * 删除菜单提交
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletemenu", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, String> deleteMenuSubmit(Integer id) {
		 Map<String, String> result = new HashMap<>();
		if (id==null) {
			result.put("message", "该菜单不存在");
			return result;
		}
		if (sysMenuService.isBindRoles(id)) {
			result.put("message", "该菜单已被角色关联，不可删除！");
			return result;
		}
		if (sysMenuService.isHasChildMenus(id)) {
			result.put("message", "该菜单下有子菜单，不可删除！");
			return result;
		}
		if (!sysMenuService.deleteMenu(id)) {
			result.put("message", "服务器内部出错");
			return result;
		}else {
			sysService.clearAllUserShiroSessions();
			result.put("message", "成功删除该菜单");
			return result;
		}
	}
	
	
	
	/**
	 * 修改和提交校验
	 * 
	 * @param model
	 * @param sysMenuVO
	 * @param i
	 * @return
	 */
	private String validateForUpdateAndInsert(Model model, SYSMenuVO sysMenuVO, int i) {
		if (sysMenuVO.getName() == null || sysMenuVO.getName().trim().length() == 0) {
			model.addAttribute("message", "菜单名称不能为空或空格");
			return "sys_menu_resolve";
		}

		// 判断菜单名是否重复
		// 首先获取所有的菜单名称
		List<String> menuNames = sysMenuService.getAllMenuNames();
		if (i == 1 && menuNames.contains(sysMenuVO.getName())) { // 对于新增而言
			model.addAttribute("message", "该菜单名称已经存在");
			return "sys_menu_resolve";
		}

		SYSMenu sm = sysMenuVO.getId() == null ? null : sysMenuService.getMenuByPrimaryKey(sysMenuVO.getId());
		if (sm!=null && sysMenuVO.getPid() == null) { // 因为页面组件禁用后 会返回null 
			sysMenuVO.setPid(sm.getPid());
		}
		if (i == 2 && sm != null
				&& (!sm.getName().equals(sysMenuVO.getName()) && menuNames.contains(sysMenuVO.getName()))) { // 对于修改而言
			model.addAttribute("message", "该菜单名称已经存在");
			return "sys_menu_resolve";
		}

		if (sysMenuVO.getUrl() == null || sysMenuVO.getUrl().trim().length() == 0) {
			model.addAttribute("message", "菜单URL不能为空或空格 若没有链接可设置为 \"-\"");
			return "sys_menu_resolve";
		}
		if (sysMenuVO.getPid() != null && sysMenuVO.getPid() == -1) {
			model.addAttribute("message", "请选择所属菜单");
			return "sys_menu_resolve";
		}
		return null;
	}
}
