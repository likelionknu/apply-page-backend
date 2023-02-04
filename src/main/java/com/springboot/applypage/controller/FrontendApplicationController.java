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
    private final Logger LOGGER = LoggerFactory.getLogger(FrontendApplicationController.class);

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

    @GetMapping("/getFrontendApplicationWithEmail")
    public ResponseEntity<FrontendApplicationDto> getFrontendApplicationWithEmail(String sid, String email, HttpServletRequest request)
    {
        FrontendApplicationDto frontendApplication = frontendApplicationService.getFrontendApplicationWithEmail(sid, email);
        LOGGER.info("호출 API: " + "get frontend application with email" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

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

    @PutMapping("/changeSendMail")
    public ResponseEntity<String> changeFrontendApplicationSendMail(
            String sid, HttpServletRequest request) throws Exception
    {
        frontendApplicationService.changeSendMail(sid);
        LOGGER.info("호출 API: " + "change frontend application send mail" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }

    @GetMapping("/getApplications")
    public ResponseEntity<List<FrontendApplication>> getFrontendApplicationWithBoolean(Boolean bool, HttpServletRequest request)
    {
        List<FrontendApplication> frontendApplicationResponse = frontendApplicationService.getReturn(bool);
        LOGGER.info("호출 API: " + "get frontend application with boolean" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

    @GetMapping("/getSubmissionApplications")
    public ResponseEntity<List<FrontendApplication>> getFrontendApplicationWithSubmissionStatus(Boolean bool, HttpServletRequest request)
    {
        List<FrontendApplication> frontendApplicationResponse = frontendApplicationService.getSubmissionApplication(bool);
        LOGGER.info("호출 API: " + "get frontend application with submission status" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

    @GetMapping("/getApplicationsWithPassOrNotAndSubmission")
    public ResponseEntity<List<FrontendApplication>> getFrontendApplicationWithPassOrNotAndSubmission(Boolean passOrNot, Boolean submission, HttpServletRequest request)
    {
        List<FrontendApplication> frontendApplicationResponse = frontendApplicationService.getApplicationsWithPassOrNotAndSubmission(passOrNot, submission);
        LOGGER.info("호출 API: " + "get frontend application with pass or not submission" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

    @GetMapping("/getAllApplications")
    public ResponseEntity<List<FrontendApplication>> getAllFrontendApplications(HttpServletRequest request)
    {
        List<FrontendApplication> frontendApplicationResponse = frontendApplicationService.getAllApplications();
        LOGGER.info("호출 API: " + "get all frontend applications" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

}
