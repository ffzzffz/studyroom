package com.selfstudy.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selfstudy.modules.sys.dao.SysLogDao;
import com.selfstudy.modules.sys.entity.SysLogEntity;
import com.selfstudy.modules.sys.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

}

