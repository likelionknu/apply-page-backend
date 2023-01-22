package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.dto.FrontendApplicationDto;
import com.springboot.applypage.service.FrontendApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frontendApplication")
public class FrontendApplicationController {

    private final FrontendApplicationService frontendApplicationService;
    @Autowired
    public FrontendApplicationController(FrontendApplicationService frontendApplicationService){
        this.frontendApplicationService = frontendApplicationService;
    }

    @PostMapping()
    public ResponseEntity<FrontendApplicationDto> createFrontendApplication(
            @RequestBody FrontendApplicationDto frontendApplicationDto)
    {
        FrontendApplicationDto frontendApplicationResponse = frontendApplicationService.saveFrontendApplication(
                frontendApplicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationResponse);
    }

    @GetMapping()
    public ResponseEntity<FrontendApplicationDto> getFrontendApplication(String sid)
    {
        FrontendApplicationDto frontendApplication = frontendApplicationService.getFrontendApplication(sid);

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplication);
    }

    @PutMapping()
    public ResponseEntity<FrontendApplicationDto> updateFrontendApplication(
            @RequestBody  FrontendApplicationDto frontendApplicationDto) throws Exception
    {
        FrontendApplicationDto frontendApplicationDtoResponse = frontendApplicationService.updateFrontendApplication(frontendApplicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(frontendApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteFrontendApplication (String sid) throws Exception
    {
        frontendApplicationService.deleteFrontendApplication(sid);

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

    @PutMapping("/changePassOrNot")
    public ResponseEntity<String> changeFrontendApplicationPassOrNot(
            String sid) throws Exception
    {
        frontendApplicationService.changePossOrNot(sid);
        //LOGGER.info("change backend application pass or not 호출");

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }

}
