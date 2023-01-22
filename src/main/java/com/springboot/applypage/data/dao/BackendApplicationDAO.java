package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.BackendApplication;

import java.util.List;

public interface BackendApplicationDAO {

    BackendApplication insertBackendApplication(BackendApplication backendApplication);
    BackendApplication selectBackendApplication(String sid);
    BackendApplication updateBackendApplication(BackendApplication backendApplication) throws Exception;
    void deleteBackendApplication(String sid) throws Exception;
    void changePassOrNot(String id) throws Exception;
    List<BackendApplication> getReturn(Boolean dir);
}
