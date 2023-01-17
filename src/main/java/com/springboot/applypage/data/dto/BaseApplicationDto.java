package com.springboot.applypage.data.dto;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;

@Data
public class BaseApplicationDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String portfolioFile;
    private String portfolioLink;

    private String department;

    private Boolean passOrNot;

    //인생의 최종 목표는 무엇인가요?
    private String motive;

    //학교 공부 제외 가장 열심히 했던 활동은 무엇인가요?
    private String hardWork;

    //자신을 설명할 수 있는 키워드 3개를 쓰고, 그 이유에 대하여 설명해주세요
    private String keyWord;

    //최근에 가장 감명 깊게 읽은 책, 본 영화, 들은 놀래가 있나요? 하나를 선택해주시고 그 이유에 대하여 설명해주세요.
    private String mostDeeplyWork;
}
