package com.springboot.applypage.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="backendApplication")
public class BackendApplication extends BaseApplication {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sid;
}
