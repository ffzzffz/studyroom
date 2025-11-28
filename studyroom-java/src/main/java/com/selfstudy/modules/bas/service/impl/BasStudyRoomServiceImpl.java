package com.selfstudy.modules.bas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selfstudy.modules.bas.dao.BasStudyRoomDao;
import com.selfstudy.modules.bas.entity.BasStudyRoomEntity;
import com.selfstudy.modules.bas.service.BasStudyRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("basStudyRoomService")
public class BasStudyRoomServiceImpl extends ServiceImpl<BasStudyRoomDao, BasStudyRoomEntity> implements BasStudyRoomService {

    @Override
    public List<BasStudyRoomEntity> getRoomByFloor(Long floorId) {
        return baseMapper.getRoomByFloor(floorId);
    }
}

