package com.selfstudy.modules.bas.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.selfstudy.modules.bas.entity.BasAppointmentEntity;
import com.selfstudy.modules.applet.vo.BasAppointmentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasAppointmentDao extends BaseMapper<BasAppointmentEntity> {
    List<BasAppointmentVO> myAppointment(Long userId);
}
