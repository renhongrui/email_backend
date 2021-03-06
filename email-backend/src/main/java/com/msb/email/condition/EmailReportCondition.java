package com.msb.email.condition;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class EmailReportCondition {

    @ApiModelProperty(value = "项目名称")
    private String projectName = "无";

    @ApiModelProperty(value = "提测功能描述")
    private String submitDescribe = "无";

    @ApiModelProperty(value = "Code Review人员")
    private String codeReview = "无";

    @ApiModelProperty(value = "准入Case执行情况")
    private String caseInfo = "无";

    @ApiModelProperty(value = "产品经理")
    private String productManager;

    @ApiModelProperty(value = "前端开发")
    private String webDeveloper;

    @ApiModelProperty(value = "后端开发")
    private String backEndDeveloper;

    @ApiModelProperty(value = "测试人员")
    private String tester;

    @ApiModelProperty(value = "客户端开发")
    private String clientDeveloper;

    @ApiModelProperty(value = "前端和后端联调")
    private String frontEndDebug;

    @ApiModelProperty(value = "git仓库地址")
    private String gitUrl;

    @ApiModelProperty(value = "git分支名称")
    private String girName;

    @ApiModelProperty(value = "是否进行压力测试评估")
    private String result;

    @ApiModelProperty(value = "收件人")
    private String toPerson;

    @ApiModelProperty(value = "默认收件人")
    private String ccEmailAddress;

    @ApiModelProperty(value = "内容")
    private String content;

}
