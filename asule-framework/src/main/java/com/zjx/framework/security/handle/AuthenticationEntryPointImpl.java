package com.zjx.framework.security.handle;

import com.alibaba.fastjson.JSON;
import com.zjx.common.constant.HttpStatus;
import com.zjx.common.core.domain.AjaxResult;
import com.zjx.common.utils.ServletUtils;
import com.zjx.common.utils.StringUtils;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证失败处理类 返回未授权
 * // 使用未授权直接跳登录页面的时候不使用这个   --- httpSecurity.formLogin().loginPage("/").failureForwardUrl("/");
 * @author ruoyi
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException
    {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }
}
