package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.ChangeHistoryDAO;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.ChangeHistory;
import com.springboot.applypage.data.repository.BackendApplicationRepository;
import com.springboot.applypage.data.repository.ChangeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ChangeHistoryDAOImpl implements ChangeHistoryDAO {
    private final ChangeHistoryRepository changeHistoryRepository;
    @Autowired
    public ChangeHistoryDAOImpl(ChangeHistoryRepository changeHistoryRepository){
        this.changeHistoryRepository = changeHistoryRepository;
    }

    @Override
    public ChangeHistory insertChangeHistory(ChangeHistory changeHistory) {
        ChangeHistory savedChangeHistory = changeHistoryRepository.save(changeHistory);
        return savedChangeHistory;
    }

    @Override
    public ChangeHistory selectChangeHistory(Long sid){
        ChangeHistory selectedChangeHistory;
        if(changeHistoryRepository.existsById(sid)){
            selectedChangeHistory = changeHistoryRepository.getById(sid);
        }else{
            selectedChangeHistory = new ChangeHistory();
        }
        return selectedChangeHistory;

    }


    @Override
    public ChangeHistory updateChangeHistory(ChangeHistory changeHistory) throws Exception{

        Optional<ChangeHistory> selectChangeHistory
                = changeHistoryRepository.findById(changeHistory.getSid());
        ChangeHistory updateChangeHistory;

        if(selectChangeHistory.isPresent()){
            ChangeHistory newChangeHistory = selectChangeHistory.get();

            newChangeHistory.setId(changeHistory.getId());
            newChangeHistory.setQ_id(changeHistory.getQ_id());
            newChangeHistory.setChange_Q(changeHistory.getChange_Q());
            newChangeHistory.setSid(changeHistory.getSid());
            newChangeHistory.setUpdatedAt(LocalDateTime.now());

            updateChangeHistory = changeHistoryRepository.save(newChangeHistory);
        }else{
            throw new Exception();
        }
        return updateChangeHistory;
    }

    @Override
    public void deleteChangeHistory(Long sid) throws Exception {
        Optional<ChangeHistory> selectedChangeHistory = changeHistoryRepository.findById(sid);
        if(selectedChangeHistory.isPresent()){
            ChangeHistory changeHistory = selectedChangeHistory.get();
            changeHistoryRepository.delete(changeHistory);
        }else{
            throw new Exception();
        }

    }


    @Override
    public List<ChangeHistory> getAllApplication() {
        return changeHistoryRepository.findAll();
    }

}
