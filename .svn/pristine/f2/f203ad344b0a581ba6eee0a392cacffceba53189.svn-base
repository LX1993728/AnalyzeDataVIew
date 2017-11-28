package com.anrong.wulan.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 * @author Joshua
 *
 */
public class MD5Kit {
	
	 public static String md5To32(String plainText) {
	        String result = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(plainText.getBytes());
	            byte b[] = md.digest();
	            int i;
	            StringBuilder buf = new StringBuilder("");
	            for (byte aB : b) {
	                i = aB;
	                if (i < 0)
	                    i += 256;
	                if (i < 16)
	                    buf.append("0");
	                buf.append(Integer.toHexString(i));
	            }
	            result = buf.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
}
