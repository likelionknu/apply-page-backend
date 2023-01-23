package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.service.BackendApplicationService;
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
@RequestMapping("/backendApplication")
public class BackendApplicationController {
    private final BackendApplicationService backendApplicationService;

    private final Logger LOGGER = LoggerFactory.getLogger(BackendApplicationController.class);

    @Autowired
    public BackendApplicationController(BackendApplicationService backendApplicationService){
        this.backendApplicationService = backendApplicationService;
    }

    @PostMapping()
    public ResponseEntity<BackendApplicationDto> createBackendApplication(
            @RequestBody BackendApplicationDto backendApplicationDto, HttpServletRequest request)
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.saveBackendApplication(
                backendApplicationDto);

        LOGGER.info("호출 API: " + "create backend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<BackendApplicationDto> getBackendApplication(String sid, HttpServletRequest request)
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.getBackendApplication(sid);

        LOGGER.info("호출 API: " + "get backend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<BackendApplicationDto> updateBackendApplication(
            @RequestBody  BackendApplicationDto backendApplicationDto, HttpServletRequest request) throws Exception
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.updateBackendApplication(backendApplicationDto);

        LOGGER.info("호출 API: " + "update backend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBackendApplication (String sid, HttpServletRequest request) throws Exception
    {
        backendApplicationService.deleteBackendApplication(sid);

        LOGGER.info("호출 API: " + "delete backend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

    @PutMapping("/changePassOrNot")
    public ResponseEntity<String> changeBackendApplicationPassOrNot(
            String sid, HttpServletRequest request) throws Exception
    {
        backendApplicationService.changePossOrNot(sid);
        LOGGER.info("호출 API: " + "change backend application pass or not" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }


    @GetMapping("/getApplications")
    public ResponseEntity<List<BackendApplication>> getBackendApplicationWithBoolean(Boolean bool, HttpServletRequest request)
    {
        List<BackendApplication> backendApplicationResponse = backendApplicationService.getReturn(bool);

        LOGGER.info("호출 API: " + "get backend application with boolean" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationResponse);
    }

    @GetMapping("/getAllApplications")
    public ResponseEntity<List<BackendApplication>> getAllBackendApplications(HttpServletRequest request)
    {
        List<BackendApplication> backendApplicationResponse = backendApplicationService.getAllApplications();

        LOGGER.info("호출 API: " + "get all backend application" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationResponse);
    }


}
