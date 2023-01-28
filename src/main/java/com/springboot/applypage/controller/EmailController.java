package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.AcceptEmailDto;
import com.springboot.applypage.service.impl.MailSenderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/emailSender")
public class EmailController {

    MailSenderServiceImpl mailSenderService;
    private final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    public EmailController(MailSenderServiceImpl mailSenderService){
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/sendAcceptMail")
    public String sendAcceptEmail(@RequestBody List<AcceptEmailDto> acceptEmailDto , HttpServletRequest request) throws MessagingException {

        mailSenderService.sendAcceptMail(acceptEmailDto);
        LOGGER.info("호출 API: " + "send accept email" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return "정상 작동 되었습니다.";
    }
}
