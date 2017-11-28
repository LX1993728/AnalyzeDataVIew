package com.anrong.wulan.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.SYSPermissionMapper;
import com.anrong.wulan.admin.dao.SYSRole_PermissionMapper;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.SYSPermissionExample;
import com.anrong.wulan.admin.po.SYSPermissionExample.Criteria;
import com.anrong.wulan.admin.po.SYSRole_PermissionExample;
import com.anrong.wulan.admin.service.SYSPermissionService;
import com.anrong.wulan.admin.vo.SYSPermissionVO;
import com.anrong.wulan.core.util.Page;

/**
 * 权限资源业务逻辑
 * 
 * @author liuxun
 *
 */

@Service
@Transactional
public class SYSPermissionServiceImpl implements SYSPermissionService {

	@Autowired
	private SYSPermissionMapper sysPermissionMapper;

	@Autowired
	private SYSRole_PermissionMapper sysRole_PermissionMapper;

	@Override
	public List<SYSPermission> findAllPerms() {
		List<SYSPermission> list = sysPermissionMapper.selectByExample(new SYSPermissionExample());
		return list;
	}

	@Override
	public Page<SYSPermission> getPermsByCriteria(SYSPermissionVO sysPermissionVO) {
		// 当前要查询的下标位置
		Integer offset = (sysPermissionVO.getP() - 1) * sysPermissionVO.getPageSize();
		sysPermissionVO.setOffset(offset);
		SYSPermissionExample example = new SYSPermissionExample();
		Criteria criteria = example.createCriteria();
		if (sysPermissionVO.getName() != null && sysPermissionVO.getName().trim().length() > 0) {
			criteria.andNameLike("%" + sysPermissionVO.getName().trim() + "%");
		}
		if (sysPermissionVO.getCode() != null && sysPermissionVO.getCode().trim().length() > 0) {
			criteria.andCodeLike("%" + sysPermissionVO.getCode().trim() + "%");
		}
		// 获取符合条件的总数量
		int count = sysPermissionMapper.countByExample(example);
		// 获取符合条件的记录数据
		example.setCount(sysPermissionVO.getPageSize());
		example.setLimitStart(sysPermissionVO.getOffset());
		List<SYSPermission> permissions = sysPermissionMapper.selectByExample(example);
		Page<SYSPermission> page = new Page<>(sysPermissionVO.getP(), sysPermissionVO.getPageSize(), count);
		page.setItems(permissions);
		return page;
	}

	@Override
	public SYSPermission getPermissionByPrimaryKey(Integer id) {
		SYSPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(id);
		return sysPermission;
	}

	@Override
	public List<String> getAllCodes() {

		return sysPermissionMapper.getAllCodes();
	}

	@Override
	public Boolean updatePermission(SYSPermissionVO sysPermissionVO) {
		if (sysPermissionVO.getId() == null) {
			return false;
		}
		int result = sysPermissionMapper.updateByPrimaryKeySelective(sysPermissionVO); 
		return result > 0;
	}

	@Override
	public Boolean addPermission(SYSPermissionVO sysPermissionVO) {
		int result = sysPermissionMapper.insertSelective(sysPermissionVO);
		return result > 0;
	}

	@Override
	public boolean isBindRoles(Integer id) {
		SYSRole_PermissionExample example = new SYSRole_PermissionExample();
		example.createCriteria().andPeridEqualTo(id);
		int count = sysRole_PermissionMapper.countByExample(example);
		return count > 0;
	}

	@Override
	public boolean deletePermission(Integer id) {
		return sysPermissionMapper.deleteByPrimaryKey(id) > 0;
	}

}
