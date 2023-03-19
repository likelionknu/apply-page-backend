package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.SignInResultDto;
import com.springboot.applypage.data.dto.SignUpResultDto;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String role, Long sid);
    SignInResultDto signIn(String id, String passwd) throws RuntimeException;
}
