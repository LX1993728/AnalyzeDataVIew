package com.anrong.wulan.admin.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.SYSPermissionAndMenuMapperCustom;
import com.anrong.wulan.admin.dao.UserMapper;
import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.vo.ActiveUserVO;
import com.anrong.wulan.admin.vo.SYSMenuVO;

/**
 * 权限菜单的服务接口实现类
 * 
 * @author liuxun
 *
 */
@Service
@Transactional
public class SYSServiceImpl implements SYSService {
	@Autowired
	private SYSPermissionAndMenuMapperCustom sysPermissionAndMenuMapperCustom;

	@Override
	public List<SYSMenu> findMenuListByUserId(int userid) throws Exception {
		return sysPermissionAndMenuMapperCustom.findMenuListByUserId(userid);
	}

	@Override
	public List<SYSPermission> findPermissionListByUserId(int userid) throws Exception {
		return sysPermissionAndMenuMapperCustom.findPermissionListByUserId(userid);
	}

	@Override
	public List<SYSMenuVO> findLevelOneMenusByUserId(int userid) {
		// 先根据用户id查询所有的一级菜单
		List<SYSMenu> oneMenus = sysPermissionAndMenuMapperCustom.findLevelOneMenusByUserid(userid);
		List<SYSMenuVO> levelOneMenus = new ArrayList<>();
		for (SYSMenu oneMenu : oneMenus) {
			SYSMenuVO sysMenuVO = new SYSMenuVO();
			sysMenuVO.copyMenuProperty(oneMenu);
			// 查询用户一级菜单下所具有的二级菜单
			List<SYSMenu> twoMenus = sysPermissionAndMenuMapperCustom.findLevelTwoMenusbyUserIdAndParentId(userid,
					sysMenuVO.getId());
			sysMenuVO.setChildMenus(twoMenus);
			levelOneMenus.add(sysMenuVO);
		}
		return levelOneMenus;
	}

	private DefaultWebSessionManager getSessionManager() {
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
		return sessionManager;
	}

	@Override
	public void clearUserShiroSessionByUserName(String username) {
		DefaultWebSessionManager sessionManager = getSessionManager();
		Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();// 获取当前已登录的用户session列表
		for (Session session : sessions) {
			// 清除该用户以前登录时保存的session
			if (String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals(username)) {
				sessionManager.getSessionDAO().delete(session);
			}
		}
	}

	@Override
	public void clearAllUserShiroSessions() {
		Subject subject = SecurityUtils.getSubject();
		// 获取当前操作员的身份
		ActiveUserVO activeUser = (ActiveUserVO) subject.getPrincipal();
		DefaultWebSessionManager sessionManager = getSessionManager();
		Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();// 获取当前已登录的用户session列表
		for (Session session : sessions) {
			// 如果是当前操作者，则不能清除，否则每更改一个权限管理的操作 自己也会被强制下线
			if (!String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals(activeUser.getUsername())) {
				sessionManager.getSessionDAO().delete(session);
			}
		}
	}

}
