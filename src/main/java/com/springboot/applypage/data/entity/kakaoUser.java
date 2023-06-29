package com.springboot.applypage.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="kakao_user")
public class kakaoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kid;

    @Column(nullable = false, unique = true)
    private String kakaoEmail;

}
