package com.selfstudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 消息配置属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "message")
public class MessageProperties {

    /**
     * 是否启用消息通知
     */
    private boolean enabled = false;

    /**
     * 消息类型：sms-短信, email-邮件, wechat-微信
     */
    private String type = "sms";

    /**
     * 表单保存错误提示
     */
    private String formSaveError = "保存失败";

    /**
     * 表单更新错误提示
     */
    private String formUpdateError = "更新失败";

    /**
     * 表单删除错误提示
     */
    private String formDeleteError = "删除失败";

    /**
     * 用户账号已存在或密码错误提示
     */
    private String userAccountExist = "账号或密码错误";

    /**
     * 短信配置
     */
    private SmsConfig sms = new SmsConfig();

    /**
     * 邮件配置
     */
    private EmailConfig email = new EmailConfig();

    @Data
    public static class SmsConfig {
        /**
         * 短信平台AppId
         */
        private String appId;

        /**
         * 短信平台AppKey
         */
        private String appKey;

        /**
         * 短信模板ID
         */
        private String templateId;

        /**
         * 短信签名
         */
        private String signName;
    }

    @Data
    public static class EmailConfig {
        /**
         * 发件人邮箱
         */
        private String from;

        /**
         * 发件人名称
         */
        private String fromName;

        /**
         * 邮件主题
         */
        private String subject;
    }
}

