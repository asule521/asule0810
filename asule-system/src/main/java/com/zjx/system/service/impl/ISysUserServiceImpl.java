package com.zjx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjx.common.core.domain.entity.SysUser;
import com.zjx.system.mapper.UserMapper;
import com.zjx.system.service.ISysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjinxing
 * @date 2020/8/11 8:39
 * @description
 */
@Service
public class ISysUserServiceImpl implements ISysUserService {
    @Autowired
    private UserMapper mUserMapper;
    @Override
    public SysUser selectUserByUserName(String username) {
        SysUser sysUser=mUserMapper.selectUserByUserName(username);
        return sysUser;
    }
}
