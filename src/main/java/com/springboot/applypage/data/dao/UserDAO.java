package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.enumdata.Role;

public interface UserDAO {
    User insertUser(User user);
    User selectUser(Long sid);
    User updateUser(Long sid, Role role) throws Exception;
    void deleteUser(Long sid) throws Exception;
}
