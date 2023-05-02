package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.dto.ChangeHistoryDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.ChangeHistory;

import java.util.List;

public interface ChangeHistoryService {
    ChangeHistoryDto getChangeHistoryService(Long sid);
    ChangeHistoryDto saveChangeHistoryService(ChangeHistoryDto changeHistoryDto);
    ChangeHistoryDto updateChangeHistory(ChangeHistoryDto changeHistoryDto)
            throws Exception;
    void deleteChangeHistory(Long sid) throws Exception;
    List<ChangeHistory> getAllApplications();

}

