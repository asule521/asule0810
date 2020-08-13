package com.zjx.system.service;

import com.zjx.common.core.domain.entity.SysUser;

/**
 * @author zhangjinxing
 * @date 2020/8/11 8:38
 * @description
 */
public interface ISysUserService {
    SysUser selectUserByUserName(String username);
}
