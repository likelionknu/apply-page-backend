package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.SignInResultDto;
import com.springboot.applypage.data.dto.SignUpResultDto;
import com.springboot.applypage.data.dto.UpdateInResultDto;

import java.time.LocalDate;
import java.util.Date;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String role, Long sid, LocalDate birthDay, String tel);
    SignInResultDto signIn(String id, String passwd) throws RuntimeException;
    UpdateInResultDto updatePassword(String passwd, String newPasswd, String token) throws RuntimeException;
}
