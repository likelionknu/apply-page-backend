package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.dto.ChangeHistoryDto;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.entity.ChangeHistory;

import java.util.List;

public interface BaseApplication_QService {
    BaseApplication_QDto getBaseApplication_Q(Long Q_id);
    BaseApplication_QDto saveBaseApplication_Q(BaseApplication_QDto baseApplication_QDto);
    BaseApplication_QDto updateBaseApplication_Q(BaseApplication_QDto baseApplication_QDto)
            throws Exception;
    void deleteBaseApplication_Q(Long Q_id) throws Exception;
    List<BaseApplication_Q> getAllApplications();
}
