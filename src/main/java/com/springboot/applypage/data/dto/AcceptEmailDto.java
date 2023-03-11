package com.springboot.applypage.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class AcceptEmailDto {
    String email;
    String name;
    String interviewDate;
    String interviewLocation;
    String interviewTime;
}
