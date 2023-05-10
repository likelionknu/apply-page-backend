package com.springboot.applypage.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 발급 받은 access_token",
                    required = true,
                    dataType = "String",
                    paramType = "header")
    })
    @PostMapping()
    public Boolean getAdminLoginResult(HttpServletRequest request){

        LOGGER.info("호출 API: get admin login result 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " + LocalDateTime.now());
        return true;

    }


    /*
    @PostMapping()
    public Boolean getAdminLoginResult(String id, String pw, HttpServletRequest request){

        LOGGER.info("호출 API: get admin login result 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " + LocalDateTime.now());
        return id.equals("handsomehw") && pw.equals("1225") ? true : false;

    }*/
}
