package com.mc.family.controller;

import com.alibaba.fastjson.JSONObject;
import com.mc.family.config.ConstantComm;
import com.mc.family.config.ManagerResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenglongChu
 * @description 提供controller层基础公共方法
 * @create 2017/12/13 14:11
 * @since v0.1
 */
public class BaseController {
    /**
     * @description 通过request参数为实体对象set值
     * @param request servlet请求参数
     * @param clazz 实体对象的class类型
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 17:47
    **/
    protected <T> T  input(HttpServletRequest request, Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String attrName = field.getName();

            String getMethedName = ConstantComm.GET + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);
            String setMethedName = ConstantComm.SET + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);

            Method getMethed = clazz.getMethod(getMethedName);
            Method setMethod = null;

            Type type = getMethed.getGenericReturnType();
            Class<? extends Object> setClass = null;
            if (type instanceof ParameterizedType) {
                String typeName = type.getTypeName();
                setClass = Class.forName(typeName.substring(0, typeName.indexOf("<")));
            } else {
                if (ConstantComm.INT.equals(type.getTypeName())) {
                    setClass = int.class;
                } else if (ConstantComm.DOUBLE.equals(type.getTypeName())) {
                    setClass = double.class;
                } else if (ConstantComm.FLOAT.equals(type.getTypeName())) {
                    setClass = float.class;
                } else if (ConstantComm.BOOLEAN.equals(type.getTypeName())) {
                    setClass = boolean.class;
                } else if (ConstantComm.CHAR.equals(type.getTypeName())) {
                    setClass = char.class;
                } else if (ConstantComm.SHORT.equals(type.getTypeName())) {
                    setClass = short.class;
                } else if (ConstantComm.BYTE.equals(type.getTypeName())) {
                    setClass = byte.class;
                } else if (ConstantComm.LONG.equals(type.getTypeName())) {
                    setClass = long.class;
                } else {
                    setClass = Class.forName(type.getTypeName());
                }
            }

            setMethod = clazz.getMethod(setMethedName, setClass);
            Object value = request.getParameter(attrName);
            setMethod.invoke(t, value);
        }

        return t;
    }

    /**
     * @description 输出结果
     * @param response servlet返回参数
     * @param obj 结果对象
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 17:49
    **/
    protected void output(HttpServletResponse response, Object obj) throws Exception {
        //to json string
        String json = JSONObject.toJSONStringWithDateFormat(ManagerResult.newSuccess(obj), ConstantComm.DATE_FORMAT_ONE);
        //output response
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * @description 输出结果
     * @param response servlet返回参数
     * @param obj 结果对象
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 17:49
     **/
    protected void commOutput(HttpServletResponse response, Object obj) throws Exception {
        //to json string
        String json = JSONObject.toJSONStringWithDateFormat(obj, ConstantComm.DATE_FORMAT_ONE);
        //output response
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * @description 实体对象转map
     * @param t 实体对象
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 17:51
    **/
    protected <T> Map<String, Object> objectToHashMap(T t) throws Exception {
        Map<String, Object> map = new HashMap<>();

        Class<? extends Object> clazz = t.getClass();
        //获取属性集合
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取属性名
            String attrName = field.getName();
            //获取get方法名
            String getMethedName = "get" + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);
            //拿到get方法
            Method getMethod = clazz.getMethod(getMethedName);
            //通过get方法获取属性值放入map中
            map.put(attrName, getMethod.invoke(t));
        }

        return map;
    }

    public static void main(String[] args) {
        // url
        String url = "http://localhost:9090/thirdInterface/selectMcInfo";
        // body参数
        Map<String, Object> params = new HashMap<>();
        params.put("secretKey","GSXEQ11087");
        params.put("thirdIds", Arrays.asList("82BF3226-213D-4794-8259-4B7CC2376B39"));
        // 请求服务拿到返回结果
        ResponseEntity<String> result = httpClient(url, params, HttpMethod.POST);
        System.out.println(result);
    }

    public static ResponseEntity<String> httpClient(String url, Map<String, Object> params, HttpMethod type) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json;charset=utf-8");
        String jsonObj = JSONObject.toJSONStringWithDateFormat(params, ConstantComm.DATE_FORMAT_ONE);
        HttpEntity<String> httpEntity=new HttpEntity<>(jsonObj,headers);
        ResponseEntity<String> result= restTemplate.exchange(url, type, httpEntity, String.class);
        return result;
    }
}
