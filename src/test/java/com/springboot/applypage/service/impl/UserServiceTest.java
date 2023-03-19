package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.UserDAO;
import com.springboot.applypage.data.dao.impl.UserDAOImpl;
import com.springboot.applypage.data.dto.UserDto;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.enumdata.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    private UserDAO userDAO = Mockito.mock(UserDAO.class);
    private UserServiceImpl userService;

/*    @BeforeEach
    public void setUpTest(){
        userService = new UserServiceImpl(userDAO);
    }

    @Test
    void getUserTest(){

        User user = new User();
        user.setSid(201904055L);
        user.setRole(Role.BABY);
        user.setName("성창규");
        user.setBirthDay(LocalDate.of(2000, 01, 25));
        user.setEmail("scg9268@naver.com");

        Mockito.when(userDAO.selectUser(201904055L))
                .thenReturn(user);

        UserDto userDto = userService.getUser(201904055L);

        Assertions.assertEquals(user.getEmail(), userDto.getEmail());
        Assertions.assertEquals(user.getName(), userDto.getName());
        Assertions.assertEquals(user.getRole(), userDto.getRole());
        Assertions.assertEquals(user.getSid(), userDto.getSid());
        Assertions.assertEquals(user.getBirthDay(), userDto.getBirthDay());

        verify(userDAO).selectUser(201904055L);
    }

    @Test
    void saveUserTest(){
        Mockito.when(userDAO.insertUser(any(User.class)))
                .then(returnsFirstArg());

        UserDto userDto = userService.saveUser(
                new UserDto(
                201904055L
                , "scg9268@kangnam.ac.kr"
                , "성창규"
                ,LocalDate.of(2000, 01, 25)
                ,Role.ROOT)
        );

        Assertions.assertEquals(userDto.getBirthDay(),LocalDate.of(2000, 01, 25));
        Assertions.assertEquals(userDto.getEmail(), "scg9268@kangnam.ac.kr");
        Assertions.assertEquals(userDto.getSid(), 201904055L);
        Assertions.assertEquals(userDto.getName(), "성창규");
        Assertions.assertEquals(userDto.getRole(), Role.ROOT);
    }*/
}
