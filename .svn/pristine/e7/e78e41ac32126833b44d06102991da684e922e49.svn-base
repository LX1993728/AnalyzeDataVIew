package com.anrong.wulan.core.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
/**
 * @author ZYJ
 */
public class Strings {

	//字符转码
    public static String toUTF8(String str) {
        if (StringUtils.isNotEmpty(str)) {
            try {
                return new String(str.getBytes("ISO8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("字符串转码异常");
            }
        }
        return "";
    }

   //截取逗号分隔的数字字符串
	public static double splitString(Object obj){
			
			String strs = obj.toString();
			String string="";
			if(strs.contains(",")){
				strs = strs.trim();
				String[] split = strs.split(",");
				if(split.length!=0){
					for (String str : split) {
						string+=str;
					}
				}
				return Double.parseDouble(string);
			}else{
				
				return Double.parseDouble(strs);
			}
			
	}
	
	//数字截取小数点
	public static String splitNumber(Object obj){
		
		String str=obj.toString();
		if(str.contains(".")){
			str = str.trim();
			try {
				str = str.substring(0, str.indexOf(".")+3);
			} catch (Exception e) {
				str=str+"0";
			}
			
			return str;
		}else{
			
			return str+".00";
		}
		
}
	
    //转换拼音
//    public static String toPinyin(String str) {
//        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
//        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);//将文字转换成小写
//        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//设置拼音音调（不要）
//        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);//用 V 表示 U
//
//        try {
//            return PinyinHelper.toHanyuPinyinString(str,outputFormat,"");
//        } catch (BadHanyuPinyinOutputFormatCombination ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
//    }
}
