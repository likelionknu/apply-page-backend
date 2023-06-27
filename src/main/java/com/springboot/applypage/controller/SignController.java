package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.SignInResultDto;
import com.springboot.applypage.data.dto.SignUpResultDto;
import com.springboot.applypage.data.dto.UpdateInResultDto;
import com.springboot.applypage.service.SignService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign-api")
public class SignController {

    private final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService){
        this.signService = signService;
    }

    @PostMapping(value = "/sign-in")
    public SignInResultDto signIn(
            @ApiParam(value = "ID", required = true) @RequestParam String id,
            @ApiParam(value = "Password", required = true) @RequestParam String password)
        throws RuntimeException {
        LOGGER.info("[signIn] 로그인을 시도하고 있습니다. id : {}, pw : ****", id);
        SignInResultDto signInResultDto = signService.signIn(id, password);

        if(signInResultDto.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다. id : {}, token : {}", id,
                    signInResultDto.getToken());
        }
        return signInResultDto;

    }

    @PostMapping(value = "/sign-up")
    public SignUpResultDto signUp(
            @ApiParam(value = "ID", required = true, example = "exampleId1234") @RequestParam String id,
            @ApiParam(value = "Password", required = false, example = "1234") @RequestParam String password,
            @ApiParam(value = "이름", required = true, example = "성창규") @RequestParam String name,
            @ApiParam(value = "권한", required = true, example = "ROLE_ADMIN") @RequestParam String role,
            @ApiParam(value = "생일", required = true, example = "2001-05-31") @RequestParam String birthDay,
            @ApiParam(value = "학번", required = true, example = "201904055") @RequestParam Long sid,
            @ApiParam(value = "전화번호", required = true, example = "010-1111-2222") @RequestParam String tel
    ){

        //LocalDate ld = LocalDate.now();
        SignUpResultDto signUpResultDto = signService.signUp(id, password, name, role, sid, LocalDate.parse(birthDay, DateTimeFormatter.ISO_DATE), tel);

        return signUpResultDto;
    }
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 발급 받은 access_token",
                    required = true,
                    dataType = "String",
                    paramType = "header")
    })
    @PostMapping(value = "/update-in")
    public UpdateInResultDto updateIn(
            @ApiParam(value = "Password", required = true, example = "example1234") @RequestParam String password,
            @ApiParam(value = "newPassword", required = true, example = "example1234") @RequestParam String newPassword,
            @RequestHeader(value = "X-AUTH-TOKEN", required = true) String token)
            throws RuntimeException {

        UpdateInResultDto updateInResultDto = signService.updatePassword(password, newPassword, token);

        return updateInResultDto;

    }

    @GetMapping(value = "/exception")
    public void exceptionTest() throws RuntimeException{
        throw new RuntimeException("접근이 금지되었습니다.");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders = new HttpHeaders();

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.error("ExceptionHandler 호출, {} {}", e.getCause(), e.getMessage());

        Map<String, String> map = new HashMap<>();

        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
