package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.service.BackendApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestBody BackendApplicationDto backendApplicationDto)
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.saveBackendApplication(
                backendApplicationDto);

        LOGGER.info("create backend application 호출");

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<BackendApplicationDto> getBackendApplication(String sid)
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.getBackendApplication(sid);

        LOGGER.info("get backend application 호출");

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<BackendApplicationDto> updateBackendApplication(
            @RequestBody  BackendApplicationDto backendApplicationDto) throws Exception
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.updateBackendApplication(backendApplicationDto);

        LOGGER.info("update backend application 호출");

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBackendApplication (String sid) throws Exception
    {
        backendApplicationService.deleteBackendApplication(sid);

        LOGGER.info("delete backend application 호출");

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

    @PutMapping("/changePassOrNot")
    public ResponseEntity<String> changeBackendApplicationPassOrNot(
            String sid) throws Exception
    {
        backendApplicationService.changePossOrNot(sid);
        LOGGER.info("change backend application pass or not 호출");

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }


}
