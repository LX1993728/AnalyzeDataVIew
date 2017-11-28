package com.anrong.wulan.admin;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anrong.wulan.admin.dao.SYSPermissionAndMenuMapperCustom;
import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.service.SYSService;
import com.anrong.wulan.admin.vo.SYSMenuVO;
/**
 * junit测试Service
 * @author liuxun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations={"classpath:spring/spring-context.xml"}) //加载配置文件   
public class JunitTestPermAndMenu {
  @Autowired
  private SYSService sysService;
  
  @Autowired
  private SYSPermissionAndMenuMapperCustom sysMapper;
  
  @Test
  public void test1() throws Exception {
	  List<SYSMenu> menus = sysService.findMenuListByUserId(1);
	  List<SYSPermission> permissions = sysService.findPermissionListByUserId(1);
	  for (SYSPermission sysPermission : permissions) {
		System.out.println(sysPermission.getName()+"--------"+sysPermission.getCode());
	}
	  for (SYSMenu menu : menus) {
		System.out.println(menu.getName()+"-----"+menu.getId()+"----"+menu.getPid()+"------"+menu.getUrl()+"--------"+menu.getIconstyle());
	}
  }
  
  @Test
  public void test2() throws Exception {
	  List<SYSMenuVO> menus = sysService.findLevelOneMenusByUserId(1);
	  for (SYSMenuVO menu : menus) {
		  System.out.println(menu.getName()+"-----"+menu.getId()+"----"+menu.getPid()+"------"+menu.getUrl());
		  
		  for(SYSMenu twoMenu:menu.getChildMenus()) {
			  System.out.println("\t"+twoMenu.getName()+"-----"+twoMenu.getId()+"----"+twoMenu.getPid()+"------"+twoMenu.getUrl());
		  }
	  }
//	  List<SYSMenu> menus = sysMapper.findLevelTwoMenusbyUserIdAndParentId(1, 100);
//	  for (SYSMenu menu : menus) {
//		  System.out.println(menu.getName()+"-----"+menu.getId()+"----"+menu.getPid()+"------"+menu.getUrl());
//	  }
	
  }
}
