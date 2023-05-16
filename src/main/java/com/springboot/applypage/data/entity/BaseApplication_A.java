package com.springboot.applypage.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="answer")
public class BaseApplication_A{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Q_id", referencedColumnName = "Q_id")
    private BaseApplication_Q Q_id;

    /*sid가 아니라 User로 매핑 했어야 했음 ㅠㅠ*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sid", referencedColumnName = "sid")
    private User user;

    @Column(nullable = false)
    private String answer_str;


}
