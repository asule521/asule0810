package com.zjx.system.service;

import com.zjx.common.core.domain.entity.SysUser;

import java.util.Set;

/**
 * @author zhangjinxing
 * @date 2020/8/11 8:39
 * @description
 */
public interface SysPermissionService {
    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    Set<String> getMenuPermission(SysUser user);

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    Set<String> getRolePermission(SysUser user);
}
