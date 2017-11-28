package com.anrong.wulan.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anrong.wulan.admin.po.AnalyzePDetail;
import com.anrong.wulan.admin.po.AnalyzePage;
import com.anrong.wulan.admin.service.ANALYPageService;
import com.anrong.wulan.admin.vo.ANALYPageDetailVO;
import com.anrong.wulan.admin.vo.ANALYPageInOutVO;
import com.anrong.wulan.admin.vo.ANALYPageVO;
import com.anrong.wulan.core.util.Page;

/**
 * 页面分析控制器
 * 
 * @author liuxun
 *
 */
@Controller
@RequestMapping(value = "/analypage")
public class ANALYPageController {
	@Autowired
	private ANALYPageService analyPageService;

	/**
	 * 展示系统角色列表
	 *
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getPages(Model model, @ModelAttribute(value = "ap") ANALYPageVO analyPageVO) {
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		analyPageVO.setPageSize(10);
		// 如果没有选择时间，默认选择最近一周的统计量
		if (analyPageVO.getBeginDate() == null || analyPageVO.getEndDate() == null) {
			Date endDate = new Date();
			Date beginDate = new Date(endDate.getTime() - 7 * 48 * 3600 * 1000);
			analyPageVO.setBeginDate(beginDate);
			analyPageVO.setEndDate(endDate);
		}
		Page<AnalyzePage> pages = analyPageService.getPagesByCriteria(analyPageVO);
		model.addAttribute("page", pages);
		return "page_analysis";
	}

	/**
	 * 跳转到页面流量详情页
	 */
	@RequestMapping(value = "/pdetail", method = { RequestMethod.GET })
	public String getPageDetail(Model model, @ModelAttribute(value = "apd") ANALYPageDetailVO analyPageDetailVO) {
		if (analyPageDetailVO.getName() == null) {
			return "500";
		}
		// 根据传入的当前页码，查询下一页的数据,pageSize 暂时设置为10
		analyPageDetailVO.setPageSize(5);
		// 如果没有传递过来或者选择时间，默认选择最近一周的统计量
		if (analyPageDetailVO.getBeginDate() == null || analyPageDetailVO.getEndDate() == null) {
			Date endDate = new Date();
			Date beginDate = new Date(endDate.getTime() - 7 * 48 * 3600 * 1000);
			analyPageDetailVO.setBeginDate(beginDate);
			analyPageDetailVO.setEndDate(endDate);
		}

		List<ANALYPageInOutVO> inVos = analyPageService.getInOrOutDetailOfPage(analyPageDetailVO.getName(), 0,
				analyPageDetailVO.getBeginDate(), analyPageDetailVO.getEndDate());
		List<ANALYPageInOutVO> outVos = analyPageService.getInOrOutDetailOfPage(analyPageDetailVO.getName(), 1,
				analyPageDetailVO.getBeginDate(), analyPageDetailVO.getEndDate());
		Page<AnalyzePDetail> page = analyPageService.getPageDetailsByCriteria(analyPageDetailVO);
		model.addAttribute("page", page);
		model.addAttribute("inVos", inVos);
		model.addAttribute("outVos", outVos);
		model.addAttribute("pageName", analyPageDetailVO.getName());
		return "flow_analysis";
	}

	// 自定义属性编辑器
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
