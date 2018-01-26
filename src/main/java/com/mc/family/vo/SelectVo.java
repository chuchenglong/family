package com.mc.family.vo;

import java.util.List;
import java.util.Map;

/**
 * @author ChenglongChu
 * @description 下拉框查询VO
 * @create 2018/01/23 15:30
 * @since v0.3
 */
public class SelectVo extends BaseVo {
    private String code;

    private List<Map<String, String>> selects;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Map<String, String>> getSelects() {
        return selects;
    }

    public void setSelects(List<Map<String, String>> selects) {
        this.selects = selects;
    }
}
