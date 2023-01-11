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
}
