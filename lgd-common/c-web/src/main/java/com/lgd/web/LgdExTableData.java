package com.lgd.web;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 表格分页数据对象【动态表头】
 *
 * @author YYJ
 */
@Getter
@Setter
public class LgdExTableData<T> extends LgdTableData {
    private static final long serialVersionUID = 1L;
    List<LgdTableHead> extLabels = new ArrayList<>();
    List<LgdTableHead> extTables = new ArrayList<>();
}