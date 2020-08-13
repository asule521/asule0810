package com.zjx.system.service;

import java.util.Collection;
import java.util.Set;

/**
 * @author zhangjinxing
 * @date 2020/8/12 10:27
 * @description
 */
public interface ISysRoleService {
    Set<String> selectRolePermissionByUserId(Long userId);
}
