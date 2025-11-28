package com.selfstudy.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.selfstudy.modules.sys.entity.SysUserEntity;

/**
 * 系统用户
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询用户
     */
    SysUserEntity queryByUserName(String username);
}

