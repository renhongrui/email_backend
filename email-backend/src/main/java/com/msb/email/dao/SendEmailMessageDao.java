package com.msb.email.dao;


import com.msb.email.entity.SendEmailMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendEmailMessageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SendEmailMessage record);

    int insertSelective(SendEmailMessage record);

    SendEmailMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SendEmailMessage record);

    int updateByPrimaryKey(SendEmailMessage record);

    List<SendEmailMessage> findAll();  //    查询全部

    List<SendEmailMessage> selectPage(@Param(value = "searchKey") String searchKey); //分页 查询数据库的全部内容

}