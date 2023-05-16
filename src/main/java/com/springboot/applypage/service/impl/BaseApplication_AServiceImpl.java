package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.BaseApplication_ADAO;
import com.springboot.applypage.data.dao.BaseApplication_QDAO;
import com.springboot.applypage.data.dto.BaseApplication_ADto;
import com.springboot.applypage.data.dto.BaseApplication_AnsDto;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.entity.BaseApplication_A;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.repository.UserRepository;
import com.springboot.applypage.service.BaseApplication_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseApplication_AServiceImpl implements BaseApplication_AService {

    private final BaseApplication_ADAO baseApplication_ADAO;
    private final BaseApplication_QDAO baseApplication_QDAO;
    private final UserRepository userRepository;

    @Autowired
    public BaseApplication_AServiceImpl(
            BaseApplication_ADAO baseApplication_ADAO
            , BaseApplication_QDAO baseApplication_QDAO
            , UserRepository userRepository){
        this.baseApplication_ADAO = baseApplication_ADAO;
        this.baseApplication_QDAO = baseApplication_QDAO;
        this.userRepository = userRepository;
    }
    @Override
    public BaseApplication_ADto getBaseApplication_A(Long Q_id) {
        BaseApplication_A baseApplication_A = baseApplication_ADAO.selectBaseApplication_A(Q_id);
        BaseApplication_ADto baseApplication_AResponse = new BaseApplication_ADto();

        baseApplication_AResponse.setId(baseApplication_A.getId());
        baseApplication_AResponse.setQ_id(baseApplication_A.getQ_id());
        //baseApplication_AResponse.setSid(baseApplication_A.getSid());
        baseApplication_AResponse.setAnswer_str(baseApplication_A.getAnswer_str());

        return baseApplication_AResponse;
    }

    @Override
    public BaseApplication_AnsDto saveBaseApplication_Ans(BaseApplication_AnsDto baseApplication_ansDto) {
        BaseApplication_A baseApplication_A = new BaseApplication_A();

        //baseApplication_A.setId(baseApplication_ansDto.getId());
        //baseApplication_A.setSid(baseApplication_ansDto.getSid());
        User user = userRepository.getById(baseApplication_ansDto.getSid());
        BaseApplication_Q baseApplication_q  = baseApplication_QDAO.selectBaseApplication_Q(baseApplication_ansDto.getQ_id());

        baseApplication_A.setUser(user);
        baseApplication_A.setAnswer_str(baseApplication_ansDto.getAnswer_str());
        baseApplication_A.setQ_id(baseApplication_q);

        baseApplication_A = baseApplication_ADAO.insertBaseApplication_A(baseApplication_A);

        BaseApplication_AnsDto newBaseApplication_Ans = new BaseApplication_AnsDto();

        newBaseApplication_Ans.setSid(baseApplication_A.getUser().getSid());
        newBaseApplication_Ans.setAnswer_str(baseApplication_A.getAnswer_str());
        newBaseApplication_Ans.setId(baseApplication_A.getId());
        newBaseApplication_Ans.setQ_id(baseApplication_A.getQ_id().getQ_id());

        return newBaseApplication_Ans;
    }

    @Override
    public BaseApplication_ADto saveBaseApplication_A(BaseApplication_ADto baseApplication_ADto) {
        BaseApplication_A baseApplication_A = new BaseApplication_A();

        baseApplication_A.setId(baseApplication_ADto.getId());
        baseApplication_A.setQ_id(baseApplication_ADto.getQ_id());
        //baseApplication_A.setSid(baseApplication_ADto.getSid());
        baseApplication_A.setAnswer_str(baseApplication_ADto.getAnswer_str());

        BaseApplication_A savedBaseApplication_A = baseApplication_ADAO.insertBaseApplication_A(baseApplication_A);
        BaseApplication_ADto baseApplication_AResponse = new BaseApplication_ADto();

        baseApplication_AResponse.setId(savedBaseApplication_A.getId());
        baseApplication_AResponse.setQ_id(savedBaseApplication_A.getQ_id());
        //baseApplication_AResponse.setSid(savedBaseApplication_A.getSid());
        baseApplication_AResponse.setAnswer_str(savedBaseApplication_A.getAnswer_str());

        return baseApplication_AResponse;
    }

    @Override
    public BaseApplication_ADto updateBaseApplication_A(BaseApplication_ADto baseApplication_ADto) throws Exception {
        BaseApplication_A baseApplication_A = new BaseApplication_A();

        baseApplication_A.setId(baseApplication_ADto.getId());
        baseApplication_A.setQ_id(baseApplication_ADto.getQ_id());
        //baseApplication_A.setSid(baseApplication_ADto.getSid());
        baseApplication_A.setAnswer_str(baseApplication_ADto.getAnswer_str());

        BaseApplication_A updateBaseApplication_A = baseApplication_ADAO.updateBaseApplication_A(baseApplication_A);
        BaseApplication_ADto updateBaseApplication_ADto = new BaseApplication_ADto();

        updateBaseApplication_ADto.setId(updateBaseApplication_A.getId());
        updateBaseApplication_ADto.setQ_id(updateBaseApplication_A.getQ_id());
        //updateBaseApplication_ADto.setSid(updateBaseApplication_A.getSid());
        updateBaseApplication_ADto.setAnswer_str(updateBaseApplication_A.getAnswer_str());

        return updateBaseApplication_ADto;
    }

    @Override
    public void deleteBaseApplication_A(Long id) throws Exception {
        baseApplication_ADAO.deleteBaseApplication_A(id);
    }

    @Override
    public List<BaseApplication_A> getAllApplications() {
        return baseApplication_ADAO.getAllApplications();
    }
}
