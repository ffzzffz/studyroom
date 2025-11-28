package com.selfstudy.modules.bas.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selfstudy.modules.applet.dto.save.BasAppointmentSaveDTO;
import com.selfstudy.modules.applet.vo.BasAppointmentVO;
import com.selfstudy.modules.bas.dao.BasAppointmentDao;
import com.selfstudy.modules.bas.entity.BasAppointmentEntity;
import com.selfstudy.modules.bas.service.BasAppointmentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("basAppointmentService")
public class BasAppointmentServiceImpl extends ServiceImpl<BasAppointmentDao, BasAppointmentEntity> implements BasAppointmentService {

    @Override
    public boolean appointment(BasAppointmentSaveDTO saveDTO, Long userId) {
        BasAppointmentEntity entity = BeanUtil.copyProperties(saveDTO, BasAppointmentEntity.class);
        entity.setUserId(userId);
        entity.setStatus(1);
        entity.setCreateTime(new Date());
        return save(entity);
    }

    @Override
    public List<BasAppointmentVO> myAppointment(Long userId) {
        return baseMapper.myAppointment(userId);
    }

    @Override
    public Boolean cancel(Long id) {
        BasAppointmentEntity entity = getById(id);
        if (entity != null) {
            entity.setStatus(0);
            return updateById(entity);
        }
        return false;
    }

    @Override
    public Boolean over(Long id) {
        BasAppointmentEntity entity = getById(id);
        if (entity != null) {
            entity.setStatus(2);
            return updateById(entity);
        }
        return false;
    }
}
