package com.springboot.applypage.controller;

import com.springboot.applypage.service.impl.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController implements ErrorController {

    @Autowired
    MailSenderService mailSenderService;

    @GetMapping({ "/", "/error" })
    public String index() {
        return "index";
    }

    public String getErrorPath() {
        return "/error";
    }


    @GetMapping("/sendMail")
    public String sendMail() {

        mailSenderService.sendMail();

        return "정상 작동 되었습니다.";
    }

}