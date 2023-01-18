package com.springboot.applypage.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="frontApplication")
public class FrontendApplication extends BaseApplication{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sid;

    //프론트엔드 트랙을 선택하게 된 이유를 구체적으로 서술해주세요
    @Column(length = 1000)
    private String whyFrontend;

    //프론트엔드 개발과 관련된 프레임워크나 html, css, js 등의 언어를 사용해 보신 적 있으신가요?
    @Column(length = 1000)
    private String usingStack;

    //팀 활동이나 프로젝트를 진행해 보신 적이 있나요? 있으시다면 어떤 활동 이였는지 구체적으로 적어주세요, 그리고 그 활동을 통해 자신이 성장 경험에 대해서 서술해주세요.
    @Column(length = 1000)
    private String teamProject;

    //멋사 프론트엔드 아기사자로 활동하면서 얻어 가고 싶은 것은 무엇인가요?
    @Column(length = 1000)
    private String achieve;


}
