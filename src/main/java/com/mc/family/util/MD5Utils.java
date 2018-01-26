package com.mc.family.util;


import com.mc.family.config.ManagerLog;

import java.security.MessageDigest;

/**
 * @description MD5加/解密工具类
 * @author ChenglongChu
 * @create 2018/1/23 16:43
 * @since v0.4
 **/
public class MD5Utils {
    /**
     * @description 生成32位加密码
     * @param str 待加密字符串
     * @author ChenglongChu
     * @create 2018/1/23 16:44
    **/
    public static String stringToMD5(String str) {
        StringBuffer hexValue = new StringBuffer();
        MessageDigest md5 = null;

        try{
            md5 = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] byteArray = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }

            byte[] md5Bytes = md5.digest(byteArray);
            for (int i = 0; i < md5Bytes.length; i++){
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
        }catch (Exception e) {
            ManagerLog.error(e.toString());
            e.printStackTrace();
            return "";
        }

        return hexValue.toString();
    }

}
