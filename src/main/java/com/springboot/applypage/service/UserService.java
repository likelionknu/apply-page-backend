package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.UserDto;

public interface UserService {
    UserDto getUser(Long sid);
    UserDto saveUser(UserDto user);
    void deleteUser(Long sid) throws Exception;
}
