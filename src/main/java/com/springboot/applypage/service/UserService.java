package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.UserDto;
import com.springboot.applypage.data.enumdata.Role;

public interface UserService {
    UserDto getUser(Long sid);
    UserDto saveUser(UserDto user);
    UserDto changeUser(Long sid, Role role,String tel, String password) throws Exception;
    void deleteUser(Long sid) throws Exception;
}
