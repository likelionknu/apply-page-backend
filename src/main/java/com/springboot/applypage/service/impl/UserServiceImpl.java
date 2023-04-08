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

        //user -> 바뀌어야하는 사람
        //manager -> 바꾸는 사람

        User user = userRepository.getByEmail(userEmail);
        User manager = userRepository.getByEmail(jwtTokenProvider.getUsername(token));
        UpdateInResultDto updateInResultDto = new UpdateInResultDto();

        String userRole = user.getRoles().get(0);
        String managerRole = manager.getRoles().get(0);

        switch (managerRole){

            case "ROLE_ROOT" :

                if(!(
                        userRole.equals("ROLE_LION") ||
                        userRole.equals("ROLE_APPLY") ||
                        userRole.equals("ROLE_MANAGE") ||
                        userRole.equals("ROLE_ADMIN")
                )){
                    updateInResultDto.setMsg("권한 실패");
                }
                updateInResultDto.setMsg("권한 성공");

                break;

            case "ROLE_ADMIN" :

                if(!(userRole.equals("ROLE_LION")|| userRole.equals("ROLE_APPLY") || userRole.equals("ROLE_MANAGE"))){
                    updateInResultDto.setMsg("권한 실패");
                }
                updateInResultDto.setMsg("권한 성공");

                break;

            case "ROLE_MANAGE" :
                if(!(userRole.equals("ROLE_LION") || userRole.equals("ROLE_APPLY"))){
                    updateInResultDto.setMsg("권한 실패");
                }
                updateInResultDto.setMsg("권한 성공");
                break;

            case "ROLE_LION" :

            case "ROLE_APPLY" :
                updateInResultDto.setMsg("권한 성공");
                break;
        }

        return null;
    }
}
