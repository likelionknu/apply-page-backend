package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.FrontendApplicationDto;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.FrontendApplication;

import java.util.List;

public interface FrontendApplicationService {
    FrontendApplicationDto getFrontendApplication(String sid);
    FrontendApplicationDto getFrontendApplicationWithEmail(String sid, String email);
    FrontendApplicationDto saveFrontendApplication(FrontendApplicationDto backendApplicationDto);
    FrontendApplicationDto updateFrontendApplication(FrontendApplicationDto backendApplicationDto)
            throws Exception;
    void deleteFrontendApplication(String sid) throws Exception;
    void changePossOrNot(String sid) throws Exception;
    void changeSendMail(String sid) throws Exception;
    List<FrontendApplication> getReturn(Boolean dir);
    List<FrontendApplication> getSubmissionApplication(Boolean dir);
    List<FrontendApplication> getAllApplications();
    List<FrontendApplication> getApplicationsWithPassOrNotAndSubmission(Boolean passOrNot, Boolean submission);
}
