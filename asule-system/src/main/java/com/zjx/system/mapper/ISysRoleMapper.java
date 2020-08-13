package com.zjx.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjx.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * @author zhangjinxing
 * @date 2020/8/12 10:32
 * @description
 */
public interface ISysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> selectRolePermissionByUserId(Long userId);
}
