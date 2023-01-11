package com.springboot.applypage.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="designApplication")
public class DesignApplication extends BaseApplication {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sid;
}
