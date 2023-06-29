package com.springboot.applypage.service;

import com.springboot.applypage.data.entity.kakaoUser;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public interface OAuthService {
    String getKakaoAccessToken(String code);

    void loginWithAccessToken(String access_token) throws JSONException;
    kakaoUser saveUser(String access_token);


}