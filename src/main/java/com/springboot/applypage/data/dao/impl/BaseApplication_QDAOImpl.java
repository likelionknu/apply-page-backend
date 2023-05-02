package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.BaseApplication_ADAO;
import com.springboot.applypage.data.dao.BaseApplication_QDAO;
import com.springboot.applypage.data.entity.BaseApplication_A;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.entity.ChangeHistory;
import com.springboot.applypage.data.repository.BaseApplication_ARepository;
import com.springboot.applypage.data.repository.BaseApplication_QRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BaseApplication_QDAOImpl implements BaseApplication_QDAO {
    private final BaseApplication_QRepository baseApplication_QRepository;
    @Autowired
    public BaseApplication_QDAOImpl(BaseApplication_QRepository baseApplication_QRepository){
        this.baseApplication_QRepository = baseApplication_QRepository;
    }

    @Override
    public BaseApplication_Q insertBaseApplication_Q(BaseApplication_Q baseApplication_Q) {
        BaseApplication_Q savedBaseApplication_Q = baseApplication_QRepository.save(baseApplication_Q);
        return savedBaseApplication_Q;
    }

    @Override
    public BaseApplication_Q selectBaseApplication_Q(Long Q_id){
        BaseApplication_Q selectedBaseApplication_Q;
        if(baseApplication_QRepository.existsById(Q_id)){
            selectedBaseApplication_Q = baseApplication_QRepository.getById(Q_id);
        }else{
            selectedBaseApplication_Q = new BaseApplication_Q();
        }
        return selectedBaseApplication_Q;

    }


    @Override
    public BaseApplication_Q updateBaseApplication_Q(BaseApplication_Q baseApplication_Q) throws Exception{

        Optional<BaseApplication_Q> selectBaseApplication_Q
                = baseApplication_QRepository.findById(baseApplication_Q.getQ_id());
        BaseApplication_Q updateBaseApplication_Q;

        if(selectBaseApplication_Q.isPresent()){
            BaseApplication_Q newBaseApplication_Q = selectBaseApplication_Q.get();

            newBaseApplication_Q.setPart(baseApplication_Q.getPart());
            newBaseApplication_Q.setQ_id(baseApplication_Q.getQ_id());
            newBaseApplication_Q.setQuestion_str(baseApplication_Q.getQuestion_str());

            updateBaseApplication_Q = baseApplication_QRepository.save(newBaseApplication_Q);
        }else{
            throw new Exception();
        }
        return updateBaseApplication_Q;
    }

    @Override
    public void deleteBaseApplication_Q(Long Q_id) throws Exception {
        Optional<BaseApplication_Q> selectedBaseApplication_Q = baseApplication_QRepository.findById(Q_id);
        if(selectedBaseApplication_Q.isPresent()){
            BaseApplication_Q baseApplication_Q = selectedBaseApplication_Q.get();
            baseApplication_QRepository.delete(baseApplication_Q);
        }else{
            throw new Exception();
        }

    }


    @Override
    public List<BaseApplication_Q> getAllApplication() {
        return baseApplication_QRepository.findAll();
    }

}


