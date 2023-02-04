package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.DesignApplication;

import java.util.List;

public interface DesignApplicationService {
    DesignApplicationDto getDesignApplication(String sid);
    DesignApplicationDto getDesignApplicationWithEmail(String sid, String email);
    DesignApplicationDto saveDesignApplication(DesignApplicationDto designApplicationDto);
    DesignApplicationDto updateDesignApplication(DesignApplicationDto designApplicationDto)
            throws Exception;
    void deleteDesignApplication(String sid) throws Exception;
    void changePossOrNot(String sid) throws Exception;
    void changeSendMail(String sid) throws Exception;
    List<DesignApplication> getReturn(Boolean dir);
    List<DesignApplication> getSubmissionApplication(Boolean dir);
    List<DesignApplication> getAllApplications();
    List<DesignApplication> getDesignApplicationWithPassOrNotAndSubmission(
            Boolean passOrNot, Boolean submission
    );

}
