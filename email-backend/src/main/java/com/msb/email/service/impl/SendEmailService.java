package com.msb.email.service.impl;

import com.msb.email.condition.EmailReportCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Log4j2
public class SendEmailService {

    //使用@Value注入application.properties中指定的用户名
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Resource
    private TemplateEngine templateEngine;

    /**
     * 发送普通邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String[] to, String subject, String content) throws MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);//收信人
        message.setSubject(subject);//主题
        message.setText(content);//内容
        message.setFrom(from);//发信人

        mailSender.send(message);
    }

    /**
     * 发送HTML文件
     * @param to
     * @param subject
     * @param content
     */
    public String sendHtmlMail(String[] to, String subject, String content) throws MessagingException {

        log.info("发送HTML邮件开始：{},{},{}", to, subject, content);
        //使用MimeMessage，MIME协议
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        //MimeMessageHelper帮助我们设置更丰富的内容

        helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);//true代表支持html
        mailSender.send(message);
        log.info("发送HTML邮件成功");
        return from;
    }

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendAttachmentMail(String[] to, String subject, String content, String filePath) throws MessagingException {

        log.info("发送带附件邮件开始：{},{},{},{}", to, subject, content, filePath);
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true);
        //true代表支持多组件，如附件，图片等
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName, file);//添加附件，可多次调用该方法添加多个附件
        mailSender.send(message);
        log.info("发送带附件邮件成功");


    }

    /**
     * 发送带图片的邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendInlineResourceMail(String[] to, String subject, String content, String rscPath, String rscId) throws MessagingException {

        log.info("发送带图片邮件开始：{},{},{},{},{}", to, subject, content, rscPath, rscId);
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource res = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId, res);//重复使用添加多个图片
        mailSender.send(message);
        log.info("发送带图片邮件成功");

    }

    public String getContent(EmailReportCondition condition){
        Context context = new Context();
        //定义模板数据
        context.setVariable("projectName",condition.getProjectName());
        context.setVariable("subidescribe",condition.getSubmitDescribe());
        context.setVariable("codeReview",condition.getCodeReview());
        context.setVariable("caseInfo",condition.getCaseInfo());
        context.setVariable("productsResult",condition.getProductsResult());
        context.setVariable("uiResult",condition.getUiResult());
        context.setVariable("productManager",condition.getProductManager());
        context.setVariable("webDeveloper",condition.getWebDeveloper());
        context.setVariable("backEndDeveloper",condition.getBackEndDeveloper());
        context.setVariable("clientDeveloper",condition.getClientDeveloper());
        context.setVariable("tester",condition.getTester());
        context.setVariable("frontEndDebug",condition.getFrontEndDebug());
        context.setVariable("appServerDebug",condition.getAppServerDebug());
        context.setVariable("throughDebug",condition.getThroughDebug());
        context.setVariable("threeDebug",condition.getThreeDebug());
        context.setVariable("gitUrl",condition.getGitUrl());
        context.setVariable("girName",condition.getGirName());
        context.setVariable("result",condition.getResult());
        //获取thymeleaf的html模板
        return templateEngine.process("email.html",context); //指定模板路径
    }
}
