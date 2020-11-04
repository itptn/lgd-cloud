package com.lgd.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/4 17:03
 */
@Getter
@Setter
public class LgdData<T> implements Serializable {

    private static final long serialVersionUID = 5081801760183408243L;
    private List<T> list;
    private int current;
    private int pageSize;
    private int total;
}