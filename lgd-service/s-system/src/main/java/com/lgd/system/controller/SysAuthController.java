package com.lgd.system.controller;

import com.lgd.base.LgdResult;
import com.lgd.cache.CacheService;
import com.lgd.system.pojo.dto.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("currentUser")
    public LgdResult<String> currentUser() {
        cacheService.incr("pv");
        LgdResult lgdResult = LgdResult.init();
        return lgdResult;
    }

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.getUsername());
        System.out.println(loginDto.getType());
        Map<String, Object> result = new HashMap<>();
        result.put("status", "ok");
        result.put("type", loginDto.getType());
        result.put("currentAuthority", "admin");
        cacheService.incr("pv");
        cacheService.put(loginDto.getUsername(), loginDto.getType());
        return result;
    }
}
