package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.UserDAO;
import com.springboot.applypage.data.dto.UserDto;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.enumdata.Role;
import com.springboot.applypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDto getUser(Long sid) {
        User selectedUser = userDAO.selectUser(sid);

        UserDto responseUser = new UserDto();

        responseUser.setName(selectedUser.getName());
        responseUser.setRole(selectedUser.getRole());
        responseUser.setEmail(selectedUser.getEmail());
        responseUser.setSid(selectedUser.getSid());
        responseUser.setBirthDay(selectedUser.getBirthDay());


        return responseUser;
    }

    @Override
    public UserDto saveUser(UserDto user) {
        //User savedUser = userDAO.insertUser(user);
        User savedUser = new User();
        savedUser.setEmail(user.getEmail());
        savedUser.setBirthDay(user.getBirthDay());
        savedUser.setName(user.getName());
        savedUser.setRole(user.getRole());
        savedUser.setSid(user.getSid());

        savedUser = userDAO.insertUser(savedUser);

        UserDto responseUser = new UserDto();
        responseUser.setRole(savedUser.getRole());
        responseUser.setEmail(savedUser.getEmail());
        responseUser.setSid(savedUser.getSid());
        responseUser.setBirthDay(savedUser.getBirthDay());
        responseUser.setName(savedUser.getName());

        return responseUser;
    }

    @Override
    public UserDto changeUser(Long sid, Role role)throws Exception{
        User changedUser = userDAO.updateUser(sid, role);

        UserDto responseUser = new UserDto();
        responseUser.setRole(changedUser.getRole());
        responseUser.setEmail(changedUser.getEmail());
        responseUser.setSid(changedUser.getSid());
        responseUser.setBirthDay(changedUser.getBirthDay());
        responseUser.setName(changedUser.getName());

        return responseUser;

    }
    @Override
    public void deleteUser(Long sid) throws Exception{
        userDAO.deleteUser(sid);
    }
}
