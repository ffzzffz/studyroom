package com.selfstudy.modules.bas.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.selfstudy.modules.bas.entity.BasStudyRoomEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasStudyRoomDao extends BaseMapper<BasStudyRoomEntity> {
    List<BasStudyRoomEntity> getRoomByFloor(Long floorId);
}

