package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.service.BackendApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backendApplication")
public class BackendApplicationController {
    private final BackendApplicationService backendApplicationService;

    @Autowired
    public BackendApplicationController(BackendApplicationService backendApplicationService){
        this.backendApplicationService = backendApplicationService;
    }

    @PostMapping()
    public ResponseEntity<BackendApplicationDto> createBackendApplication(
            @RequestBody BackendApplicationDto backendApplicationDto)
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.saveBackendApplication(backendApplicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @GetMapping()
    public ResponseEntity<BackendApplicationDto> getBackendApplication(String sid)
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.getBackendApplication(sid);

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @PutMapping()
    public ResponseEntity<BackendApplicationDto> updateBackendApplication(
            @RequestBody  BackendApplicationDto backendApplicationDto) throws Exception
    {
        BackendApplicationDto backendApplicationDtoResponse = backendApplicationService.updateBackendApplication(backendApplicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(backendApplicationDtoResponse);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBackendApplication (String sid) throws Exception
    {
        backendApplicationService.deleteBackendApplication(sid);

        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제 되었습니다.");
    }


}
