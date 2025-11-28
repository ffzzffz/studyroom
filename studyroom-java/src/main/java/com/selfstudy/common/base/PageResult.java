package com.selfstudy.common.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 */
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 当前页码
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 列表数据
     */
    private List<T> list;

    /**
     * 分页
     * @param list        列表数据
     * @param total  总记录数
     * @param pageSize   每页记录数
     * @param currentPage    当前页码
     */
    public PageResult(List<T> list, long total, int pageSize, int currentPage) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPage = (int) Math.ceil((double) total / pageSize);
    }

    public PageResult() {
    }
}

