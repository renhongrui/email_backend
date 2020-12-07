package com.msb.email.dao;

import com.msb.email.entity.SendEmailAddress;
import com.msb.email.entity.SendEmailMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendEmailAddressDao {

    int deleteByPrimaryKey(Integer id); //删

    int updateByPrimaryKeySelective(SendEmailAddress record); //改

    int insertSelective(SendEmailAddress record); //增 option+ 回车   快速导包

    SendEmailMessage selectByPrimaryKey(Integer id);

    List<SendEmailAddress> findAll();  //    查询全部

    List<SendEmailAddress> selectPage(@Param(value = "searchKey") String searchKey); //分页 查询数据库的全部内容


}
