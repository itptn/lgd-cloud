package com.lgd.base.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户状态
 *
 * @author YYJ
 */
public enum AccountTypes {

    账户总览("TOTAL", "A", "", 0),

    现金账户("现金账户", "A", "", 1),
    金融账户("金融账户", "A", "", 1),
    投资账户("投资账户", "A", "", 1),
    债权账户("债权账户", "A", "", 1),

    虚拟来源("V_IN", "V", "", 99),
    虚拟核销("V_OUT", "V", "", 99),
    ;
    public String type, attr, icon;
    public int level;

    AccountTypes(String type, String attr, String icon, int level) {
        this.type = type;
        this.attr = attr;
        this.icon = icon;
        this.level = level;
    }

    public AccountTypes findByType(String type) {
        return lookup.get(type);
    }

    public AccountTypes find(String name) {
        return AccountTypes.valueOf(name);
    }

    private static final Map<String, AccountTypes> lookup = new HashMap<>();

    static {
        for (AccountTypes a : AccountTypes.values()) {
            lookup.put(a.type, a);
        }
    }
}