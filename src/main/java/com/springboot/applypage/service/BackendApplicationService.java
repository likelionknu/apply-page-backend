package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;

import java.util.List;

public interface BackendApplicationService {
    BackendApplicationDto getBackendApplication(String sid);
    BackendApplicationDto getBackendApplicationWithEmail(String sid, String email);
    BackendApplicationDto saveBackendApplication(BackendApplicationDto backendApplicationDto);
    BackendApplicationDto updateBackendApplication(BackendApplicationDto backendApplicationDto)
        throws Exception;
    void deleteBackendApplication(String sid) throws Exception;
    void changePossOrNot(String sid) throws Exception;
    void changeSendMail(String sid) throws Exception;
    List<BackendApplication> getReturn(Boolean dir);
    List<BackendApplication> getSubmissionApplications(Boolean dir);
    List<BackendApplication> getAllApplications();
    List<BackendApplication> getBackendApplicationWithPassOrNotAndSubmission(
            Boolean passOrNot, Boolean submission
    );

}