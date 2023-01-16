package com.springboot.applypage.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController implements ErrorController {

    @GetMapping({ "/", "/error" })
    public String index() {
        return "index";
    }

    public String getErrorPath() {
        return "/error";
    }

}