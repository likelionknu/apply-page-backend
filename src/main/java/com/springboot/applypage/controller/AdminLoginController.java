package com.springboot.applypage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/adminLogin")
public class AdminLoginController {

    private final Logger LOGGER = LoggerFactory.getLogger(BackendApplicationController.class);

    @PostMapping()
    public Boolean getAdminLoginResult(String id, String pw, HttpServletRequest request){

        LOGGER.info("호출 API: " + "get admin login result" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());


        if(id.equals("handsomehw") && pw.equals("1225"))
            return true;
        else
            return false;
    }
}
