package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.BaseApplication_ADto;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.entity.BaseApplication_A;
import com.springboot.applypage.data.entity.BaseApplication_Q;

import java.util.List;

public interface BaseApplication_AService {
    BaseApplication_ADto getBaseApplication_A(Long Q_id);
    BaseApplication_ADto saveBaseApplication_A(BaseApplication_ADto baseApplication_ADto);
    BaseApplication_ADto updateBaseApplication_A(BaseApplication_ADto baseApplication_ADto)
            throws Exception;
    void deleteBaseApplication_A(Long Q_id) throws Exception;
    List<BaseApplication_A> getAllApplications();
}
