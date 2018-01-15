package com.mc.family.vo;

/**
 * @author ChenglongChu
 * @description 分页查询属性
 * @create 2018/01/09 17:07
 * @since v0.2
 */
public class PageVo extends BaseVo {
    private int pageSize;

    private int pageNumber;

    private int offset;

    private int[] pageList;

    private int startPoint;

    private int endPoint;
}
