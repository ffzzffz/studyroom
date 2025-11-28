package com.selfstudy.modules.bas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selfstudy.modules.bas.dao.BasMessageDao;
import com.selfstudy.modules.bas.entity.BasMessageEntity;
import com.selfstudy.modules.bas.service.BasMessageService;
import org.springframework.stereotype.Service;

@Service("basMessageService")
public class BasMessageServiceImpl extends ServiceImpl<BasMessageDao, BasMessageEntity> implements BasMessageService {
}

