package com.anrong.wulan.core.config;

import java.util.concurrent.ConcurrentHashMap;

import com.anrong.wulan.core.util.PropertiesLoader;

/**
 * 全局配置类
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static volatile Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("properties/app.properties");

	
	private Global(){}
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : "");
		}
		return value;
	}
}
