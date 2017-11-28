package com.anrong.wulan.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.StaticGroupMapper;
import com.anrong.wulan.admin.dao.StaticUserGroupMapper;
import com.anrong.wulan.admin.dao.StaticUserMapper;
import com.anrong.wulan.admin.po.StaticGroup;
import com.anrong.wulan.admin.po.StaticGroupExample;
import com.anrong.wulan.admin.po.StaticUser;
import com.anrong.wulan.admin.po.StaticUserExample;
import com.anrong.wulan.admin.po.StaticUserExample.Criteria;
import com.anrong.wulan.admin.po.StaticUserGroup;
import com.anrong.wulan.admin.po.StaticUserGroupExample;
import com.anrong.wulan.admin.service.StaticGroupService;
import com.anrong.wulan.admin.vo.StaticGroupVO;
import com.anrong.wulan.core.util.Page;

@Service
@Transactional
public class StaticGroupServiceImpl implements StaticGroupService {

	@Autowired
	private StaticGroupMapper staticGroupMapper;

	@Autowired
	private StaticUserMapper staticUserMapper;

	@Autowired
	private StaticUserGroupMapper staticUserGroupMapper;

	@Autowired
	private ThreadPoolTaskExecutor threadPool; // 异步处理 用于更新或新建时的查询

	private final static Logger log = LoggerFactory.getLogger(StaticGroupServiceImpl.class);

	@Override
	public Page<StaticGroup> getGroupsByCriteria(StaticGroupVO staticGroupVO) {
		// 当前要查询的下标位置
		Integer offset = (staticGroupVO.getP() - 1) * staticGroupVO.getPageSize();

		StaticGroupExample example = new StaticGroupExample();
		StaticGroupExample.Criteria criteria = example.createCriteria();
		if (staticGroupVO.getName() != null && staticGroupVO.getName().trim().length() > 0) {
			criteria.andNameLike("%" + staticGroupVO.getName().trim() + "%");
		}

		// 查询符合记录的总条数
		int count = staticGroupMapper.countByExample(example);

		// 查询符合条件的记录数据
		example.setCount(staticGroupVO.getPageSize());
		example.setLimitStart(offset);

		List<StaticGroup> staticGroups = staticGroupMapper.selectByExample(example);
		Page<StaticGroup> page = new Page<>(staticGroupVO.getP(), staticGroupVO.getPageSize(), count);
		page.setItems(staticGroups);
		return page;
	}

	@Override
	public Boolean deleteGroup(Integer id) {
		int count1 = 0, count2 = 0;

		// 首先查找所有的用户-群组中间表 解除与当前群组有关联的用户
		StaticUserGroupExample example = new StaticUserGroupExample();
		example.createCriteria().andGidEqualTo(id.longValue());
		List<StaticUserGroup> userGroups = staticUserGroupMapper.selectByExample(example);
		for (StaticUserGroup staticUserGroup : userGroups) {
			count1 += staticUserGroupMapper.deleteByPrimaryKey(staticUserGroup.getId());
		}

		// 再删除该群组
		count2 += staticGroupMapper.deleteByPrimaryKey(id.longValue());
		return count1 == userGroups.size() && count2 == 1;
	}

	private void asyncByAddOrUpdateGroup(final StaticGroupVO staticGroupVO, final int type) {
		// 在创建群组的时候 type=0 ........
		// 在更新群组的时候 type=1 ........
		// 从线程池中抽取一个线程执行异步任务
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				// 抽取群组的条件，筛选统计用户
				StaticUserExample example = new StaticUserExample();
				Criteria criteria = example.createCriteria();
				if (staticGroupVO.getUserType() != null) { // 新增还是活跃
					criteria.andUserTypeEqualTo(staticGroupVO.getUserType());
				}
				if (staticGroupVO.getStartTime() != null && staticGroupVO.getEndTime() != null) {
					criteria.andStatisticTimeBetween(staticGroupVO.getStartTime(), staticGroupVO.getEndTime());
				}
				if (staticGroupVO.getUserSex() != null) {
					criteria.andSexEqualTo(staticGroupVO.getUserSex());
				}
				if (staticGroupVO.getUserProvince() != null) {
					criteria.andProvinceEqualTo(staticGroupVO.getUserProvince());
				}
				if (staticGroupVO.getUserMinAge() != null && staticGroupVO.getUserMaxAge() != null) {
					criteria.andAgeBetween(staticGroupVO.getUserMinAge(), staticGroupVO.getUserMaxAge());
				}
				if (staticGroupVO.getUserDevice() != null && staticGroupVO.getUserDevice().trim().length() > 0) {
					criteria.andDeviceTypeLike("%" + staticGroupVO.getUserDevice().trim() + "%");
				}
				if (staticGroupVO.getUserChannel() != null && staticGroupVO.getUserChannel().trim().length() > 0) {
					criteria.andChannelLike("%" + staticGroupVO.getUserChannel().trim() + "%");
				}

				List<StaticUser> staticUsers = staticUserMapper.selectByExample(example);

				Integer count = 0, count1 = 0, count2 = 0, count3 = 0;
				if (type == 1) { // 是更新操作
					// TODO: 更新操作时
					// 首先查询该群组 之前绑定的所有用户，全部解绑，再重新绑定
					StaticUserGroupExample exampleGroup = new StaticUserGroupExample();
					exampleGroup.createCriteria().andGidEqualTo(staticGroupVO.getId().longValue());
					List<StaticUserGroup> userGroups = staticUserGroupMapper.selectByExample(exampleGroup);
					count3 = userGroups.size();
					for (StaticUserGroup staticUserGroup : userGroups) {
						count += staticUserGroupMapper.deleteByPrimaryKey(staticUserGroup.getId());
					}
				}
				for (StaticUser staticUser : staticUsers) { // 从中间表中建立联系
					StaticUserGroup userGroup = new StaticUserGroup();
					userGroup.setUid(staticUser.getId());
					userGroup.setGid(staticGroupVO.getId());
					count1 += staticUserGroupMapper.insertSelective(userGroup);
				}
				if (count1.intValue() == staticUsers.size()) {
					StaticGroupVO groupVO = new StaticGroupVO();
					groupVO.setId(staticGroupVO.getId());
					// 修改该群组的状态
					groupVO.setStatus(1);
					// 修改该群组的人数
					groupVO.setTotal(count1.longValue());
					// 修改该群组的更新时间
					groupVO.setUpdatetime(new Date());
					count2 += staticGroupMapper.updateByPrimaryKeySelective(groupVO);
				}
				if (type == 0) { // 是添加操作
					if (count1.intValue() == staticUsers.size() && count2 == 1) {
						log.info("============异步线程执行成功====添加群组关系=======群组ID：{1}=======", staticGroupVO.getId());
					} else {
						log.error("============异步线程执行失败====添加群组关系=======群组ID：{1}=======", staticGroupVO.getId());
					}
				} else if (type == 1) {
					if (count == count3 && count1.intValue() == staticUsers.size() && count2 == 1) {
						log.info("============异步线程执行成功====修改群组关系=======群组ID：{1}=======", staticGroupVO.getId());
					} else {
						log.error("============异步线程执行失败====修改群组关系=======群组ID：{1}=======", staticGroupVO.getId());
					}
				}
			}
		}, 6000);
	}

	@Override
	public Boolean addGroupByGroupVO(StaticGroupVO staticGroupVO) {
		try {
			if ("地区".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserProvince(staticGroupVO.getDetails());
			}
			if ("性别".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserSex(staticGroupVO.getDetails().equals("男") ? 0 : 1);
			}
			if ("年龄".equals(staticGroupVO.getProperty())) {
				String[] s = staticGroupVO.getDetails().split("-");
				staticGroupVO.setUserMinAge(Integer.parseInt(s[0]));
				staticGroupVO.setUserMaxAge(Integer.parseInt(s[1]));
			}
			if ("渠道".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserChannel(staticGroupVO.getDetails());
			}
			if ("设备".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserDevice(staticGroupVO.getDetails());
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			staticGroupVO.setTotal(0l);
			staticGroupVO.setStartTime(dateFormat.parse(staticGroupVO.getStartDate()));
			staticGroupVO.setEndTime(dateFormat.parse(staticGroupVO.getEndDate()));
			staticGroupVO.setStatus(0);
			staticGroupVO.setUpdatetime(new Date());
			int insert = staticGroupMapper.insertSelective(staticGroupVO);
			System.out.println("=====新建群组的ID为======" + staticGroupVO.getId());
			if (insert > 0) { // 执行异步操作
				asyncByAddOrUpdateGroup(staticGroupVO, 0);
			}
			return insert > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public StaticGroup getGoupByID(Long id) {
		StaticGroupExample example = new StaticGroupExample();
		com.anrong.wulan.admin.po.StaticGroupExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<StaticGroup> list = staticGroupMapper.selectByExample(example);
		if(list.size() > 0 && list != null){
			StaticGroup staticGroup = list.get(0);
			return staticGroup;
		}
		return new StaticGroup();
	}
	
	@Override
	public Boolean updateGroupByGroupVO(StaticGroupVO staticGroupVO) {
		try {
			if ("地区".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserProvince(staticGroupVO.getDetails());
			}
			if ("性别".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserSex(staticGroupVO.getDetails().equals("男") ? 0 : 1);
			}
			if ("年龄".equals(staticGroupVO.getProperty())) {
				String[] s = staticGroupVO.getDetails().split("-");
				staticGroupVO.setUserMinAge(Integer.parseInt(s[0]));
				staticGroupVO.setUserMaxAge(Integer.parseInt(s[1]));
			}
			if ("渠道".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserChannel(staticGroupVO.getDetails());
			}
			if ("设备".equals(staticGroupVO.getProperty())) {
				staticGroupVO.setUserDevice(staticGroupVO.getDetails());
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			staticGroupVO.setTotal(0l);
			staticGroupVO.setStartTime(dateFormat.parse(staticGroupVO.getStartDate()));
			staticGroupVO.setEndTime(dateFormat.parse(staticGroupVO.getEndDate()));
			staticGroupVO.setStatus(0);
			staticGroupVO.setUpdatetime(new Date());
			int update = staticGroupMapper.updateByPrimaryKey(staticGroupVO);
			System.out.println("=====修改群组的ID为======" + staticGroupVO.getId());
			if (update > 0) { // 执行异步操作
				asyncByAddOrUpdateGroup(staticGroupVO, 1);
			}
			return update > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
