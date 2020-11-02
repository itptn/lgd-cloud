package com.lgd.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/9/10 17:08
 */
@Setter
@Getter
public class LgdEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @Size(max = 255)
    @ApiModelProperty(value = "备注")
    private String remark;

    @Size(max = 32)
    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @Size(max = 32)
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "搜索值")
    private String searchValue;

    @ApiModelProperty(value = "请求参数")
    private Map<String, Object> params = new HashMap<>();
}