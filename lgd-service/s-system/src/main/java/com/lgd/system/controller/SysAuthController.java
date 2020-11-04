package com.lgd.system.controller;

import com.lgd.base.LgdResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("login")
    public LgdResult<String> login(){
        LgdResult lgdResult = LgdResult.init();
        return lgdResult;
    }
}
