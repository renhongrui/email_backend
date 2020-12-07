package com.msb.email.service.impl;

import com.msb.email.condition.EmailReportCondition;
import com.msb.email.dao.*;
import com.msb.email.entity.SendEmailMessage;
import com.msb.email.exception.BusinessException;
import com.msb.email.exception.BusinessExceptionCode;
import com.msb.email.service.EmailService;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.vo.PageResult;
import com.msb.email.utils.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private SendEmailMessageDao sendEmailMessageDao;

    @Override
    public Boolean sendEmail(EmailReportCondition condition) {

        String projectName = condition.getProjectName() + "提测";
        condition.setProjectName(projectName);

        //收件人
        String toPerson = condition.getToPerson();

        if(toPerson == null){
            throw new BusinessException(BusinessExceptionCode.ERROR_5000,"参数错误，收件人不能为空");
        }
        String[] toPersons = toPerson.split(",");

        //获取邮件内容
        String content = sendEmailService.getContent(condition);
        String from;
        //发送邮件
        try {
            from = sendEmailService.sendHtmlMail(toPersons,projectName,content);
        } catch (MessagingException e) {
            throw new BusinessException(BusinessExceptionCode.ERROR_5001,"发送邮件失败");
        }

        SendEmailMessage sendEmailMessage = new SendEmailMessage();
        BeanUtils.copyProperties(condition,sendEmailMessage);
        //获取发送邮件时间
        Date now = new Date();
        sendEmailMessage.setCreateTime(now);
        sendEmailMessage.setModifyTime(now);
        sendEmailMessage.setFromPerson(from);

        //保存发送邮件记录
        sendEmailMessageDao.insertSelective(sendEmailMessage);
        return true;
    }

    @Override
    public List selectEmailList() {

        return sendEmailMessageDao.findAll();
    }

    @Override
    public SendEmailMessage selectEmailById(Integer id) {

        return sendEmailMessageDao.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequestCondition pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }




    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<SendEmailMessage> getPageInfo(PageRequestCondition pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SendEmailMessage>  sysMenus = sendEmailMessageDao.selectPage(pageRequest.getSearchKey());
        return new PageInfo<SendEmailMessage>(sysMenus);
    }

}
