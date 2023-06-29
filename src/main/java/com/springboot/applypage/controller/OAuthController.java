package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.OAuthToken;
import com.springboot.applypage.data.entity.kakaoUser;
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

    private final OAuthService oauthService;
    @ResponseBody
    @GetMapping("/kakao")
    public void kakaoCallback(@RequestParam String code) throws JSONException {
        System.out.println("인가코드: "+code);
        String access_token = oauth.getKakaoAccessToken(code);
        System.out.println("controller access_token : "+access_token);
        oauthService.loginWithAccessToken(access_token);
        kakaoUser kakao_user = oauthService.saveUser(access_token);



    }

//    @GetMapping("/oauth/kakao")
//    public kakaoUser getLogin(@RequestParam("code") String code) {
//
//        // 넘어온 인가 코드를 통해 access_token 발급
//        String access_token = oauthService.getKakaoAccessToken(code);
//
//        //(1)
//        // 발급 받은 accessToken 으로 카카오 회원 정보 DB 저장
//
//
//    }
}