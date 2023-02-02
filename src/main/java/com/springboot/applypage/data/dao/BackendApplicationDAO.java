package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.BackendApplication;

import java.util.List;

public interface BackendApplicationDAO {

    BackendApplication insertBackendApplication(BackendApplication backendApplication);
    BackendApplication selectBackendApplication(String sid);
    BackendApplication selectBackendApplicationWithEmail(String sid, String email);
    BackendApplication updateBackendApplication(BackendApplication backendApplication) throws Exception;
    void deleteBackendApplication(String sid) throws Exception;
    void changePassOrNot(String sid) throws Exception;
    void changeSendMail(String sid) throws Exception;
    List<BackendApplication> getReturn(Boolean dir);
    List<BackendApplication> getAllApplication();
    List<BackendApplication> getSubmissionApplications(Boolean dir);
}
