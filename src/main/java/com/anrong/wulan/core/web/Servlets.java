package com.anrong.wulan.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.anrong.wulan.core.config.Global;
import com.anrong.wulan.core.util.StringKit;

public class Servlets {

	// 静态文件后缀
	private final static String[] staticFiles = Global.getConfig("web.staticFile").split(",");

	/**
	 * 判断访问URI是否是静态文件请求
	 * 
	 * @throws Exception
	 */
	public static boolean isStaticFile(String uri) {
		if (staticFiles == null) {
			try {
				throw new Exception(
						"检测到“app.properties”中没有配置“web.staticFile”属性。配置示例：\n#静态文件后缀\n"
								+ "web.staticFile=.css,.js,.png,.jpg,.gif,.jpeg,.bmp,.ico,.swf,.psd,.htc,.crx,.xpi,.exe,.ipa,.apk");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (StringKit.endsWithAny(uri, staticFiles)) {
			return true;
		}
		return false;
	}
	
	/*
	 * 获取当前请求对象
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		try{
			return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		}catch(Exception e){
			return null;
		}
	}
}
