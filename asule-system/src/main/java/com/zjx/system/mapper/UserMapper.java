package com.zjx.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjx.common.core.domain.entity.SysUser;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangjinxing
 * @date 2020/8/11 8:49
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {


    SysUser selectUserByUserName(String username);
}
