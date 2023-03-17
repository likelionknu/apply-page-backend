package com.springboot.applypage.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(
            HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , AccessDeniedException e) throws IOException, ServletException {

        LOGGER.info("[handle] 접근이 막혔을 경우 경로 리다이렉트");
        httpServletResponse.sendRedirect("/sign-api/exception");
    }
}
