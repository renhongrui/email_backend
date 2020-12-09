package com.msb.email.condition;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EmailAddressCondition {

    @ApiModelProperty(value = "邮件编号")
    private int id;

    @ApiModelProperty(value = "Email地址")
    private String emailAddress;

    @ApiModelProperty(value = "姓名")
    private String emailName;

    @ApiModelProperty(value = "备注")
    private String remarks;


    @ApiModelProperty(value = "类型1是添加，2是修改")
    private int type;


}
