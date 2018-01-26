package com.mc.family.vo;

import java.util.List;

/**
 * @author ChenglongChu
 * @description 分页查询属性VO
 * @create 2018/01/18 15:06
 * @since 0.3
 */
public class PageVo extends BaseVo {
    /**
     * 页面大小/每页行数量
     */
    private transient int pageSize;

    /**
     * 页码/第几页, 以1开始
     */
    private transient int pageNumber;

    /**
     * 可供选择的页面大小/每页行数量
     */
    private transient int[] pageList;

    /**
     * 数据起始位置, 以0开始
     */
    private transient int startPoint;

    /**
     * 数据结束位置
     */
    private transient int endPoint;

    /**
     * 数据总数量
     */
    private int total;

    /**
     * 查询数据集合
     */
    private List<? extends Object> rows;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int[] getPageList() {
        return pageList;
    }

    public void setPageList(int[] pageList) {
        this.pageList = pageList;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<? extends Object> getRows() {
        return rows;
    }

    public void setRows(List<? extends Object> rows) {
        this.rows = rows;
    }


}

