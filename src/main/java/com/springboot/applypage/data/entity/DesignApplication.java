package com.springboot.applypage.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="designApplication")
public class DesignApplication extends BaseApplication {
    @Id
    private String sid;

    //디자인 파트를 선택한 이유가 무엇인가요? 최대한 구체적으로 서술해주세요.
    @Column(length = 1000)
    private String whyDesign;

    //피그마나 AdobeXD와 같은 목업 툴에 관련된 경험을 해본적이 있나요? 있다면 그 경험에 대해 자세히 설명을 해주세요.
    @Column(length = 1000)
    private String toolExperience;

    //본인이 협업과 팀워크를 진행해 보았던 경험과, 그 경험을 멋쟁이 사자처럼 대학에서 어떻게 적용시킬 수 있는지 알려주세요!
    @Column(length = 1000)
    private String teamworkExperience;

    //디자인파트를 통해 어떠한 성장을 희망하시는지 구체적으로 서술해주세요!
    @Column(length = 1000)
    private String designGrowth;


}
