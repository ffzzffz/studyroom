package com.selfstudy.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selfstudy.modules.sys.dao.SysUserDao;
import com.selfstudy.modules.sys.entity.SysUserEntity;
import com.selfstudy.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 系统用户服务实现
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity queryByUserName(String username) {
        return baseMapper.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }
}

