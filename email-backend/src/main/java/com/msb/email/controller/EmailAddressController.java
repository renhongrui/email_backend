package com.msb.email.controller;


import com.alibaba.fastjson.JSONObject;
import com.msb.email.condition.EmailAddressCondition;
import com.msb.email.condition.EmailReportCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.entity.SendEmailAddress;
import com.msb.email.service.EmailAddressServer;
import com.msb.email.service.EmailService;
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


    //查一条抄送人数据
    @ApiOperation(value = "查询单条抄送人邮件", response = CommResponse.class, notes = "查单条抄送人接口")
    @RequestMapping(value = "/selectEmailById", method = RequestMethod.POST)
    @ResponseBody
    public CommResponse selectEmailById(@RequestBody Integer id){

        SendEmailAddress sendEmailAddress =  emailAddressServer.selectEmailById(id);
        return CommResponse.success(sendEmailAddress);
    }



    //查全部
    @ApiOperation(value = "查询抄送人邮件地址", response = CommResponse.class, notes = "查询抄送人邮件地址列表接口")
    @RequestMapping(value = "/selectEmailAddressList",method = RequestMethod.GET)
    @ResponseBody
    public CommResponse selectEmailAddressList(){

        List list = emailAddressServer.selectEmailAddress();
        return CommResponse.success(list);

    }


    //分页查
    @ApiOperation(value = "查询抄送人邮件地址分页", response = CommResponse.class, notes = "查询抄送人邮件地址分页接口")
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


    //添加抄送人
    @ApiOperation(value = "添加抄送人", response = CommResponse.class, notes = "添加抄送人邮件接口")
    @RequestMapping(value = "/insertEmail", method = RequestMethod.POST)
    @ResponseBody
    public CommResponse insertEmail(@RequestBody EmailAddressCondition condition) {
        log.info("添加抄送人邮件接口，参数：{}", JSONObject.toJSONString(condition));
        Boolean ret = emailAddressServer.insertEmail(condition);
        return CommResponse.success(ret);
    }



    //删除抄送人邮箱
    @ApiOperation(value = "删除抄送人邮箱", response = CommResponse.class, notes = "删除抄送人邮箱接口")
    @RequestMapping(value = "/deleteEmail", method = RequestMethod.POST)
    @ResponseBody
    public CommResponse deleteEmail(@RequestBody Integer id){
        log.info("删除抄送人邮箱接口");
        if(id < 0){
            id = 0;
        }
        Boolean res = emailAddressServer.deleteEmail(id);
        return CommResponse.success(res);
    }



    //修改抄送人邮箱
    @ApiOperation(value = "修改抄送人邮件", response = CommResponse.class, notes = "修改抄送人邮件接口")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    public CommResponse updateByPrimaryKeySelective(@RequestBody EmailAddressCondition condition){
        log.info("修改抄送人接口");

        Boolean res = emailAddressServer.updateEmail(condition);
        return CommResponse.success(res);
    }




}
