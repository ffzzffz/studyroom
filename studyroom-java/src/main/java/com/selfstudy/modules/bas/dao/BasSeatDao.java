package com.selfstudy.modules.bas.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.selfstudy.modules.bas.entity.BasSeatEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasSeatDao extends BaseMapper<BasSeatEntity> {
    List<BasSeatEntity> getSeatByRoom(Long roomId);
}

