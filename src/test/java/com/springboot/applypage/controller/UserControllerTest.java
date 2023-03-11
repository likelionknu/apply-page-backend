package com.springboot.applypage.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springboot.applypage.config.LocalDateTimeSerializer;
import com.springboot.applypage.data.dto.UserDto;
import com.springboot.applypage.data.enumdata.Role;
import com.springboot.applypage.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)       //UserController 클래스 만을 가지고 온다
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean                           //가짜 객체를 주입받는다.
    UserServiceImpl userService;

    @Test
    @DisplayName("UserController getUser method Test")
    void getUserTest() throws Exception{
        given(userService.getUser(201904055L)).willReturn(
                new UserDto(201904055L
                        , "scg9268@kangnam.ac.kr"
                        , "성창규"
                        , LocalDate.of(2020, Month.JANUARY, 8)
                        , Role.ROOT)
        );

        String sid = "201904055";

        mockMvc.perform(
                get("/user?sid=" + sid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sid").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.birthDay").exists())
                .andExpect(jsonPath("$.role").exists())
                .andDo(print());

        verify(userService).getUser(201904055L);
    }

    @Test
    @DisplayName("UserController createUser method Test")
    void createUserTest() throws Exception{
        given(userService.saveUser(new UserDto(201904055L
                , "scg9268@kangnam.ac.kr"
                , "성창규"
                , LocalDate.of(2020, Month.JANUARY, 8)
                , Role.ROOT)))
                .willReturn(new UserDto(201904055L
                        , "scg9268@kangnam.ac.kr"
                        , "성창규"
                        , LocalDate.of(2020, Month.JANUARY, 8)
                        , Role.ROOT));

        UserDto userDto = UserDto.builder()
                .sid(201904055L)
                .email("scg9268@kangnam.ac.kr")
                .name("성창규")
                .birthDay(LocalDate.of(2020, Month.JANUARY, 8))
                .role(Role.ROOT)
                .build();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateTimeSerializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String content = gson.toJson(userDto);

        mockMvc.perform(
                post("/user")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sid").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.birthDay").exists())
                .andExpect(jsonPath("$.role").exists())
                .andDo(print());

        verify(userService).saveUser(new UserDto(201904055L
                , "scg9268@kangnam.ac.kr"
                , "성창규"
                , LocalDate.of(2020, Month.JANUARY, 8)
                , Role.ROOT));
    }
}
