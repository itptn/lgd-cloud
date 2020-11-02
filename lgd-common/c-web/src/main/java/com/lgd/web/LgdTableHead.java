package com.lgd.web;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 表格分页数据对象
 *
 * @author YYJ
 */
@Getter
@Setter
public class LgdTableHead implements Serializable {
    private static final long serialVersionUID = 1L;
    private String prop;
    private String label;
    private String align;
    private String style;
    private String formatter;

    public LgdTableHead(String prop, String label) {
        this.prop = prop;
        this.label = label;
    }

    public LgdTableHead(String prop, String label, String style) {
        this.prop = prop;
        this.label = label;
        this.style = style;
    }

    public LgdTableHead(String prop, String label, String align, String formatter) {
        this.prop = prop;
        this.label = label;
        this.align = align;
        this.formatter = formatter;
    }
}