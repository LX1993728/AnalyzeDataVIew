package com.anrong.wulan.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.SYSMenuMapper;
import com.anrong.wulan.admin.dao.SYSRole_MenuMapper;
import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSMenuExample;
import com.anrong.wulan.admin.po.SYSMenuExample.Criteria;
import com.anrong.wulan.admin.po.SYSRole_Menu;
import com.anrong.wulan.admin.po.SYSRole_MenuExample;
import com.anrong.wulan.admin.service.SYSMenuService;
import com.anrong.wulan.admin.vo.SYSMenuVO;
import com.anrong.wulan.core.util.Page;

/**
 * 菜单业务逻辑
 * 
 * @author liuxun
 *
 */
@Service
@Transactional
public class SYSMenuServiceImpl implements SYSMenuService {

	@Autowired
	private SYSMenuMapper sysMenuMapper;

	@Autowired
	private SYSRole_MenuMapper sysRole_MenuMapper;

	@Override
	public List<SYSMenu> findAllMenus() {
		SYSMenuExample example = new SYSMenuExample();
		example.createCriteria().andIdNotEqualTo(1);
		List<SYSMenu> list = sysMenuMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<SYSMenu> findMenusByRoleId(Integer id) {
		List<SYSMenu> sysMenus = new ArrayList<>();
		SYSRole_MenuExample smExample = new SYSRole_MenuExample();
		smExample.createCriteria().andRoleidEqualTo(id);
		List<SYSRole_Menu> sysRole_Menus = sysRole_MenuMapper.selectByExample(smExample);
		for (SYSRole_Menu sysRole_Menu : sysRole_Menus) {
			SYSMenu sysMenu = sysMenuMapper.selectByPrimaryKey(sysRole_Menu.getMenuid());
			if (sysMenu.getId() != 1) {
				sysMenus.add(sysMenu);
			}
		}
		return sysMenus;
	}

	@Override
	public Page<SYSMenuVO> getMenusByCriteria(SYSMenuVO sysMenuVO) {
		// 当前要查询的下标位置
		Integer offset = (sysMenuVO.getP() - 1) * sysMenuVO.getPageSize();
		sysMenuVO.setOffset(offset);
		SYSMenuExample sysMenuExample = new SYSMenuExample();
		Criteria criteria = sysMenuExample.createCriteria();
		criteria.andIdNotEqualTo(1);
		if (sysMenuVO.getName() != null && sysMenuVO.getName().trim().length() > 0) {
			criteria.andNameLike("%" + sysMenuVO.getName().trim() + "%");
		}
		if (sysMenuVO.getPid() != null && sysMenuVO.getPid() != -1) {
			criteria.andPidEqualTo(sysMenuVO.getPid());
		}
		// 查询符合条件记录的总条数(数量)
		int count = sysMenuMapper.countByExample(sysMenuExample);
		// 查询符合条件的记录数据
		sysMenuExample.setCount(sysMenuVO.getPageSize());
		sysMenuExample.setLimitStart(sysMenuVO.getOffset());
		List<SYSMenu> sysMenus = sysMenuMapper.selectByExample(sysMenuExample);
		List<SYSMenuVO> sysMenuVOs = new ArrayList<>();
		for (SYSMenu sysMenu : sysMenus) {
			SYSMenuVO sv = new SYSMenuVO();
			sv.copyMenuProperty(sysMenu);
			// 查询父菜单的名称
			String pname = sysMenuMapper.selectByPrimaryKey(sysMenu.getPid()).getName();
			sv.setPname(pname);
			sv.setLevel(sv.getPid().intValue()==1?"一级菜单":"二级菜单");
			sysMenuVOs.add(sv);
		}
		Page<SYSMenuVO> page = new Page<>(sysMenuVO.getP(), sysMenuVO.getPageSize(), count);
		page.setItems(sysMenuVOs);
		return page;
	}

	@Override
	public List<SYSMenu> getLevalOneMenus() {
		SYSMenuExample example = new SYSMenuExample();
		List<Integer> array = new ArrayList<>();
		array.add(0); // 系统菜单（根菜单）
		array.add(1); // 一级菜单
		example.createCriteria().andPidIn(array);
		List<SYSMenu> list = sysMenuMapper.selectByExample(example);
		return list;
	}

	@Override
	public SYSMenu getMenuByPrimaryKey(Integer id) {
		return sysMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<String> getAllMenuNames() {
		return sysMenuMapper.getAllMenuNames();
	}

	@Override
	public Boolean addMenu(SYSMenuVO sysMenuVO) {
		SYSMenu sysMenu = new SYSMenu();
		sysMenu.setName(sysMenuVO.getName());
		sysMenu.setIconstyle(sysMenuVO.getIconstyle());
		sysMenu.setUrl(sysMenuVO.getUrl());
		// 判断设置的父菜单是否合法
		Boolean flag = false;
		List<SYSMenu> levalOneMenus = this.getLevalOneMenus();
		for (SYSMenu pmenu : levalOneMenus) {
			if (sysMenuVO.getPid().intValue() == pmenu.getId().intValue()) {
				flag = true;
			}
		}
		// 设置所属菜单原则为：父菜单只能为系统根菜单或一级菜单
		sysMenu.setPid(flag ? sysMenuVO.getPid() : 1); // 如果设置的父菜单不合法，默认修改为一级菜单
		int result = sysMenuMapper.insertSelective(sysMenu);
		return result > 0;
	}

	@Override
	public Boolean updateMenu(SYSMenuVO sysMenuVO) {
		if (sysMenuVO.getId() == 1) { // 不能对根菜单做任何操作
			return false;
		}
		SYSMenu sysMenu = new SYSMenu();
		sysMenu.setName(sysMenuVO.getName());
		sysMenu.setIconstyle(sysMenuVO.getIconstyle());
		sysMenu.setUrl(sysMenuVO.getUrl());
		sysMenu.setId(sysMenuVO.getId());

		// 如果是一级菜单，则不能更改父菜单(因为涉及到一级菜单有很多子菜单)
		if (sysMenuVO.getPid() == 1) {
			sysMenu.setPid(null); // 设置为null 默认不修改原来的值
		} else { // 如果是二级菜单，则判断设置的父菜单是否合法
			// 判断设置的父菜单是否合法
			Boolean flag = false;
			List<SYSMenu> levalOneMenus = this.getLevalOneMenus();
			for (SYSMenu pmenu : levalOneMenus) {
				if (sysMenuVO.getPid().intValue() == pmenu.getId().intValue()) {
					flag = true;
				}
			}
			// 设置所属菜单原则为：父菜单只能为系统根菜单或一级菜单
			sysMenu.setPid(flag ? sysMenuVO.getPid() : null); // 如果设置的父菜单不合法，默认不做任何修改
		}
		int result = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
		return result > 0;
	}

	@Override
	public boolean isBindRoles(Integer id) {
		SYSRole_MenuExample example = new SYSRole_MenuExample();
		example.createCriteria().andMenuidEqualTo(id);
		int count = sysRole_MenuMapper.countByExample(example);
		return count > 0;
	}

	@Override
	public boolean isHasChildMenus(Integer id) {
		SYSMenuExample example = new SYSMenuExample();
		example.createCriteria().andPidEqualTo(id);
		int count = sysMenuMapper.countByExample(example);
		return count > 0;
	}

	@Override
	public boolean deleteMenu(Integer id) {
		int count = sysMenuMapper.deleteByPrimaryKey(id);
		return count > 0;
	}

}
