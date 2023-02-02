package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.service.DesignApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/designApplication")
public class DesignApplicationController {
    private final DesignApplicationService designApplicationService;
    private final Logger LOGGER = LoggerFactory.getLogger(DesignApplicationController.class);

    @Autowired
    public DesignApplicationController(DesignApplicationService designApplicationService){
        this.designApplicationService = designApplicationService;
    }

    @PostMapping()
    public ResponseEntity<DesignApplicationDto> createDesignApplication(
            @RequestBody DesignApplicationDto DesignApplicationDto, HttpServletRequest request)
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.saveDesignApplication(DesignApplicationDto);
        LOGGER.info("호출 API: " + "create design application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<DesignApplicationDto> getDesignApplication(String sid, HttpServletRequest request)
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.getDesignApplication(sid);
        LOGGER.info("호출 API: " + "get design application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @GetMapping("/getDesignApplicationWithEmail")
    public ResponseEntity<DesignApplicationDto> getDesignApplicationWithEmail(String sid, String email, HttpServletRequest request)
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.getDesignApplicationWithEmail(sid, email);
        LOGGER.info("호출 API: " + "get design application with email" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<DesignApplicationDto> updateDesignApplication(
            @RequestBody  DesignApplicationDto designApplicationDto, HttpServletRequest request) throws Exception
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.updateDesignApplication(designApplicationDto);
        LOGGER.info("호출 API: " + "update design application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDesignApplication (String sid, HttpServletRequest request) throws Exception
    {
        designApplicationService.deleteDesignApplication(sid);
        LOGGER.info("호출 API: " + "delete design application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

    @PutMapping("/changePassOrNot")
    public ResponseEntity<String> changeDesignApplicationPassOrNot(
            String sid, HttpServletRequest request) throws Exception
    {
        designApplicationService.changePossOrNot(sid);
        //LOGGER.info("change backend application pass or not 호출");
        LOGGER.info("호출 API: " + "change design application pass or not" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }

    @PutMapping("/changeSendMail")
    public ResponseEntity<String> changeDesignApplicationSendMail(
            String sid, HttpServletRequest request) throws Exception
    {
        designApplicationService.changeSendMail(sid);
        //LOGGER.info("change backend application pass or not 호출");
        LOGGER.info("호출 API: " + "change design application send mail" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }

    @GetMapping("/getApplications")
    public ResponseEntity<List<DesignApplication>> getDesignApplicationWithBoolean(Boolean bool, HttpServletRequest request)
    {
        List<DesignApplication> designApplicationResponse = designApplicationService.getReturn(bool);
        LOGGER.info("호출 API: " + "get design application with boolean" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        //LOGGER.info("get design application with boolean 호출");

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationResponse);
    }

    @GetMapping("/getSubmissionApplications")
    public ResponseEntity<List<DesignApplication>> getDesignApplicationWithSubmissionStatus(
            Boolean bool, HttpServletRequest request)
    {
        List<DesignApplication> designApplicationResponse = designApplicationService.getSubmissionApplication(bool);
        LOGGER.info("호출 API: " + "get design application with submission status" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationResponse);
    }

    @GetMapping("/getAllApplications")
    public ResponseEntity<List<DesignApplication>> getAllDesignApplications(HttpServletRequest request)
    {
        List<DesignApplication> designApplicationResponse = designApplicationService.getAllApplications();
        LOGGER.info("호출 API: " + "get all design applications" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());


        return ResponseEntity.status(HttpStatus.OK).body(designApplicationResponse);
    }
}
