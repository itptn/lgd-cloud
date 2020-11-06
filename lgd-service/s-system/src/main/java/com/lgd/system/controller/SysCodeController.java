package com.lgd.system.controller;

import com.lgd.base.LgdResult;
import com.lgd.system.pojo.dto.LoginDto;
import com.lgd.system.pojo.dto.SysCodeDto;
import com.lgd.system.service.SysCodeService;
import com.lgd.web.LgdController;
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
@RequestMapping("/code")
public class SysCodeController extends LgdController {

    @Autowired
    private SysCodeService sysCodeService;

    @PostMapping("genCode")
    public LgdResult<Boolean> genCode(@RequestBody SysCodeDto sysCodeDto) {
        validate(sysCodeDto);
        return LgdResult.ok(sysCodeService.genCode(sysCodeDto));
    }
}
