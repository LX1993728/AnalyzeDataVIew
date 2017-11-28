package com.anrong.wulan.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.StaticGroup;
import com.anrong.wulan.admin.service.StaticGroupService;
import com.anrong.wulan.admin.vo.StaticGroupVO;
import com.anrong.wulan.core.util.Page;

/**
 * 数据分析-用户分群控制器
 *
 * @author liuxun
 *
 */
@Controller
@RequestMapping(value = "/staticgroup")
public class StaticGroupController {

	@Autowired
	private StaticGroupService staticGroupService;

	@Autowired
	private ThreadPoolTaskExecutor threadPool;

	/**
	 * 展示群组列表
	 *
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getSYSUsers(Model model, @ModelAttribute(value = "sg") StaticGroupVO staticGroupVO) {
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		staticGroupVO.setPageSize(10);
		Page<StaticGroup> page = staticGroupService.getGroupsByCriteria(staticGroupVO);
		model.addAttribute("page", page);
		return "tenant_group";
	}
	
	@RequestMapping(value = "/deletegroup", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, String> deleteGroup(Integer id) {
		 Map<String, String> result = new HashMap<>();
		if (id==null) {
			result.put("message", "该群组不存在");
			return result;
		}
		if (staticGroupService.deleteGroup(id)) {
			result.put("message", "您已成功删除该群组");
			return result;
		}
		return result;
	}
	
	
	// 测试异步线程
	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	@ResponseBody
	public String getSYSUsers() {
		System.out.println("线程池最小线程容量："+ threadPool.getCorePoolSize());
		threadPool.execute(new Runnable() {
			
			@Override
			public void run() {
                 try {
					Thread.sleep(7000);
					for(int i=0;i<=100;i++) {
						System.out.println("=================="+i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		return "tenant_group";
	}
    /**
     * 跳转新增
     * @return
     */
    @RequestMapping(value = "/add", method = { RequestMethod.GET })
    public String toAddGroup(){
    	return "tenant_groupNew";
    }
    /**
     * 新建分群
     * @return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addGroup(StaticGroupVO groupVO){
    	Map<String, Object> result = new HashMap<>();
    	if(groupVO.getName() == "" || groupVO.getName() == null){
    		result.put("message", "群名称不能为空!");
    	}else if(groupVO.getUserType() == -1 || groupVO.getUserType() == null){
    		result.put("message", "请选择用户范围!");
    	}else if(groupVO.getProperty() == "" || groupVO.getProperty() == null){
    		result.put("message", "请选择用户属性!");
    	}else if(groupVO.getStartDate() == "" || groupVO.getEndDate() == ""){
    		result.put("message", "日期不能为空!");
    	}else if(groupVO.getDetails() == "" || groupVO.getDetails() == null){
    		result.put("message", "详情不能为空!");
    	}else{
    		Boolean b = staticGroupService.addGroupByGroupVO(groupVO);
    		result.put("b", b);
    	}
    	return result;
    }
    /**
     * 属性改变
     */
    @RequestMapping(value = "/property" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> property(String property){
    	Map<String, Object> map = new HashMap<>();
    	if("地区".equals(property)){
    		String[] str = {"北京","上海","广东","河北","河南"};
    		map.put("s", str);
    	};
    	if("性别".equals(property)){
    		String[] str = {"男","女"};
    		map.put("s", str);
    	};
    	if("年龄".equals(property)){
    		String[] str = {"15-20","21-25","25-30","30-40",};
    		map.put("s", str);
    	};
    	if("渠道".equals(property)){
    		String[] str = {"应用宝","机锋市场","酷安商店"};
    		map.put("s", str);
    	};
    	if("设备".equals(property)){
    		String[] str = {"小米5","vovi X9","三星 note8"};
    		map.put("s", str);
    	};
    	return map;
    }
    /**
     * 修改回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/update/{id}")
    public String update(@PathVariable Long id,Model model){
    	StaticGroup group = staticGroupService.getGoupByID(id);
    	Integer i = 0;
    	//地区
    	if(group.getUserProvince() != null && group.getUserProvince() != ""){
    		i = 1;
    	}
    	//性别
    	if(group.getUserSex() != null){
    		i = 2;
    	}
    	//年龄
    	if(group.getUserMinAge() != null && group.getUserMinAge() != null){
    		i = 3;
    	}
    	//渠道
    	if(group.getUserChannel() != null && group.getUserChannel() != ""){
    		i = 4;
    	}
    	//设备
    	if(group.getUserDevice() != null && group.getUserDevice() != ""){
    		i = 5;
    	}
    	model.addAttribute("flag", i);
    	model.addAttribute("g",group);
    	return "tenant_groupUpdate";
    }
    
    /**
     * 修改分群
     * @return
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateGroup(StaticGroupVO groupVO){
    	Map<String, Object> result = new HashMap<>();
    	if(groupVO.getName() == "" || groupVO.getName() == null){
    		result.put("message", "群名称不能为空!");
    	}else if(groupVO.getUserType() == -1 || groupVO.getUserType() == null){
    		result.put("message", "请选择用户范围!");
    	}else if(groupVO.getProperty() == "" || groupVO.getProperty() == null){
    		result.put("message", "请选择用户属性!");
    	}else if(groupVO.getStartDate() == "" || groupVO.getEndDate() == ""){
    		result.put("message", "日期不能为空!");
    	}else if(groupVO.getDetails() == "" || groupVO.getDetails() == null){
    		result.put("message", "详情不能为空!");
    	}else{
    		Boolean b = staticGroupService.updateGroupByGroupVO(groupVO);
    		result.put("b", b);
    	}
    	return result;
    }
}
