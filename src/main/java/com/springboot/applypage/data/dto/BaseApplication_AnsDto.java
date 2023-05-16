package com.springboot.applypage.data.dto;

import com.springboot.applypage.data.entity.BaseApplication_Q;
import lombok.Data;

@Data
public class BaseApplication_AnsDto {
    private Long id;
    private Long Q_id;
    private Long sid;
    private String answer_str;

}
