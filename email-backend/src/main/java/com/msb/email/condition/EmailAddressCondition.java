package com.msb.email.condition;

import io.swagger.annotations.ApiModelProperty;

public class EmailAddressCondition {

    @ApiModelProperty(value = "Email地址")
    private String emailAddress = "无";

    @ApiModelProperty(value = "姓名")
    private String emailName = "无";

    @ApiModelProperty(value = "备注")
    private String remarks = "无";

    @ApiModelProperty(value = "操作")
    private String createDate = "无";
}
