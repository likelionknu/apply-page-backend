package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.BaseApplication_ADAO;
import com.springboot.applypage.data.dao.BaseApplication_QDAO;
import com.springboot.applypage.data.entity.BaseApplication_A;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.repository.BaseApplication_ARepository;
import com.springboot.applypage.data.repository.BaseApplication_QRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BaseApplication_ADAOImpl implements BaseApplication_ADAO {
    private final BaseApplication_ARepository baseApplication_ARepository;
    @Autowired
    public BaseApplication_ADAOImpl(BaseApplication_ARepository baseApplication_ARepository){
        this.baseApplication_ARepository = baseApplication_ARepository;
    }

    @Override
    public BaseApplication_A insertBaseApplication_A(BaseApplication_A baseApplication_A) {
        BaseApplication_A savedBaseApplication_A = baseApplication_ARepository.save(baseApplication_A);
        return savedBaseApplication_A;
    }

    @Override
    public BaseApplication_A selectBaseApplication_A(Long id){
        BaseApplication_A selectedBaseApplication_A;
        if(baseApplication_ARepository.existsById(id)){
            selectedBaseApplication_A = baseApplication_ARepository.getById(id);
        }else{
            selectedBaseApplication_A = new BaseApplication_A();
        }
        return selectedBaseApplication_A;

    }


    @Override
    public BaseApplication_A updateBaseApplication_A(BaseApplication_A baseApplication_A) throws Exception{

        Optional<BaseApplication_A> selectBaseApplication_A
                = baseApplication_ARepository.findById(baseApplication_A.getId());
        BaseApplication_A updateBaseApplication_A;

        if(selectBaseApplication_A.isPresent()){
            BaseApplication_A newBaseApplication_A = selectBaseApplication_A.get();

            newBaseApplication_A.setQ_id(baseApplication_A.getQ_id());
            newBaseApplication_A.setId(baseApplication_A.getId());
            newBaseApplication_A.setAnswer_str(baseApplication_A.getAnswer_str());

            updateBaseApplication_A = baseApplication_ARepository.save(newBaseApplication_A);
        }else{
            throw new Exception();
        }
        return updateBaseApplication_A;
    }

    @Override
    public void deleteBaseApplication_A(Long id) throws Exception {
        Optional<BaseApplication_A> selectedBaseApplication_A = baseApplication_ARepository.findById(id);
        if(selectedBaseApplication_A.isPresent()){
            BaseApplication_A baseApplication_A = selectedBaseApplication_A.get();
            baseApplication_ARepository.delete(baseApplication_A);
        }else{
            throw new Exception();
        }

    }


    @Override
    public List<BaseApplication_A> getAllApplications() {
        return baseApplication_ARepository.findAll();
    }

}



