package com.springboot.applypage.data.dto;

import com.springboot.applypage.data.enumdata.Role;

public class ChangeUserDto {

    private Long sid;
    private Role role;

    public ChangeUserDto(Long sid, Role role){
        this.sid = sid;
        this.role = role;
    }

    public ChangeUserDto(){}

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
