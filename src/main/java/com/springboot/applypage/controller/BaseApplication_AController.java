package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BaseApplication_ADto;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.service.BaseApplication_AService;
import com.springboot.applypage.service.BaseApplication_QService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/BaseApplication_A")
public class BaseApplication_AController {
    private final BaseApplication_AService baseApplication_AService;
    private final Logger LOGGER = LoggerFactory.getLogger(BaseApplication_AService.class);

    @Autowired
    public BaseApplication_AController(BaseApplication_AService baseApplication_AService){
        this.baseApplication_AService = baseApplication_AService;
    }

    @PostMapping()
    public ResponseEntity<BaseApplication_ADto> createBaseApplication_A(
            @RequestBody BaseApplication_ADto baseApplication_ADto, HttpServletRequest request)
    {
        BaseApplication_ADto baseApplication_ADtoResponse = baseApplication_AService.saveBaseApplication_A(
                baseApplication_ADto);

        LOGGER.info("호출 API: " + "create BaseApplication_A" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(baseApplication_ADtoResponse);
    }

    @GetMapping()
    public ResponseEntity<BaseApplication_ADto> getBaseApplication_A(Long id, HttpServletRequest request)
    {
        BaseApplication_ADto baseApplication_ADtoResponse = baseApplication_AService.getBaseApplication_A(id);

        LOGGER.info("호출 API: " + "get BaseApplication_A" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(baseApplication_ADtoResponse);
    }

    @PutMapping()
    public ResponseEntity<BaseApplication_ADto> updateBaseApplication_A(
            @RequestBody  BaseApplication_ADto baseApplication_ADto, HttpServletRequest request) throws Exception
    {
        BaseApplication_ADto baseApplication_ADtoResponse = baseApplication_AService.updateBaseApplication_A(baseApplication_ADto);

        LOGGER.info("호출 API: " + "update BaseApplication_A" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(baseApplication_ADtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBaseApplication_A (Long id, HttpServletRequest request) throws Exception
    {
        baseApplication_AService.deleteBaseApplication_A(id);

        LOGGER.info("호출 API: " + "delete BaseApplication_A" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

}
