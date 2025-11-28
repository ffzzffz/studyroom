package com.selfstudy.modules.bas.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 自习室实体
 */
@Data
@TableName("bas_study_room")
public class BasStudyRoomEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自习室ID
     */
    @TableId
    private Long id;

    /**
     * 自习室名称
     */
    private String roomName;

    /**
     * 楼层ID
     */
    private Long floorId;

    /**
     * 容量
     */
    private Integer capacity;

    /**
     * 状态 0:禁用 1:启用
     */
    private Integer status;
}

