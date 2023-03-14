package com.springboot.applypage.data.dto;

import com.springboot.applypage.data.enumdata.Role;

public class ChangeUserDto {

    private Long sid;
    private Role role;
    private String tel;
    private String password;

    public ChangeUserDto(Long sid, Role role,String tel, String password){
        this.sid = sid;
        this.role = role;
        this.tel = tel;
        this.password = password;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
