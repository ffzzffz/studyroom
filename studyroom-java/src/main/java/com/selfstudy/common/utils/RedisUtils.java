package com.selfstudy.common.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtils {

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;
    private Gson gson = new Gson();

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @param expire 过期时间(秒)
     */
    public void set(String key, Object value, long expire){
        if(redisTemplate == null) return;
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     */
    public void set(String key, Object value){
        if(redisTemplate == null) return;
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取缓存
     * @param key 键
     * @param clazz 类型
     * @return 值
     */
    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = get(key, expire);
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 获取缓存
     * @param key 键
     * @param clazz 类型
     * @return 值
     */
    public <T> T get(String key, Class<T> clazz) {
        String value = get(key);
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 获取缓存
     * @param key 键
     * @param expire 过期时间(秒)
     * @return 值
     */
    public String get(String key, long expire) {
        if(redisTemplate == null) return null;
        String value = get(key);
        if(value != null && expire > 0){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    public String get(String key) {
        if(redisTemplate == null) return null;
        Object value = redisTemplate.opsForValue().get(key);
        return value == null ? null : value.toString();
    }

    /**
     * 删除缓存
     * @param key 键
     */
    public void delete(String key) {
        if(redisTemplate == null) return;
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object){
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return gson.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }
}

