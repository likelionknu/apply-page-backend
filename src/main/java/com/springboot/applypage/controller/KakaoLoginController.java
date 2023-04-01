package com.springboot.applypage.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class KakaoLoginController {
    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code){

        //HttpHeader오브젝트 생성 : post방식으로 key=value 형태의 데이터를 요청(카카오쪽으로)
        RestTemplate rt = new RestTemplate();
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpBody 오브젝트 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","6d10a0681f57ecd066757f954130a147");
        params.add("redirect_uri","https://localhost:443/auth/kakao/callback");
        params.add("code",code);

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        //body값과 header값을 갖고있는 엔티티가 됨
        //exchange가 HttpEntity를 넣어야함
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        //실제로 요청 - post방식 - response변수의 응답을 받음
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
                );
        return "카카오 인증 완료 : 토큰요청에 대한 응답" + response.getBody();
    }
}
