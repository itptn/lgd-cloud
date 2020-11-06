package com.lgd.system.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/6 12:26
 */
@Getter
@Setter
public class SysCodeDto {

    @NotEmpty(message = "模块名称不能为空")
    private String moduleName;
    @NotEmpty(message = "数据名称不能为空")
    private String dbName;
    @NotEmpty(message = "表名不能为空")
    private String[] tables;
}
