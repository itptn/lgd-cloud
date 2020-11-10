package com.lgd.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgd.base.LgdData;
import com.lgd.system.pojo.entity.SysUser;
import com.lgd.system.service.ISysUserService;
import com.lgd.web.LgdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author YYJ
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/system/sys-user")
public class SysUserController extends LgdController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/list")
    public LgdData<SysUser> list(@RequestParam(defaultValue = "1") long current, @RequestParam(defaultValue = "10") long pageSize, SysUser sysUser) {
        Page<SysUser> list = sysUserService.page(new Page<>(current, pageSize), new QueryWrapper<>(sysUser));
        return getData(list);
    }

}