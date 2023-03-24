package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dto.AcceptEmailDto;
import com.springboot.applypage.service.MailSenderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring5.SpringTemplateEngine;

public class MailServiceTest {

    private MailSenderService mailSenderService;
    private final JavaMailSender javaMailSender = Mockito.mock(JavaMailSender.class);
    private SpringTemplateEngine templateEngine = Mockito.mock(SpringTemplateEngine.class);

    @BeforeEach
    void setTest(){
        mailSenderService = new MailSenderServiceImpl(javaMailSender, templateEngine);
    }

    @Test
    void sendVerificationMailTest() throws Exception{
        AcceptEmailDto acceptEmailDto = new AcceptEmailDto();

        //Mockito.when(javaMailSender.send(any(MimeMessage.class)))
        //Mockito.when(templateEngine.process("acceptEmail.html", any(Context.class))).then(Objects::toString);

        /*acceptEmailDto.setEmail("scg9268@naver.com");
        System.out.println(mailSenderService);
        Integer verificationNum = mailSenderService.sendVerificationMail(acceptEmailDto);
        System.out.println(verificationNum);*/
    }
}
