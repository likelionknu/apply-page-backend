package com.springboot.applypage.data.dto;

import lombok.Data;

@Data
public class BaseApplicationDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String motive;
    private String portfolioFile;
    private String portfolioLink;
}
