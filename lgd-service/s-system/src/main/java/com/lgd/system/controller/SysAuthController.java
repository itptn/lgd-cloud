package com.lgd.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgd.base.LgdResult;
import com.lgd.base.enums.LoginTypeEnum;
import com.lgd.base.enums.ResultEnum;
import com.lgd.cache.CacheService;
import com.lgd.system.pojo.entity.SysUser;
import com.lgd.system.pojo.req.LoginReq;
import com.lgd.system.service.ISysUserService;
import com.lgd.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/4 15:59
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class SysAuthController {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("currentUser")
    public LgdResult currentUser() {
        cacheService.incr("pv");
        LgdResult lgdResult = LgdResult.init();
        return lgdResult;
    }

    @PostMapping("login")
    public LgdResult login(@RequestBody LoginReq loginReq) {
        LgdResult result = LgdResult.init();
        result.setData(loginReq.getType());

        if(LoginTypeEnum.账户密码登录.getType().equals(loginReq.getType())){
            if(StringUtils.isEmpty(loginReq.getUsername()) || StringUtils.isEmpty(loginReq.getPassword())){
                return result.setFail(ResultEnum.用户名或密码不能为空);
            }

            SysUser sysUser = sysUserService.getOne(new QueryWrapper<SysUser>().eq("user_name", loginReq.getUsername()));
            if(null == sysUser){
                return result.setFail(ResultEnum.用户名或密码不正确);
            }
        }else if(LoginTypeEnum.手机号登录.getType().equals(loginReq.getType())){

        }else{
            return result.setFail(ResultEnum.登陆方式不支持);
        }
        return result;
    }
}
