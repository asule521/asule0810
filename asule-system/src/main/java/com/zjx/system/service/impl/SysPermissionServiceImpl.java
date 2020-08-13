package com.zjx.system.service.impl;

import com.zjx.common.core.domain.entity.SysUser;
import com.zjx.system.service.ISysMenuService;
import com.zjx.system.service.ISysRoleService;
import com.zjx.system.service.SysPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjinxing
 * @date 2020/8/11 8:40
 * @description
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private ISysMenuService mISysMenuService;
    @Autowired
    private ISysRoleService mISysRoleService;
    @Override
    public Set<String> getMenuPermission(SysUser user) {
       Set<String> perms = new HashSet<>();
       if(user.isAdmin()){
           perms.add("*:*:*");
       }else {
            perms.addAll(mISysMenuService.selectMenuPermsByUserId(user.getUserId()));
       }
       return perms;
    }

    @Override
    public Set<String> getRolePermission(SysUser user) {
        Set<String> roles = new HashSet<>();
        if(user.isAdmin()){
            roles.add("admin");
        }else {
            roles.addAll(mISysRoleService.selectRolePermissionByUserId(user.getUserId()));
        }
        return roles;
    }
}
