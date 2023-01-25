package com.springboot.applypage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;

@Service
public class MailSenderService
{

    private final JavaMailSender javaMailSender;
    private SpringTemplateEngine templateEngine;

    @Autowired
    public MailSenderService(JavaMailSender javaMailSender, SpringTemplateEngine springTemplateEngine){
        this.javaMailSender = javaMailSender;
        this.templateEngine = springTemplateEngine;
    }

    public void sendMail() throws MessagingException {
        /*ArrayList<String> toUserList = new ArrayList<>();
        int toUserSize;

        toUserList.add("scg9268@naver.com");
        toUserSize = toUserList.size();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Subject");
        simpleMailMessage.setText("Text Sample");

        javaMailSender.send(simpleMailMessage);*/

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //메일 제목 설정
        helper.setSubject("title");

        //수신자 설정
        helper.setTo("scg9268@naver.com");

        //템플릿에 전달할 데이터 설정
        Context context = new Context();
        /*values.forEach((key, value)->{
            context.setVariable(key, value);
        });*/

        //메일 내용 설정 : 템플릿 프로세스
        String html = templateEngine.process("index.html",context);
        helper.setText(html, true);

        //메일 보내기
        javaMailSender.send(message);

    }
}
