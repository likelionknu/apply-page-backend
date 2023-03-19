package com.springboot.applypage.data.dto;

import com.springboot.applypage.data.enumdata.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long sid;

    private String email;

    private String passwd;

    private String name;

    private LocalDate birthDay;

    private Role role;

}
