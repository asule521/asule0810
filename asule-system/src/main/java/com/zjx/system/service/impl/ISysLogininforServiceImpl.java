package com.zjx.system.service.impl;

import com.zjx.system.domain.SysLogininfor;
import com.zjx.system.mapper.SysLogininforMapper;
import com.zjx.system.service.ISysLogininforService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjinxing
 * @date 2020/8/11 9:22
 * @description
 */
@Service
public class ISysLogininforServiceImpl implements ISysLogininforService {
    @Autowired
    private  SysLogininforMapper mSysLogininforMapper;
    @Override
    public void insertLogininfor(SysLogininfor logininfor) {
        mSysLogininforMapper.insertLogininfor(logininfor);
    }


}
