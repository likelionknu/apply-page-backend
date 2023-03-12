package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.UserDAO;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.enumdata.Role;
import com.springboot.applypage.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;
    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User insertUser(User user) {

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @Override
    public User selectUser(Long sid) {
        User selectedUser = userRepository.getById(sid);
        return selectedUser;
    }
    @Override
    public User updateUser(Long sid, Role role)throws Exception{
        Optional<User> selectedUser = userRepository.findById(sid);

        User updatedUser;
        if(selectedUser.isPresent()){
            User user = selectedUser.get();

            user.setRole(role);
            user.setUpdatedAt(LocalDateTime.now());

            updatedUser = userRepository.save(user);
        }else {
            throw new Exception();
        }
        return updatedUser;

    }

    @Override
    public void deleteUser(Long sid) throws Exception {
        Optional<User> selectedUser = userRepository.findById(sid);

        if(selectedUser.isPresent()){
            User user = selectedUser.get();
            userRepository.delete(user);
        }else{
            throw new Exception();
        }
    }
}
