package com.selfstudy.modules.bas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.selfstudy.modules.applet.dto.save.BasAppointmentSaveDTO;
import com.selfstudy.modules.applet.vo.BasAppointmentVO;
import com.selfstudy.modules.bas.entity.BasAppointmentEntity;

import java.util.List;

public interface BasAppointmentService extends IService<BasAppointmentEntity> {
    boolean appointment(BasAppointmentSaveDTO saveDTO, Long userId);
    List<BasAppointmentVO> myAppointment(Long userId);
    Boolean cancel(Long id);
    Boolean over(Long id);
}
