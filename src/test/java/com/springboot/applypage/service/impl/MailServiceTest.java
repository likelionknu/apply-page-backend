package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dto.AcceptEmailDto;
import com.springboot.applypage.service.MailSenderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring5.SpringTemplateEngine;

public class MailServiceTest {

    /*@Autowired
    private MailSenderService mailSenderService;

    @Test
    void sendVerificationMailTest() throws Exception{
        AcceptEmailDto acceptEmailDto = new AcceptEmailDto();
        acceptEmailDto.setEmail("scg9268@naver.com");
        System.out.println(mailSenderService);
        Integer verificationNum = mailSenderService.sendVerificationMail(acceptEmailDto);
        System.out.println(verificationNum);
    }*/
}
