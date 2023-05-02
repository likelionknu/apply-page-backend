package com.springboot.applypage.data.dto;

import lombok.Data;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BaseApplication_ADto {
    private Long id;
    private BaseApplication_Q Q_id;
    private Long sid;
    private String answer_str;

}
