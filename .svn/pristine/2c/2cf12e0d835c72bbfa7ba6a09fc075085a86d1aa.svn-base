package com.anrong.wulan.admin;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anrong.wulan.admin.dao.SYSPermissionAndMenuMapperCustom;
import com.anrong.wulan.admin.dao.SYSUserCustomMapper;
import com.anrong.wulan.admin.dao.UserAppMapper;
import com.anrong.wulan.admin.dao.UserMapper;
import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.po.UserApp;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.service.SYSUserService;
import com.anrong.wulan.admin.vo.SYSMenuVO;
import com.anrong.wulan.admin.vo.SYSUserVO;
import com.anrong.wulan.core.util.Page;

/**
 * junit测试Service
 * 
 * @author liuxun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" }) // 加载配置文件
public class JunitTestSYSUser {

	private final static Logger log = LoggerFactory.getLogger(JunitTestSYSUser.class);
	@Autowired
	private SYSUserService sysUserService;

	@Autowired
	private SYSUserCustomMapper sysUserCustomMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserAppMapper userAppMapper;

	@Test
	public void test1() throws Exception {
		SYSUserVO sysUserVO = new SYSUserVO();
		sysUserVO.setUsername("a");
		// sysUserVO.setRoleId(2);
		Integer size = sysUserCustomMapper.findUserCountByCriteria(sysUserVO);
		System.out.println("==========" + size);

		List<User> list = sysUserCustomMapper.findUserListByCriteria(sysUserVO);
		for (User user : list) {
			System.out.println("======" + user.getId() + "=====" + user.getUsername() + "=====" + user.getCreateTime());
		}
	}

	@Test
	public void test2() throws Exception {
		SYSUserVO sysUserVO = new SYSUserVO();
		sysUserVO.setUsername("a");
		sysUserVO.setPageSize(1);
		sysUserVO.setP(2);
		Page<User> page = sysUserService.getUsersByCriteria(sysUserVO);
		System.out.println(page.getStart() + "=======" + page.getPageNo() + "=======" + page.getTotalPages());
	}

	@Test
	public void test3() { // 原始开发的mapper不能反悔插入的ID
		User user = new User();
		user.setCreateTime(new Date());
		user.setPassword("123456");
		user.setState("1");
		user.setUsername("XXXX");
		int insert = userMapper.insert(user);
		log.info("====={}=========={}", insert, user.getId());
	}

	@Test
	public void test4() {
		SYSUserVO sysUserVO = new SYSUserVO();
		sysUserVO.setId(2L);
		List<Integer> rolesByUserId = sysUserService.getRoleIdsByUserId(2L);
		for (Integer id : rolesByUserId) {
			log.info("====={}==========", id);
		}
	}

	@Test
	public void test5() {
//		 log.info("====={}==========",userAppMapper.deleteByPrimaryKey(26L));
		List<UserApp> list = userAppMapper.selectByUserId(9L);
		log.info("========{}=========",list.size());
	}
}
