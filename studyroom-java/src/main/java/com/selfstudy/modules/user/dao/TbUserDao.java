package com.selfstudy.modules.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.selfstudy.modules.user.entity.TbUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户DAO
 */
@Mapper
public interface TbUserDao extends BaseMapper<TbUserEntity> {

    /**
     * 获取封禁用户列表
     */
    List<TbUserEntity> listForBan();
}

