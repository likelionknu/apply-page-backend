package com.springboot.applypage.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data
@Table(name="question")
public class BaseApplication_Q {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Q_id;

    private String part;

    @Column(nullable = false)
    private String Question_str;

}
