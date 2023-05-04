package com.springboot.applypage.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="question")
public class BaseApplication_Q {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(columnDefinition = "Long default 0")
    private Long Q_id;
    @Column
    private String part;

    @Column(nullable = false)
    private String Question_str;

}
