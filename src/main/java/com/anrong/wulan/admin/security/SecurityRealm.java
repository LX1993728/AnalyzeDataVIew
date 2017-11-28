package com.anrong.wulan.admin.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.service.PermissionService;
import com.anrong.wulan.admin.service.RoleService;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.service.UserService;
import com.anrong.wulan.admin.vo.ActiveUserVO;
import com.anrong.wulan.admin.vo.SYSMenuVO;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author liuxun
 *
 */
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Autowired
	private SYSService sysService;

	@Resource
	private RoleService roleService;

	@Resource
	private PermissionService permissionService;

	public SecurityRealm() {
		super.setName("SecurityRealm");
	}

	// 支持UsernamePasswordToken
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	/**
	 * 用户登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String originPass = new String( (char[])token.getCredentials());
		// 通过数据库进行验证
		final User authentication = userService.selectByUsername(username);
		if (authentication == null) {
			throw new UnknownAccountException();
		}
		if (!"1".equals(authentication.getState())) {
			throw new DisabledAccountException();
		}

		// 根据用户ID取出菜单
		List<SYSMenuVO> levelOneMenus = null;
		try {
			levelOneMenus = sysService.findLevelOneMenusByUserId(Integer.parseInt(authentication.getId().toString()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 用户密码
		String password = authentication.getPassword();
		
        
		// 构建用户权限菜单相关信息
		ActiveUserVO activeUserVO = new ActiveUserVO();
		activeUserVO.setUserId(Integer.parseInt(authentication.getId().toString()));
		activeUserVO.setUsername(authentication.getUsername());
		activeUserVO.setMenus(levelOneMenus);
		
		//在当前返回认证信息之前必须要断定一下是否可以登录成功（否则无法实现踢除操作，因为如果返回授权信息后再剔除就会连自己也踢掉）
//		if ((new SimpleHash("md5", originPass, null, 1)).toString().equals(password)) {
//			sysService.clearUserShiroSessionByUserName(activeUserVO.getUsername());
//		}
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUserVO, password,
				this.getName());
		
		return simpleAuthenticationInfo;
	}

	/**
	 * 用户权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		// 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
        // (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principals);
            SecurityUtils.getSubject().logout();
            return null;
        }
		
		// 获取身份信息
		ActiveUserVO activeUser = (ActiveUserVO) principals.getPrimaryPrincipal();
		// 用户id
		int userid = activeUser.getUserId();
		// 获取用户权限
		List<SYSPermission> permissionsList = null;
		try {
			permissionsList = sysService.findPermissionListByUserId(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 构建shiro授权信息
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 单独定义一个集合
		List<String> permissions = new ArrayList<String>();
		for (SYSPermission sysPermission : permissionsList) {
			// 将数据库中的权限标签放入集合
			permissions.add(sysPermission.getCode());
		}
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

}
