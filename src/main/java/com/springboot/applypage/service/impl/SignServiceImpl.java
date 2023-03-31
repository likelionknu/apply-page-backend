package com.springboot.applypage.service.impl;

import com.springboot.applypage.common.CommonResponse;
import com.springboot.applypage.config.security.JwtTokenProvider;
import com.springboot.applypage.data.dto.SignInResultDto;
import com.springboot.applypage.data.dto.SignUpResultDto;
import com.springboot.applypage.data.dto.UpdateInResultDto;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.repository.UserRepository;
import com.springboot.applypage.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

@Service
public class SignServiceImpl implements SignService {

    private final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(
            UserRepository   userRepository,
            JwtTokenProvider jwtTokenProvider,
            PasswordEncoder  passwordEncoder
    ){
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;

    };

    @Override
    public SignUpResultDto signUp(
            String id,
            String password,
            String name,
            String role,
            Long sid,
            LocalDate birthDay,
            String tel
    ) {
        LOGGER.info("[getSignUpResult] 회원가입정보 전달");
        User user;

        user = User.builder()
                .email(id)
                .name(name)
                .sid(sid)
                .passwd(passwordEncoder.encode(password))
                .roles(Collections.singletonList(role))
                .birthDay(birthDay)
                .tel(tel)
                .build();

        User savedUser = userRepository.save(user);
        SignUpResultDto signUpResultDto = new SignInResultDto();

        LOGGER.info("[getSignUpResult] userEntity 값이 들어왔는지 확인 후 결과값 주입");
        if(!savedUser.getName().isEmpty()){
            LOGGER.info("[getSignUpResult] 정상 처리 완료");
            setSuccessResult(signUpResultDto);
        }else{
            LOGGER.info("[getSignUpResult] 실패 처리 완료");
            setFailResult(signUpResultDto);
        }
        return signUpResultDto;
    }

    @Override
    public SignInResultDto signIn(String id, String passwd) throws RuntimeException {
        LOGGER.info("[getSignInResult] signDataHandler 로 회원 정보 요청");
        User user = userRepository.getByEmail(id);
        LOGGER.info("[getSignInResult] Id : {}", id);

        LOGGER.info("[getSignInResult] 패스워드 비교 수행");
        if(!passwordEncoder.matches(passwd, user.getPasswd())){
            throw new RuntimeException();
        }
        LOGGER.info("[getSignInResult] 패스워드 일치");

        LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");
        SignInResultDto signInResultDto = SignInResultDto.builder()
                .token(jwtTokenProvider.createToken(String.valueOf(user.getEmail())
                ,user.getRoles()))
                .build();

        LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입");
        setSuccessResult(signInResultDto);

        return signInResultDto;
    }

    @Override
    public UpdateInResultDto updatePassword(String passwd, String newPasswd, String token) throws RuntimeException {
        //jwtTokenProvider.getUsername()
        //passwordEncoder.

        User user = userRepository.getByEmail(jwtTokenProvider.getUsername(token));

        System.out.println("토큰에서 값 추출" + user.toString());

        if(!passwordEncoder.matches(passwd, user.getPassword())){
            throw new RuntimeException();
        }

        User newUser = User.builder()
                .email(user.getEmail())
                .name(user.getName())
                .sid(user.getSid())
                .passwd(passwordEncoder.encode(newPasswd))
                .roles(user.getRoles())
                .birthDay(user.getBirthDay())
                .tel(user.getTel())
                .build();
        newUser.setCreatedAt(user.getCreatedAt());

        userRepository.save(newUser);

        UpdateInResultDto updateInResultDto = new UpdateInResultDto();
        setSuccessResult(updateInResultDto);

        return updateInResultDto;
    }

    private void setSuccessResult(SignUpResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    private void setFailResult(SignUpResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }

    private void setSuccessResult(UpdateInResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    private void setFailResult(UpdateInResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }
}
