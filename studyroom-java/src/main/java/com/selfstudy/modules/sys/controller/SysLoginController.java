package com.selfstudy.modules.sys.controller;

import com.google.code.kaptcha.Producer;
import com.selfstudy.common.utils.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 登录相关
 */
@RestController
public class SysLoginController {
    @Autowired
    private Producer producer;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 验证码
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid, HttpSession session) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        // 保存验证码到session或redis
        if (uuid != null && redisTemplate != null) {
            redisTemplate.opsForValue().set("captcha:" + uuid, text, 5, TimeUnit.MINUTES);
        } else {
            session.setAttribute("captcha", text);
        }

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody Map<String, String> form, HttpSession session) {
        String username = form.get("username");
        String password = form.get("password");
        String captcha = form.get("captcha");
        String uuid = form.get("uuid");

        // 验证验证码
        String kaptcha = null;
        if (uuid != null && redisTemplate != null) {
            kaptcha = (String) redisTemplate.opsForValue().get("captcha:" + uuid);
            redisTemplate.delete("captcha:" + uuid);
        } else {
            kaptcha = (String) session.getAttribute("captcha");
            session.removeAttribute("captcha");
        }

        if (kaptcha == null || !captcha.equalsIgnoreCase(kaptcha)) {
            return R.error("验证码不正确");
        }

        // 验证用户名密码
        if (!"admin".equals(username) || !"admin".equals(password)) {
            return R.error("账号或密码不正确");
        }

        // 生成token
        String token = UUID.randomUUID().toString().replace("-", "");

        return R.ok().put("token", token);
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public R logout(HttpSession session) {
        session.invalidate();
        return R.ok();
    }
}

