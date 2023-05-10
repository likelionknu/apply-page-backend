package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.dto.ChangeHistoryDto;
import com.springboot.applypage.service.BaseApplication_QService;
import com.springboot.applypage.service.ChangeHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/ChangeHistory")
public class ChangeHistoryController {
    private final ChangeHistoryService changeHistoryService;
    private final Logger LOGGER = LoggerFactory.getLogger(ChangeHistoryService.class);

    @Autowired
    public ChangeHistoryController(ChangeHistoryService changeHistoryService){
        this.changeHistoryService = changeHistoryService;
    }

    @PostMapping()
    public ResponseEntity<ChangeHistoryDto> createChangeHistory(
            @RequestBody ChangeHistoryDto changeHistoryDto, HttpServletRequest request)
    {
        ChangeHistoryDto changeHistoryDtoResponse = changeHistoryService.saveChangeHistory(
                changeHistoryDto);

        LOGGER.info("호출 API: " + "create ChangeHistory" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(changeHistoryDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<ChangeHistoryDto> getBaseChangeHistory(Long sid, HttpServletRequest request)
    {
        ChangeHistoryDto changeHistoryDtoResponse = changeHistoryService.getChangeHistory(sid);

        LOGGER.info("호출 API: " + "get ChangeHistory" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(changeHistoryDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<ChangeHistoryDto> updateChangeHistory(
            @RequestBody  ChangeHistoryDto changeHistoryDto, HttpServletRequest request) throws Exception
    {
        ChangeHistoryDto changeHistoryDtoResponse = changeHistoryService.updateChangeHistory(changeHistoryDto);

        LOGGER.info("호출 API: " + "update ChangeHistory" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(changeHistoryDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteChangeHistory (Long sid, HttpServletRequest request) throws Exception
    {
        changeHistoryService.deleteChangeHistory(sid);

        LOGGER.info("호출 API: " + "delete ChangeHistory" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

}
