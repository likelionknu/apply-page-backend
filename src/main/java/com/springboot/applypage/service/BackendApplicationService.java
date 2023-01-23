package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;

import java.util.List;

public interface BackendApplicationService {
    BackendApplicationDto getBackendApplication(String sid);
    BackendApplicationDto saveBackendApplication(BackendApplicationDto backendApplicationDto);
    BackendApplicationDto updateBackendApplication(BackendApplicationDto backendApplicationDto)
        throws Exception;
    void deleteBackendApplication(String sid) throws Exception;
    void changePossOrNot(String sid) throws Exception;
    List<BackendApplication> getReturn(Boolean dir);
    List<BackendApplication> getAllApplications();

}