package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.BaseApplication_A;

import java.util.List;

public interface BaseApplication_ADAO {
    BaseApplication_A insertBaseApplication_A(BaseApplication_A baseApplication_A);
    BaseApplication_A selectBaseApplication_A(Long id);
    BaseApplication_A updateBaseApplication_A(BaseApplication_A baseApplication_A) throws Exception;
    void deleteBaseApplication_A(Long id) throws Exception;
    List<BaseApplication_A> getAllApplications();

    //파트별 질문으로 넘어가는 메소드 구현 필요?
}



