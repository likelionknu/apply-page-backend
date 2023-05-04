package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.service.BaseApplication_QService;
import com.springboot.applypage.service.DesignApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/BaseApplication_Q")
public class BaseApplication_QController {
    private final BaseApplication_QService baseApplication_QService;
    private final Logger LOGGER = LoggerFactory.getLogger(BaseApplication_QController.class);

    @Autowired
    public BaseApplication_QController(BaseApplication_QService baseApplication_QService){
        this.baseApplication_QService = baseApplication_QService;
    }

    @PostMapping()
    public ResponseEntity<BaseApplication_QDto> createBaseApplication_Q(
            @RequestBody BaseApplication_QDto baseApplication_QDto, HttpServletRequest request)
    {
        BaseApplication_QDto baseApplication_QDtoResponse = baseApplication_QService.saveBaseApplication_Q(
                baseApplication_QDto);

        LOGGER.info("호출 API: " + "create BaseApplication_Q" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(baseApplication_QDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<BaseApplication_QDto> getBaseApplication_Q(Long Q_id, HttpServletRequest request)
    {
        BaseApplication_QDto baseApplication_QDtoDtoResponse = baseApplication_QService.getBaseApplication_Q(Q_id);

        LOGGER.info("호출 API: " + "get BaseApplication_Q" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(baseApplication_QDtoDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<BaseApplication_QDto> updateBaseApplication_Q(
            @RequestBody  BaseApplication_QDto baseApplication_QDto, HttpServletRequest request) throws Exception
    {
        BaseApplication_QDto baseApplication_QDtoResponse = baseApplication_QService.updateBaseApplication_Q(baseApplication_QDto);

        LOGGER.info("호출 API: " + "update BaseApplication_Q" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(baseApplication_QDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBaseApplication_Q (Long Q_id, HttpServletRequest request) throws Exception
    {
        baseApplication_QService.deleteBaseApplication_Q(Q_id);

        LOGGER.info("호출 API: " + "delete BaseApplication_A" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

}
