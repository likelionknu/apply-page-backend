package com.springboot.applypage.service.impl;

import com.springboot.applypage.config.security.JwtTokenProvider;
import com.springboot.applypage.data.dto.UpdateInResultDto;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.repository.UserRepository;
import com.springboot.applypage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;
    //public PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepository   userRepository,
            JwtTokenProvider jwtTokenProvider
            //PasswordEncoder  passwordEncoder
    ){
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        //this.passwordEncoder = passwordEncoder;

    }

    @Override
    public UpdateInResultDto updateUserRole(String token, String newRole, String userEmail) throws RuntimeException {

        User user = userRepository.getByEmail(userEmail);
        //user.getRoles().get(0) == "ROLE_ADMIN";
        switch (user.getRoles().get(0)){
            case "ROLE_ADMIN" :

                //tocken에서 ROLE 가지고 오기

                break;

            case "ROLE_MANAGE" :
                break;

            case "ROLE_LION" :
                break;

            case "ROLE_APPLY" :
                break;

        }

        return null;
    }
}
