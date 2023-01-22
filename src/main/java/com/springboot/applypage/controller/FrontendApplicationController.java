package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.dto.FrontendApplicationDto;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.FrontendApplication;
import com.springboot.applypage.service.FrontendApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/frontendApplication")
public class FrontendApplicationController {

    private final FrontendApplicationService frontendApplicationService;
    private final Logger LOGGER = LoggerFactory.getLogger(BackendApplicationController.class);

    @Autowired
    public FrontendApplicationController(FrontendApplicationService frontendApplicationService){
        this.frontendApplicationService = frontendApplicationService;
    }

    @PostMapping()
    public ResponseEntity<FrontendApplicationDto> createFrontendApplication(
            @RequestBody FrontendApplicationDto frontendApplicationDto, HttpServletRequest request)
    {
        FrontendApplicationDto frontendApplicationResponse = frontendApplicationService.saveFrontendApplication(
                frontendApplicationDto);
        LOGGER.info("호출 API: " + "create frontend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

    @GetMapping()
    public ResponseEntity<FrontendApplicationDto> getFrontendApplication(String sid, HttpServletRequest request)
    {
        FrontendApplicationDto frontendApplication = frontendApplicationService.getFrontendApplication(sid);
        LOGGER.info("호출 API: " + "get frontend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplication);
    }

    @PutMapping()
    public ResponseEntity<FrontendApplicationDto> updateFrontendApplication(
            @RequestBody FrontendApplicationDto frontendApplicationDto, HttpServletRequest request) throws Exception
    {
        FrontendApplicationDto frontendApplicationDtoResponse = frontendApplicationService.updateFrontendApplication(frontendApplicationDto);
        LOGGER.info("호출 API: " + "update frontend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());


        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteFrontendApplication (String sid, HttpServletRequest request) throws Exception
    {
        frontendApplicationService.deleteFrontendApplication(sid);
        LOGGER.info("호출 API: " + "delete frontend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

    @PutMapping("/changePassOrNot")
    public ResponseEntity<String> changeFrontendApplicationPassOrNot(
            String sid, HttpServletRequest request) throws Exception
    {
        frontendApplicationService.changePossOrNot(sid);
        LOGGER.info("호출 API: " + "change frontend application pass or not" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }

    @GetMapping("/getApplications")
    public ResponseEntity<List<FrontendApplication>> getFrontendApplicationWithBoolean(Boolean bool, HttpServletRequest request)
    {
        List<FrontendApplication> frontendApplicationResponse = frontendApplicationService.getReturn(bool);
        LOGGER.info("호출 API: " + "get frontend application with boolean" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

}
