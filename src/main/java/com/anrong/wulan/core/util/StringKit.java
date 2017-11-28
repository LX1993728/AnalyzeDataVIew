package com.anrong.wulan.core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 	string工具类
 * @author Joshua
 *
 */
public class StringKit extends StringUtils{
	
	/**
	 * 将字符串数组转换为Long集合
	 * @param array
	 * @return
	 */
	public static  List<Long> converStrToLongCollections(String... array){
		List<Long> result = new ArrayList();
		for(String e:array){
			result.add(Long.parseLong(e));
		}
		return result;
	}
	
}
