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

    @Column(nullable = false)
    @JoinColumn(name="sid")
    private Long sid;

    @Column(nullable = false)
    private String answer_str;


}
