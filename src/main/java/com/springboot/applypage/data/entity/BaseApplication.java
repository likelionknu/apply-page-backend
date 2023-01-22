package com.springboot.applypage.data.entity;

import com.springboot.applypage.data.dto.FileDto;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseApplication {

    private String name;
    private String email;
    private String phoneNumber;

    private String portfolioFile;
    private String portfolioLink;
    private String department;

    //합격여부
    @ColumnDefault("false")
    private Boolean passOrNot;

    //제출 상태
    @ColumnDefault("false")
    private Boolean submissionStatus;

    //인생의 최종 목표는 무엇인가요?
    @Column(length = 1000)
    private String motive;

    //학교 공부 제외 가장 열심히 했던 활동은 무엇인가요?
    @Column(length = 1000)
    private String hardWork;

    //자신을 설명할 수 있는 키워드 3개를 쓰고, 그 이유에 대하여 설명해주세요
    @Column(length = 1000)
    private String keyWord;

    //최근에 가장 감명 깊게 읽은 책, 본 영화, 들은 놀래가 있나요? 하나를 선택해주시고 그 이유에 대하여 설명해주세요.
    @Column(length = 1000)
    private String mostDeeplyWork;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
