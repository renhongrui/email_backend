package com.msb.email.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.dao.SendEmailAddressDao;
import com.msb.email.entity.SendEmailAddress;
import com.msb.email.exception.BusinessException;
import com.msb.email.exception.BusinessExceptionCode;
import com.msb.email.service.EmailAddressServer;
import com.msb.email.utils.PageUtils;
import com.msb.email.vo.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class EmailAddressServerImpl implements EmailAddressServer {

    @Autowired
    SendEmailAddressDao sendEmailAddressDao;



    @Override
    public Boolean insertEmail(EmailAddressCondition condition) {

        //抄送人邮箱
        String emailAddress = condition.getEmailAddress();

        if(emailAddress == null){
            throw new BusinessException(BusinessExceptionCode.ERROR_5000,"参数错误，抄送人邮件不能为空");
        }

        //抄送人姓名
        //TODO 这个属性没用就删掉
        String emailName = condition.getEmailName();


        SendEmailAddress sendEmailAddress= new SendEmailAddress();
        BeanUtils.copyProperties(condition,sendEmailAddress);
        //获取发送邮件时间
        Date now = new Date();
        sendEmailAddress.setCreateDate(now);

        sendEmailAddressDao.insertSelective(sendEmailAddress);
        return true;
    }



    @Override
    public Boolean deleteEmail(Integer id) {
        return sendEmailAddressDao.deleteByPrimaryKey(id);
    }



    @Override
    public Boolean updateEmail(EmailAddressCondition condition) {

        SendEmailAddress sendEmailAddress= new SendEmailAddress();
        //TODO 先通过id把数据查询出来 判断是否存在，如果存在直接修改，不需要指定时间， 你这个是创建时间， 如果想要改成修改时间，可以在数据库在创建个修改时间的字段
        BeanUtils.copyProperties(condition,sendEmailAddress);
        //获取修改邮件时间
        Date now = new Date();
        sendEmailAddress.setCreateDate(now);
        sendEmailAddressDao.updateByPrimaryKeySelective(sendEmailAddress);

        return true;
    }



    @Override
    public List selectEmailAddress() {
        return sendEmailAddressDao.findAll();
    }


    @Override
    public PageResult findPage(PageRequestCondition pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }



    @Override
    public SendEmailAddress selectEmailById(Integer id) {
        if(id == null){
            throw new BusinessException(BusinessExceptionCode.ERROR_5000,"参数错误，查询的抄送人不存在");
        }
        return sendEmailAddressDao.selectByPrimaryKey(id);
    }



    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo getPageInfo(PageRequestCondition pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List sysMenus = sendEmailAddressDao.selectPage(pageRequest.getSearchKey());
        return new PageInfo(sysMenus);
    }
}
