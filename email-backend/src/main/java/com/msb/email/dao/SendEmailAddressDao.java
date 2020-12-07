package com.msb.email.dao;

import com.msb.email.entity.SendEmailAddress;
import com.msb.email.entity.SendEmailMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendEmailAddressDao {

    Boolean deleteByPrimaryKey(Integer id); //删

    Boolean updateByPrimaryKeySelective(SendEmailAddress record); //改

    int insertSelective(SendEmailAddress record); //增

    SendEmailAddress selectByPrimaryKey(Integer id); // 查一个

    List<SendEmailAddress> findAll();  //    查询全部

    List<SendEmailAddress> selectPage(@Param(value = "searchKey") String searchKey); //分页 查询数据库的全部内容


}
