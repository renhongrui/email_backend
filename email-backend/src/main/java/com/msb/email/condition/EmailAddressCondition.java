package com.msb.email.condition;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EmailAddressCondition {

    //TODO 根据实际情况判断，默认不需要初始化 无，  直接private String emailAddress 就可以
    @ApiModelProperty(value = "Email地址")
    private String emailAddress = "无";

    @ApiModelProperty(value = "姓名")
    private String emailName = "无";

    @ApiModelProperty(value = "备注")
    private String remarks = "无";
    //TODO 创建实际不用传，这个参数可以删掉，后台自己获取服务器时间 new Date()
    @ApiModelProperty(value = "操作")
    private String createDate = "无";
}
