package com.msb.email.service;

import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.entity.SendEmailAddress;
import com.msb.email.vo.PageResult;

import java.util.List;

public interface EmailAddressServer {

    Boolean insertEmail(EmailAddressCondition condition); //添

    Boolean deleteEmail(Integer id); //删

    Boolean updateEmail(EmailAddressCondition condition); //改

    List selectEmailAddress(); // 查全部

    PageResult findPage(PageRequestCondition pageRequest); //分页

    SendEmailAddress selectEmailById(Integer id); // 查一个

    String findAllEmailAddress(); //获取全部邮箱信息

}
