package com.springboot.applypage.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BaseApplication_QDto {
    private Long Q_id;
    private String part;
    private String Question_str;

}
