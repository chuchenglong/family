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
    private transient int limit;

    /**
     * 以多少开始, 起点为0
     */
    private transient int offset;

    /**
     * 排序字段, 暂未使用
     */
    private transient String sort;

    /**
     * 升降序, 默认asc, 暂未使用
     */
    private transient String order;

    /**
     * 模糊查询字段, 暂未使用
     */
    private transient String search;

    /**
     * 数据总数量
     */
    private int total;

    /**
     * 查询数据集合
     */
    private List<? extends Object> rows;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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

