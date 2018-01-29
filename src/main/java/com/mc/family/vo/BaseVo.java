package com.mc.family.vo;

import java.io.Serializable;

/**
 * @author ChenglongChu
 * @description 公共基础VO
 * @create 2018/01/09 17:06
 * @since v0.2
 */
public class BaseVo implements Serializable {
    private static final long serialVersionUID = 1516602995249L;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
