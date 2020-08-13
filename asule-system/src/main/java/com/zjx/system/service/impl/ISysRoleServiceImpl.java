package com.zjx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjx.common.core.domain.entity.SysRole;
import com.zjx.common.utils.StringUtils;
import com.zjx.system.mapper.ISysRoleMapper;
import com.zjx.system.service.ISysRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangjinxing
 * @date 2020/8/12 10:27
 * @description
 */
@Service
public class ISysRoleServiceImpl implements ISysRoleService {
    @Autowired
    private ISysRoleMapper mISysRoleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        QueryWrapper<SysRole> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("user_id",userId);
        //List<SysRole> sysRoles = mISysRoleMapper.selectList(objectQueryWrapper);
        List<SysRole> perms = mISysRoleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }
}
