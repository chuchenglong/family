package com.mc.family.util;

import com.mc.family.config.ManagerLog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenglongChu
 * @description 通用工具类
 * @create 2018/01/25 15:02
 * @since v0.4
 */
public class CommonUtils {
    public static final String SERIALIZE_NAME = "serialVersionUID";

    /**
     * @description vo转换为HashMap
     * @param t 要转换的vo
     * @author ChenglongChu
     * @create 2018/1/25 15:05
    **/
    public static <T> Map<String, Object> voToHashMap(T t) throws Exception {
        Map<String, Object> map = new HashMap<>();

        try {
            Class<? extends Object> clazz = t.getClass();
            //获取属性集合
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //获取属性名
                String attrName = field.getName();
                //过滤掉序列化属性
                if (SERIALIZE_NAME.equals(attrName)) {
                    continue;
                }
                //获取get方法名
                String getMethedName = "get" + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);
                //拿到get方法
                Method getMethod = clazz.getMethod(getMethedName);
//            System.out.println(attrName + ":" + getMethod.invoke(t));
                //通过get方法获取属性值放入map中
                map.put(attrName, getMethod.invoke(t));
            }

        } catch (Exception e) {
            ManagerLog.error("voToHashMap has some error !!!", e);
            throw e;
        }

        return map;
    }
}
