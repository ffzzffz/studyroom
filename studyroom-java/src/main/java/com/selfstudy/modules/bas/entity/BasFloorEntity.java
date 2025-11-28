package com.selfstudy.modules.bas.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 楼层实体
 */
@Data
@TableName("bas_floor")
public class BasFloorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 楼层ID
     */
    @TableId
    private Long id;

    /**
     * 楼层名称
     */
    private String floorName;

    /**
     * 楼层号
     */
    private Integer floorNum;

    /**
     * 状态 0:禁用 1:启用
     */
    private Integer status;
}

