package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.entity.ChangeHistory;

import java.util.List;

public interface ChangeHistoryDAO {
    ChangeHistory insertChangeHistory(ChangeHistory changeHistory);
    ChangeHistory selectChangeHistory(Long sid);
    ChangeHistory updateChangeHistory(ChangeHistory changeHistory) throws Exception;
    void deleteChangeHistory(Long sid) throws Exception;
    List<ChangeHistory> getAllApplication();
}
