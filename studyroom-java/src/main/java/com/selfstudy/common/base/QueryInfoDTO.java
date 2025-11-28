package com.selfstudy.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询信息DTO
 */
@Data
public class QueryInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private Integer page = 1;

    /**
     * 每页显示记录数
     */
    private Integer limit = 10;

    /**
     * 排序字段
     */
    private String sidx;

    /**
     * 排序方式  asc/desc
     */
    private String order;

    /**
     * 搜索关键字
     */
    private String key;
}

