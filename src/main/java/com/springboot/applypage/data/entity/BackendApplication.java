package com.springboot.applypage.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="backendApplication")
public class BackendApplication extends BaseApplication {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String sid;

    //개발 관련 공부를 하며 개인적으로 힘들었던 경험과 그걸 극복했던 자신만의 방법이 있나요?
    @Column(length = 1000)
    private String difficultAndOvercoming;

    //웹 백앤드 프레임워크를 공부해보신적 있으신가요? 있으시다면 어디까지 공부해보셨나요?
    @Column(length = 1000)
    private String studyFramework;

    //단체생활에서 가장 중요하다고 생각하는 것은 무엇인가요?
    @Column(length = 1000)
    private String importantGroup;
}
