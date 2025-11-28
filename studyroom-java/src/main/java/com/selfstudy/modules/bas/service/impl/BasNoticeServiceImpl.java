package com.selfstudy.modules.bas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selfstudy.common.base.PageResult;
import com.selfstudy.common.base.QueryInfoDTO;
import com.selfstudy.modules.bas.dao.BasNoticeDao;
import com.selfstudy.modules.bas.entity.BasNoticeEntity;
import com.selfstudy.modules.bas.service.BasNoticeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("basNoticeService")
public class BasNoticeServiceImpl extends ServiceImpl<BasNoticeDao, BasNoticeEntity> implements BasNoticeService {

    @Override
    public PageResult<BasNoticeEntity> listNotice(QueryInfoDTO queryInfoDTO) {
        IPage<BasNoticeEntity> page = new Page<>(queryInfoDTO.getPage(), queryInfoDTO.getLimit());
        QueryWrapper<BasNoticeEntity> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(queryInfoDTO.getKey())) {
            wrapper.like("title", queryInfoDTO.getKey());
        }

        wrapper.eq("status", 1);
        wrapper.orderByDesc("create_time");

        IPage<BasNoticeEntity> pageData = baseMapper.selectPage(page, wrapper);

        return new PageResult<>(pageData.getRecords(), pageData.getTotal(),
                queryInfoDTO.getLimit(), queryInfoDTO.getPage());
    }
}
