package com.msb.email.service;

import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.EmailReportCondition;
import com.msb.email.entity.SendEmailMessage;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.vo.PageResult;
import java.util.List;

public interface EmailService {

    Boolean sendEmail(EmailReportCondition condition);

    List selectEmailList();

    SendEmailMessage selectEmailById(Integer id);

    PageResult findPage(PageRequestCondition pageRequest);


}
