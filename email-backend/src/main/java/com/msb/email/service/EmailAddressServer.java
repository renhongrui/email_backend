package com.msb.email.service;

import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.vo.PageResult;

import java.util.List;

public interface EmailAddressServer {

    Boolean insertEmail(EmailAddressCondition condition); //添加

    List selectEmailAddress(); // 查询

    PageResult findPage(PageRequestCondition pageRequest); //分页


}
