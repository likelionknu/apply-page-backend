package com.springboot.applypage.data.entity;

import com.springboot.applypage.data.enumdata.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User extends BaseEntity{

    //전화번호
    //비밀번호 - 암호화

    @Id
    private Long sid;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDay;

    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
   // @ColumnDefault("BABY")
    private Role role;
}