package com.selfstudy.modules.bas.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 座位实体
 */
@Data
@TableName("bas_seat")
public class BasSeatEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 座位ID
     */
    @TableId
    private Long id;

    /**
     * 座位号
     */
    private String seatNum;

    /**
     * 自习室ID
     */
    private Long roomId;

    /**
     * 状态 0:不可用 1:可用 2:已预约
     */
    private Integer status;
}

