package com.zjx.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjx.system.domain.SysLogininfor;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangjinxing
 * @date 2020/8/11 9:19
 * @description
 */
@Mapper
public interface SysLogininforMapper extends BaseMapper<SysLogininfor> {

    void insertLogininfor(SysLogininfor logininfor);
}
