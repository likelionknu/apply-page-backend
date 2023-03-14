package com.springboot.applypage.data.dto;

import com.springboot.applypage.data.enumdata.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long sid;

    private String email;

    private String name;

    private LocalDate birthDay;

    private Role role;

    private String tel;

    private String password;

}
