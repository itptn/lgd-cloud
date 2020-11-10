package com.lgd.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgd.base.LgdData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/6 13:20
 */
public class LgdController {

    @Autowired
    private Validator validator;

    /**
     * 响应请求分页数据
     */
    protected <T> LgdData<T> getData(Page<T> page) {
        LgdData<T> lgdData = new LgdData();
        lgdData.setCurrent(page.getCurrent());
        lgdData.setPageSize(page.getSize());
        lgdData.setTotal(page.getTotal());
        lgdData.setRows(page.getRecords());
        return lgdData;
    }

    protected void validate(Object target){
        Set<ConstraintViolation<Object>> validateSet = validator.validate(target);

        if (!CollectionUtils.isEmpty(validateSet)) {
            String messages = validateSet.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            throw new IllegalArgumentException(messages);
        }
    }
}
