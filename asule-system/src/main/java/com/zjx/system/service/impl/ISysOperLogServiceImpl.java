package com.zjx.system.service.impl;

import com.zjx.system.domain.SysOperLog;
import com.zjx.system.mapper.ISysOperLogMapper;
import com.zjx.system.service.ISysOperLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjinxing
 * @date 2020/8/10 17:50
 * @description
 */
@Service
public class ISysOperLogServiceImpl implements ISysOperLogService {
    @Autowired
    private ISysOperLogMapper mISysOperLogMapper;

    @Override
    public void insertOperlog(SysOperLog operLog) {
        mISysOperLogMapper.insert(operLog);
    }

}
