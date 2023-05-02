package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.BaseApplication;
import com.springboot.applypage.data.entity.BaseApplication_Q;

import java.util.List;

public interface BaseApplication_QDAO {
    BaseApplication_Q insertBaseApplication_Q(BaseApplication_Q baseApplication_Q);
    BaseApplication_Q selectBaseApplication_Q(Long Q_id);
    BaseApplication_Q updateBaseApplication_Q(BaseApplication_Q baseApplication_Q) throws Exception;
    void deleteBaseApplication_Q(Long Q_id) throws Exception;
    List<BaseApplication_Q> getAllApplication();

    //파트별 질문으로 넘어가는 메소드 구현 필요?
}


