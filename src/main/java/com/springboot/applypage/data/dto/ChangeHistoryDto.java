package com.springboot.applypage.data.dto;

import com.springboot.applypage.data.entity.BaseApplication_A;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ChangeHistoryDto {
    private Long id;
    private Long Q_id;
    private String change_Q;
    private Long sid;
    private LocalDateTime updatedAt; //BaseEntity 상속을 받아야 하나,,

}
