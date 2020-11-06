package com.lgd.web;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/6 13:20
 */
public class LgdController {

    @Autowired
    private Validator validator;

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
