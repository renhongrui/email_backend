package com.msb.email.controller;


import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.service.EmailAddressServer;
import com.msb.email.vo.CommResponse;
import com.msb.email.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/emailAddress")
@Api(value = "Email Address Controller", tags = "默认收件人提测接口")
@Log4j2
public class EmailAddressController {

    @Autowired
    EmailAddressServer emailAddressServer;

    //查全部
    @ApiOperation(value = "查询邮件地址", response = CommResponse.class, notes = "查询邮件地址列表接口")
    @RequestMapping(value = "/selectEmailAddressList",method = RequestMethod.GET)
    @ResponseBody
    public CommResponse selectEmailAddressList(){

        List list = emailAddressServer.selectEmailAddress();
        return CommResponse.success(list);

    }


    //分页查
    @ApiOperation(value = "查询邮件地址分页", response = CommResponse.class, notes = "查询邮件地址分页接口")
    @RequestMapping(value = "/selectEmailAddressPage",method = RequestMethod.GET)
    @ResponseBody
    public CommResponse selectEmailAddressPage(@RequestParam(value = "pageSize") int pageSize,
                                               @RequestParam(value = "currentPage") int currentPage,
                                               /*@RequestParam(value = "searchKey")*/ String searchKey ){
        if(pageSize < 1){
            pageSize = 10;
        }

        if(currentPage<1){
            currentPage = 1;
        }
        PageRequestCondition condition = new PageRequestCondition();
        condition.setPageNum(currentPage);
        condition.setPageSize(pageSize);
        condition.setSearchKey(searchKey);
        PageResult pageResult = emailAddressServer.findPage(condition);
        return CommResponse.success(pageResult);

    }

}
