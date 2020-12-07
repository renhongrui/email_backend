package com.msb.email.entity;

import java.io.Serializable;
import java.util.Date;

public class SendEmailMessage implements Serializable {

    private Integer id;

    private String projectName;

    private Date createTime;

    private String creator;

    private String submitDescribe;

    private String codeReview;

    private String caseInfo;

    private String productsResult;

    private String uiResult;

    private String productManager;

    private String webDeveloper;

    private String backEndDeveloper;

    private String tester;

    private String clientDeveloper;

    private String frontEndDebug;

    private String appServerDebug;

    private String throughDebug;

    private String threeDebug;

    private String gitUrl;

    private String girName;

    private String result;

    private Date modifyTime;

    private String reviser;

    private String fromPerson;

    private String toPerson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getSubmitDescribe() {
        return submitDescribe;
    }

    public void setSubmitDescribe(String submitDescribe) {
        this.submitDescribe = submitDescribe == null ? null : submitDescribe.trim();
    }

    public String getCodeReview() {
        return codeReview;
    }

    public void setCodeReview(String codeReview) {
        this.codeReview = codeReview == null ? null : codeReview.trim();
    }

    public String getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(String caseInfo) {
        this.caseInfo = caseInfo == null ? null : caseInfo.trim();
    }

    public String getProductsResult() {
        return productsResult;
    }

    public void setProductsResult(String productsResult) {
        this.productsResult = productsResult == null ? null : productsResult.trim();
    }

    public String getUiResult() {
        return uiResult;
    }

    public void setUiResult(String uiResult) {
        this.uiResult = uiResult == null ? null : uiResult.trim();
    }

    public String getProductManager() {
        return productManager;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager == null ? null : productManager.trim();
    }

    public String getWebDeveloper() {
        return webDeveloper;
    }

    public void setWebDeveloper(String webDeveloper) {
        this.webDeveloper = webDeveloper == null ? null : webDeveloper.trim();
    }

    public String getBackEndDeveloper() {
        return backEndDeveloper;
    }

    public void setBackEndDeveloper(String backEndDeveloper) {
        this.backEndDeveloper = backEndDeveloper == null ? null : backEndDeveloper.trim();
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester == null ? null : tester.trim();
    }

    public String getClientDeveloper() {
        return clientDeveloper;
    }

    public void setClientDeveloper(String clientDeveloper) {
        this.clientDeveloper = clientDeveloper == null ? null : clientDeveloper.trim();
    }

    public String getFrontEndDebug() {
        return frontEndDebug;
    }

    public void setFrontEndDebug(String frontEndDebug) {
        this.frontEndDebug = frontEndDebug == null ? null : frontEndDebug.trim();
    }

    public String getAppServerDebug() {
        return appServerDebug;
    }

    public void setAppServerDebug(String appServerDebug) {
        this.appServerDebug = appServerDebug == null ? null : appServerDebug.trim();
    }

    public String getThroughDebug() {
        return throughDebug;
    }

    public void setThroughDebug(String throughDebug) {
        this.throughDebug = throughDebug == null ? null : throughDebug.trim();
    }

    public String getThreeDebug() {
        return threeDebug;
    }

    public void setThreeDebug(String threeDebug) {
        this.threeDebug = threeDebug == null ? null : threeDebug.trim();
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl == null ? null : gitUrl.trim();
    }

    public String getGirName() {
        return girName;
    }

    public void setGirName(String girName) {
        this.girName = girName == null ? null : girName.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser == null ? null : reviser.trim();
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson == null ? null : fromPerson.trim();
    }

    public String getToPerson() {
        return toPerson;
    }

    public void setToPerson(String toPerson) {
        this.toPerson = toPerson == null ? null : toPerson.trim();
    }
}