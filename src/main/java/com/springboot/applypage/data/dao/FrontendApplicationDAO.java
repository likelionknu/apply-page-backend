package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.FrontendApplication;

import java.util.List;

public interface FrontendApplicationDAO {
    FrontendApplication insertFrontendApplication(FrontendApplication frontendApplication);
    FrontendApplication selectFrontendApplication(String sid);
    FrontendApplication selectFrontendApplicationWithEmail(String sid, String email);
    FrontendApplication updateFrontendApplication(FrontendApplication frontendApplication) throws Exception;
    void deleteFrontendApplication(String sid) throws Exception;
    void changePassOrNot(String sid) throws Exception;
    void changeSendMail(String sid) throws Exception;
    List<FrontendApplication> getReturn(Boolean dir);
    List<FrontendApplication> getSubmissionApplications(Boolean dir);
    List<FrontendApplication> getAllApplications();
}
