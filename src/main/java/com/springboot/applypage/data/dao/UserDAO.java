package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.User;

public interface UserDAO {
    User insertUser(User user);
    User selectUser(Long sid);
    void deleteUser(Long sid) throws Exception;
}
