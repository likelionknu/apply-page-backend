package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.BaseApplication_ADAO;
import com.springboot.applypage.data.dao.BaseApplication_QDAO;
import com.springboot.applypage.data.dto.BaseApplication_ADto;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.entity.BaseApplication_A;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.service.BaseApplication_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseApplication_AServiceImpl implements BaseApplication_AService {

    private final BaseApplication_ADAO baseApplication_ADAO;
    @Autowired
    public BaseApplication_AServiceImpl(BaseApplication_ADAO baseApplication_ADAO){
        this.baseApplication_ADAO = baseApplication_ADAO;
    }
    @Override
    public BaseApplication_ADto getBaseApplication_AService(Long Q_id) {
        BaseApplication_A baseApplication_A = baseApplication_ADAO.selectBaseApplication_A(Q_id);
        BaseApplication_ADto baseApplication_AResponse = new BaseApplication_ADto();

        baseApplication_AResponse.setId(baseApplication_A.getId());
        baseApplication_AResponse.setQ_id(baseApplication_A.getQ_id());
        baseApplication_AResponse.setSid(baseApplication_A.getSid());
        baseApplication_AResponse.setAnswer_str(baseApplication_A.getAnswer_str());

        return baseApplication_AResponse;
    }

    @Override
    public BaseApplication_ADto saveBaseApplication_AService(BaseApplication_ADto baseApplication_ADto) {
        BaseApplication_A baseApplication_A = new BaseApplication_A();

        baseApplication_A.setId(baseApplication_ADto.getId());
        baseApplication_A.setQ_id(baseApplication_ADto.getQ_id());
        baseApplication_A.setSid(baseApplication_ADto.getSid());
        baseApplication_A.setAnswer_str(baseApplication_ADto.getAnswer_str());

        BaseApplication_A savedBaseApplication_A = baseApplication_ADAO.insertBaseApplication_A(baseApplication_A);
        BaseApplication_ADto baseApplication_AResponse = new BaseApplication_ADto();

        baseApplication_AResponse.setId(baseApplication_A.getId());
        baseApplication_AResponse.setQ_id(baseApplication_A.getQ_id());
        baseApplication_AResponse.setSid(baseApplication_A.getSid());
        baseApplication_AResponse.setAnswer_str(baseApplication_A.getAnswer_str());

        return baseApplication_AResponse;
    }

    @Override
    public BaseApplication_ADto updateBaseApplication_A(BaseApplication_ADto baseApplication_ADto) throws Exception {
        BaseApplication_A baseApplication_A = new BaseApplication_A();

        baseApplication_A.setId(baseApplication_ADto.getId());
        baseApplication_A.setQ_id(baseApplication_ADto.getQ_id());
        baseApplication_A.setSid(baseApplication_ADto.getSid());
        baseApplication_A.setAnswer_str(baseApplication_ADto.getAnswer_str());

        BaseApplication_A updateBaseApplication_A = baseApplication_ADAO.updateBaseApplication_A(baseApplication_A);
        BaseApplication_ADto updateBaseApplication_ADto = new BaseApplication_ADto();

        updateBaseApplication_ADto.setId(updateBaseApplication_A.getId());
        updateBaseApplication_ADto.setQ_id(updateBaseApplication_A.getQ_id());
        updateBaseApplication_ADto.setSid(updateBaseApplication_A.getSid());
        updateBaseApplication_ADto.setAnswer_str(updateBaseApplication_A.getAnswer_str());

        return updateBaseApplication_ADto;
    }

    @Override
    public void deleteBaseApplication_A(Long id) throws Exception {
        baseApplication_ADAO.deleteBaseApplication_A(id);
    }

    @Override
    public List<BaseApplication_A> getAllApplications() {
        return baseApplication_ADAO.getAllApplication();
    }
}
