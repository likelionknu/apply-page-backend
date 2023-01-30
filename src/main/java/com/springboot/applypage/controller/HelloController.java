package com.springboot.applypage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
public class HelloController implements ErrorController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping({ "/", "/error" })
    public String index(HttpServletRequest request) {

        LOGGER.info("main page 최초 접속" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return "index";
    }

    public String getErrorPath() {
        return "/error";
    }

}