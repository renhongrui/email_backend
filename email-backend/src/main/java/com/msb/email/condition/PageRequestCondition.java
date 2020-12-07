package com.msb.email.condition;

import lombok.Data;

@Data
public class PageRequestCondition {
    /**
     * 当前页码   入参
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 查询条件
     */
    private String searchKey;


}
