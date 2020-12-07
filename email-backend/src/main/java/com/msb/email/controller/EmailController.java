package com.msb.email.controller;


import com.alibaba.fastjson.JSONObject;
import com.msb.email.condition.EmailReportCondition;
import com.msb.email.condition.PageRequestCondition;
import com.msb.email.entity.SendEmailMessage;
import com.msb.email.service.EmailService;
import com.msb.email.vo.PageResult;
import com.msb.email.vo.CommResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/email/")
@Api(value = "Email Controller", tags = "邮件提测接口")
@Log4j2
public class EmailController {


    @Autowired
    private EmailService emailService;


    @ApiOperation(value = "发送邮件", response = CommResponse.class, notes = "发送邮件接口")
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    @ResponseBody
    public CommResponse sendEmail(@RequestBody EmailReportCondition condition) {
        log.info("请求发送邮件接口，参数：{}", JSONObject.toJSONString(condition));
        Boolean ret = emailService.sendEmail(condition);
       return CommResponse.success(ret);
    }




    @ApiOperation(value = "查询邮件", response = CommResponse.class, notes = "查询邮件列表接口")
    @RequestMapping(value = "/selectEmailList",method = RequestMethod.GET)
    @ResponseBody
    public CommResponse selectEmailList(){

        List list = emailService.selectEmailList();
        return CommResponse.success(list);
    }


    @ApiOperation(value = "查询指定编号邮件", response = CommResponse.class, notes = "查询指定编号邮件接口")
    @RequestMapping(value = "/selectEmail",method = RequestMethod.GET)
    @ResponseBody
    public CommResponse  selectEmailById(@RequestParam(value = "recordId") Integer id){

        SendEmailMessage sendEmailMessage = emailService.selectEmailById(id);
        return CommResponse.success(sendEmailMessage);

    }

    @ApiOperation(value = "查询分页", response = CommResponse.class, notes = "查询分页接口")
    @RequestMapping(value = "/findEmailHistory", method = RequestMethod.GET)
    @ResponseBody
    public CommResponse findEmailHistory(@RequestParam(value = "pageSize") int pageSize,
                                         @RequestParam(value = "currentPage") int currentPage,
                                         @RequestParam(value = "searchKey") String searchKey) {

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
        PageResult pageResult = emailService.findPage(condition);
        return CommResponse.success(pageResult);
    }


}
