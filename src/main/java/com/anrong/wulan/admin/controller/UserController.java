package com.anrong.wulan.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.Role;
import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.service.RoleService;
import com.anrong.wulan.admin.service.UserService;
import com.anrong.wulan.core.entity.Result;
import com.anrong.wulan.core.util.StringKit;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 用户控制器
 * 
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user, BindingResult result, Model model,
			HttpServletRequest request) {

		try {
			Subject subject = SecurityUtils.getSubject();
			// 已登陆则 跳到首页
			if (subject.isAuthenticated()) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			// 身份验证
			UsernamePasswordToken token = new UsernamePasswordToken(
					user.getUsername(), user.getPassword());
			subject.login(token);

		} catch (AuthenticationException e) {
			String errorMsg = e.getMessage();
			if (e instanceof IncorrectCredentialsException) {
				errorMsg = "用户名或密码错误!";
			}
			if (e instanceof UnknownAccountException) {
				errorMsg = "用户名或密码错误!";
			}
			// 身份验证失败
			model.addAttribute("error", errorMsg);
			return "login";
		}
		return "redirect:/";
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	/**
	 * 分页查询
	 * 
	 * @param offset
	 *            记录起始
	 * @param limit
	 *            页面大小
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public Map query(int offset, int limit, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();

		int page = offset / limit + 1;
		PageBounds pageBounds = new PageBounds(page, limit);

		Map<String, Object> param = new HashMap<String, Object>();
		// 获得结果集条总数
		PageList pageList = (PageList) userService
				.selectPage(param, pageBounds);
		int total = pageList.getPaginator().getTotalCount();
		result.put("total", total);
		result.put("rows", (List<User>) pageList);
		return result;
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 *            用户
	 * @param roleIds
	 *            角色集合
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Result create(User user, HttpServletRequest request) {
		Result result = new Result();
		String[] roleIds = request.getParameterValues("roleIds");
		if (StringUtils.isEmpty(user.getUsername())) {
			result.setMessage("用户名角色名称不能为空");
			return result;
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			result.setMessage("密码不能为空");
			return result;
		}

		if (roleIds == null || roleIds.length == 0) {
			result.setMessage("用户角色不能为空");
			return result;
		}
		user.setId(null);
		user.setPassword(new Sha256Hash(user.getPassword()).toHex());
		user.setCreateTime(new Date());
		User exist = userService.selectByUsername(user.getUsername());
		if (exist != null) {
			result.setSuccess(false);
			result.setMessage("新增失败,用户名已被使用！");
			return result;
		}

		boolean i = userService.insert(user,
				StringKit.converStrToLongCollections(roleIds));
		result.setSuccess(i);
		if (i) {
			result.setMessage("新增成功");
		} else {
			result.setMessage("新增失败");
		}
		return result;
	}

	/**
	 * 更新用户
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Result update(User user, HttpServletRequest request) {
		String[] roleIds = request.getParameterValues("roleIds");
		Result result = new Result();
		if (user.getId() == null) {
			result.setMessage("参数为空");
			return result;
		}

		// 密码修改放在修改密码的模块修改
		user.setPassword(null);

		if (roleIds == null || roleIds.length == 0) {
			result.setMessage("用户角色不能为空");
			return result;
		}
		User exist = userService.selectByUsername(user.getUsername());
		if (exist != null && exist.getId() != user.getId()) {
			result.setSuccess(false);
			result.setMessage("更新失败,用户名已被使用！");
			return result;
		}
		boolean i = userService.update(user,
				StringKit.converStrToLongCollections(roleIds));
		result.setSuccess(i);
		if (i) {
			result.setMessage("更新成功");
		} else {
			result.setMessage("更新失败");
		}
		return result;
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public Result delete(User user) {
		Result result = new Result();
		if (user.getId() == null) {
			result.setMessage("参数为空");
		}
		int i = userService.delete(user.getId());
		result.setSuccess(i == 1);
		result.setMessage(i == 1 ? "删除成功" : "删除失败");
		return result;
	}

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryAllRole", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> queryAllRole() {
		return roleService.selectAll();
	}

	/**
	 * 查询用户关联角色
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryUserRole", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> queryUserRole(Long userId) {
		return roleService.selectRolesByUserId(userId);
	}

	public static void main(String[] args) {
		String aString = new Sha256Hash("654321").toHex();
		System.out.println(aString);
	}

}
