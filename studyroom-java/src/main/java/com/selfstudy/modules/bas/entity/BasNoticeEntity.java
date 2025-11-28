package com.selfstudy.modules.bas.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告实体
 */
@Data
@TableName("bas_notice")
public class BasNoticeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    @TableId
    private Long id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态 0:隐藏 1:显示
     */
    private Integer status;
}

