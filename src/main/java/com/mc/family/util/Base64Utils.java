package com.mc.family.util;

import com.mc.family.config.ManagerLog;
import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @description Base64加/解密工具类
 * @author ChenglongChu
 * @create 2018/1/23 16:47
 * @since v0.4
**/
public class Base64Utils {
    /**
     * @description Base64加密
     * @param str 待加密字符串
     * @author ChenglongChu
     * @create 2018/1/23 16:44
     **/
    public static String stringToBase64(String str) {
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {
            ManagerLog.error(e.toString());
            e.printStackTrace();
            return "";
        }  
        if (b != null) {  
            s = Base64.getEncoder().encodeToString(b);
        }  
        return s;  
    }

    /**
     * @description Base64解密
     * @param str 待加密字符串
     * @author ChenglongChu
     * @create 2018/1/23 16:44
     **/
	public static String base64ToString(String str) {
        byte[] b = null;  
        String result = null;  
        if (str != null) {
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");  
            } catch (Exception e) {
                ManagerLog.error(e.toString());
                e.printStackTrace();
                return "";
            }  
        }  
        return result;  
    }
}
