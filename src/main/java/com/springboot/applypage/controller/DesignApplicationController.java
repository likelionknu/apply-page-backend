package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.service.DesignApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/designApplication")
public class DesignApplicationController {
    private final DesignApplicationService designApplicationService;

    @Autowired
    public DesignApplicationController(DesignApplicationService designApplicationService){
        this.designApplicationService = designApplicationService;
    }

    @PostMapping()
    public ResponseEntity<DesignApplicationDto> createDesignApplication(
            @RequestBody DesignApplicationDto DesignApplicationDto)
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.saveDesignApplication(DesignApplicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<DesignApplicationDto> getDesignApplication(String sid)
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.getDesignApplication(sid);

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<DesignApplicationDto> updateDesignApplication(
            @RequestBody  DesignApplicationDto designApplicationDto) throws Exception
    {
        DesignApplicationDto designApplicationDtoResponse = designApplicationService.updateDesignApplication(designApplicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDesignApplication (String sid) throws Exception
    {
        designApplicationService.deleteDesignApplication(sid);

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }

    @PutMapping("/changePassOrNot")
    public ResponseEntity<String> changeDesignApplicationPassOrNot(
            String sid) throws Exception
    {
        designApplicationService.changePossOrNot(sid);
        //LOGGER.info("change backend application pass or not 호출");

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 변경 되었습니다.");
    }

    @GetMapping("/getApplications")
    public ResponseEntity<List<DesignApplication>> getDesignApplicationWithBoolean(Boolean bool)
    {
        List<DesignApplication> designApplicationResponse = designApplicationService.getReturn(bool);

        //LOGGER.info("get design application with boolean 호출");

        return ResponseEntity.status(HttpStatus.OK).body(designApplicationResponse);
    }
}
