package com.lgd.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgd.base.constant.HttpStatus;
import com.lgd.utils.SqlUtils;
import com.lgd.utils.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/9/11 16:14
 */
public class LgdController {

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        LgdPage lgdPage = LgdTableSupport.buildPageRequest();
        Integer pageNum = lgdPage.getPageNum();
        Integer pageSize = lgdPage.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = SqlUtils.escapeOrderBySql(lgdPage.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    protected LgdTableData getTableData(List list) {
        LgdTableData rspData = new LgdTableData();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应请求分页数据
     */
    protected LgdExTableData getExTableData(List list, List<LgdTableHead> tableHeads) {
        return getExTableData(list, tableHeads, Collections.emptyList());
    }

    /**
     * 响应请求分页数据
     */
    protected LgdExTableData getExTableData(List list, List<LgdTableHead> extTables, List<LgdTableHead> extLabels) {
        LgdExTableData rspData = new LgdExTableData();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal(new PageInfo(list).getTotal());
        rspData.setExtTables(extTables);
        rspData.setExtLabels(extLabels);
        return rspData;
    }
}