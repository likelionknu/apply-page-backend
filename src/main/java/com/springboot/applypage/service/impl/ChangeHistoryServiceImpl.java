package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.BaseApplication_QDAO;
import com.springboot.applypage.data.dao.ChangeHistoryDAO;
import com.springboot.applypage.data.dto.BaseApplication_QDto;
import com.springboot.applypage.data.dto.ChangeHistoryDto;
import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.entity.ChangeHistory;
import com.springboot.applypage.service.ChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeHistoryServiceImpl implements ChangeHistoryService {
    private final ChangeHistoryDAO changeHistoryDAO;
    @Autowired
    public ChangeHistoryServiceImpl(ChangeHistoryDAO changeHistoryDAO){
        this.changeHistoryDAO = changeHistoryDAO;
    }

    @Override
    public ChangeHistoryDto getChangeHistoryService(Long id){

        ChangeHistory changeHistory = changeHistoryDAO.selectChangeHistory(id);
        ChangeHistoryDto changeHistoryResponse = new ChangeHistoryDto();

        changeHistoryResponse.setQ_id(changeHistory.getQ_id());
        changeHistoryResponse.setSid(changeHistory.getSid());
        changeHistoryResponse.setChange_Q(changeHistory.getChange_Q());
        changeHistoryResponse.setId(changeHistory.getId());
        changeHistoryResponse.setUpdatedAt(changeHistory.getUpdatedAt());

        return changeHistoryResponse;
    }

    @Override
    public ChangeHistoryDto saveChangeHistoryService(ChangeHistoryDto changeHistoryDto) {
        ChangeHistory changeHistory = new ChangeHistory();

        changeHistory.setQ_id(changeHistoryDto.getQ_id());
        changeHistory.setSid(changeHistoryDto.getSid());
        changeHistory.setChange_Q(changeHistoryDto.getChange_Q());

        ChangeHistory savedChangeHistory = changeHistoryDAO.insertChangeHistory(changeHistory);
        ChangeHistoryDto changeHistoryResponse = new ChangeHistoryDto();

        changeHistoryResponse.setQ_id(changeHistory.getQ_id());
        changeHistoryResponse.setSid(changeHistory.getSid());
        changeHistoryResponse.setChange_Q(changeHistory.getChange_Q());


        return changeHistoryResponse;
    }

    @Override
    public ChangeHistoryDto updateChangeHistory(ChangeHistoryDto changeHistoryDto) throws Exception {

        ChangeHistory changeHistory = new ChangeHistory();

        changeHistory.setQ_id(changeHistoryDto.getQ_id());

        changeHistory.setSid(changeHistoryDto.getSid());
        changeHistory.setChange_Q(changeHistoryDto.getChange_Q());

        ChangeHistory updateChangeHistory = changeHistoryDAO.updateChangeHistory(changeHistory);
        ChangeHistoryDto updateChangeHistoryDto = new ChangeHistoryDto();

        updateChangeHistoryDto.setQ_id(updateChangeHistory.getQ_id());
        updateChangeHistoryDto.setSid(updateChangeHistory.getSid());
        updateChangeHistoryDto.setChange_Q(updateChangeHistory.getChange_Q());

        return updateChangeHistoryDto;
    }

    @Override
    public void deleteChangeHistory(Long sid) throws Exception {

        changeHistoryDAO.deleteChangeHistory(sid);

    }

    @Override
    public List<ChangeHistory> getAllApplications() {
        return changeHistoryDAO.getAllApplication();
    }

}
