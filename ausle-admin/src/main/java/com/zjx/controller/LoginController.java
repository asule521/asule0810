package com.zjx.controller;

import com.zjx.common.constant.Constants;
import com.zjx.common.core.domain.AjaxResult;
import com.zjx.common.core.domain.entity.SysMenu;
import com.zjx.common.core.domain.entity.SysUser;
import com.zjx.common.core.domain.model.LoginBody;
import com.zjx.common.core.domain.model.LoginUser;
import com.zjx.common.utils.ServletUtils;
import com.zjx.framework.LoginService;
import com.zjx.framework.TokenService;
import com.zjx.system.service.ISysMenuService;
import com.zjx.system.service.SysPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhangjinxing
 * @date 2020/8/10 14:44
 * @description
 */
@RestController
@Api(tags = "登录接口")
public class LoginController {
    @Autowired
    private LoginService mLoginService;
    @Autowired
    private TokenService mTokenService;
    @Autowired
    private SysPermissionService mSysPermissionService;
    @Autowired
    private ISysMenuService mISysMenuService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        AjaxResult ajax = new AjaxResult();
        String token= mLoginService.login(loginBody.getUsername(),loginBody.getPassword(),loginBody.getCode(),loginBody.getUuid());
        ajax.put(Constants.TOKEN,token);
        return ajax;

    }
    @GetMapping("getInfo")
    @ApiOperation("角色权限集合")
    public AjaxResult getinfo(){
        LoginUser loginUser = mTokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        //角色集合
        Set<String> roles=mSysPermissionService.getRolePermission(user);
        //权限集合
        Set<String> permissions = mSysPermissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }
    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        LoginUser loginUser = mTokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = mISysMenuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(mISysMenuService.buildMenus(menus));
    }

}

