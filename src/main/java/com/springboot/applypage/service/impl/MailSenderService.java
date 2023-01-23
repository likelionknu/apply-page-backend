package com.springboot.applypage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MailSenderService
{

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSenderService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(){
        ArrayList<String> toUserList = new ArrayList<>();
        int toUserSize;

        toUserList.add("scg9268@naver.com");
        toUserSize = toUserList.size();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
        simpleMailMessage.setSubject("Subject");
        simpleMailMessage.setText("Text Sample");

        javaMailSender.send(simpleMailMessage);

    }
}
