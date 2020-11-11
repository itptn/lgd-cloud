package com.lgd.system.controller;

import com.lgd.base.LgdResult;
import com.lgd.system.pojo.req.SysCodeReq;
import com.lgd.system.service.SysCodeService;
import com.lgd.web.LgdController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public LgdResult<Boolean> genCode(@RequestBody SysCodeReq sysCodeReq) {
        validate(sysCodeReq);
        return LgdResult.init(sysCodeService.genCode(sysCodeReq));
    }
}
