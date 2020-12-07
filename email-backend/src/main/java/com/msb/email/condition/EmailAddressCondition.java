package com.msb.email.condition;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EmailAddressCondition {

    @ApiModelProperty(value = "邮件编号")
    private int id = 0;

    @ApiModelProperty(value = "Email地址")
    private String emailAddress = "无";

    @ApiModelProperty(value = "姓名")
    private String emailName = "无";

    @ApiModelProperty(value = "备注")
    private String remarks = "无";

    @ApiModelProperty(value = "操作")
    private String createDate = "无";
}
