package com.springboot.applypage.controller;

import com.springboot.applypage.service.OAuthService;
import com.springboot.applypage.service.impl.OAuthServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/oauth")
public class OAuthController {

    /**
     * 카카오 callback
     * [GET] /oauth/kakao/callback
     */
    @Autowired
    private OAuthServiceImpl oauth;
    @ResponseBody
    @GetMapping("/kakao")
    public void kakaoCallback(@RequestParam String code) {
        System.out.println("인가코드: "+code);
        String access_token = oauth.getKakaoAccessToken(code);
        System.out.println("controller access_token : "+access_token);


    }
}