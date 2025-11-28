package com.selfstudy.modules.bas.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言实体
 */
@Data
@TableName("bas_message")
public class BasMessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 留言ID
     */
    @TableId
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言类型 1:用户留言 2:系统消息
     */
    private Integer messageType;

    /**
     * 创建时间
     */
    private Date createTime;
}

