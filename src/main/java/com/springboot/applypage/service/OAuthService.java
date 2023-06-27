package com.springboot.applypage.service;

import org.springframework.stereotype.Service;

@Service
public interface OAuthService {
    String getKakaoAccessToken(String code);

    //void loginWithAccessToken(String token) throws JSONException;



}