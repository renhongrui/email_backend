package com.msb.email.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.dao.SendEmailAddressDao;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.msb.email.service.EmailAddressServer;
import com.msb.email.utils.PageUtils;
import com.msb.email.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailAddressServerImpl implements EmailAddressServer {

    @Autowired
    SendEmailAddressDao sendEmailAddressDao;

    @Override
    public Boolean insertEmail(EmailAddressCondition condition) {
        return null;
    }

    @Override
    public List selectEmailAddress() {
        return sendEmailAddressDao.findAll();
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
    private PageInfo getPageInfo(PageRequestCondition pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List  sysMenus = sendEmailAddressDao.selectPage(pageRequest.getSearchKey());
        return new PageInfo(sysMenus);
    }
}
