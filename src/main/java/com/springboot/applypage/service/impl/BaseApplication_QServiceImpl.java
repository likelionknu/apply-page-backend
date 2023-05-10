package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.BackendApplicationDAO;
import com.springboot.applypage.data.dao.BaseApplication_QDAO;
import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.service.BaseApplication_QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseApplication_QServiceImpl implements BaseApplication_QService {
    private final BaseApplication_QDAO baseApplication_QDAO;
    @Autowired
    public BaseApplication_QServiceImpl(BaseApplication_QDAO baseApplication_QDAO){
        this.baseApplication_QDAO = baseApplication_QDAO;
    }

    @Override
    public BaseApplication_QDto getBaseApplication_Q(Long Q_id){

        BaseApplication_Q baseApplication_Q = baseApplication_QDAO.selectBaseApplication_Q(Q_id);
        BaseApplication_QDto baseApplication_QResponse = new BaseApplication_QDto();

        baseApplication_QResponse.setQ_id(baseApplication_Q.getQ_id());
        baseApplication_QResponse.setPart(baseApplication_Q.getPart());
        baseApplication_QResponse.setQuestion_str(baseApplication_Q.getQuestion_str());

        return baseApplication_QResponse;
    }

    @Override
    public BaseApplication_QDto saveBaseApplication_Q(BaseApplication_QDto baseApplication_QDto) {
        BaseApplication_Q baseApplication_Q = new BaseApplication_Q();

        baseApplication_Q.setQ_id(baseApplication_QDto.getQ_id());
        baseApplication_Q.setPart(baseApplication_QDto.getPart());
        baseApplication_Q.setQuestion_str(baseApplication_QDto.getQuestion_str());

        BaseApplication_Q savedBaseApplication_Q = baseApplication_QDAO.insertBaseApplication_Q(baseApplication_Q);
        BaseApplication_QDto baseApplication_QResponse = new BaseApplication_QDto();

        baseApplication_QResponse.setQ_id(savedBaseApplication_Q.getQ_id());
        baseApplication_QResponse.setPart(savedBaseApplication_Q.getPart());
        baseApplication_QResponse.setQuestion_str(savedBaseApplication_Q.getQuestion_str());


        return baseApplication_QResponse;
    }

    @Override
    public BaseApplication_QDto updateBaseApplication_Q(BaseApplication_QDto baseApplication_QDto) throws Exception {

        BaseApplication_Q baseApplication_Q = new BaseApplication_Q();

        baseApplication_Q.setQ_id(baseApplication_QDto.getQ_id());
        baseApplication_Q.setPart(baseApplication_QDto.getPart());
        baseApplication_Q.setQuestion_str(baseApplication_QDto.getQuestion_str());

        BaseApplication_Q updateBaseApplication_Q = baseApplication_QDAO.updateBaseApplication_Q(baseApplication_Q);
        BaseApplication_QDto updateBaseApplication_QDto = new BaseApplication_QDto();

        updateBaseApplication_QDto.setQ_id(updateBaseApplication_Q.getQ_id());
        updateBaseApplication_QDto.setPart(updateBaseApplication_Q.getPart());
        updateBaseApplication_QDto.setQuestion_str(updateBaseApplication_Q.getQuestion_str());

        return updateBaseApplication_QDto;
    }

    @Override
    public void deleteBaseApplication_Q(Long Q_id) throws Exception {

        baseApplication_QDAO.deleteBaseApplication_Q(Q_id);

    }

    @Override
    public List<BaseApplication_Q> getAllApplications() {
        return baseApplication_QDAO.getAllApplications();
    }

}
