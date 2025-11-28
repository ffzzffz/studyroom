package com.selfstudy.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.selfstudy.modules.user.entity.TbUserEntity;

import java.util.List;

/**
 * 用户服务
 */
public interface TbUserService extends IService<TbUserEntity> {

    /**
     * 获取封禁用户列表
     */
    List<TbUserEntity> listForBan();
}
