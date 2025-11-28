package com.selfstudy.modules.bas.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约实体
 */
@Data
@TableName("bas_appointment")
public class BasAppointmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 预约ID
     */
    @TableId
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 座位ID
     */
    private Long seatId;

    /**
     * 预约日期
     */
    private Date appointmentDate;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 状态 0:已取消 1:进行中 2:已完成
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;
}

