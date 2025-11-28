package com.selfstudy.modules.applet.controller;

import com.selfstudy.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统健康检查
 */
@RestController
@RequestMapping("/")
public class HealthController {

    /**
     * 健康检查接口
     */
    @GetMapping("/health")
    public R health() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", "UP");
        data.put("service", "自习室座位管理系统");
        data.put("version", "1.0.0");
        data.put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return R.ok(data);
    }

    /**
     * 欢迎页面
     */
    @GetMapping("/welcome")
    public R welcome() {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "欢迎使用自习室座位管理系统");
        data.put("description", "提供自习室座位预约、管理等功能");
        data.put("swagger", "/self-study/swagger-ui.html");
        data.put("druid", "/self-study/druid/");
        data.put("version", "1.0.0");
        return R.ok(data);
    }
}

