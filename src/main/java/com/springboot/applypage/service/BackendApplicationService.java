package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.BackendApplicationDto;

public interface BackendApplicationService {
    BackendApplicationDto getBackendApplication(String sid);
    BackendApplicationDto saveBackendApplication(BackendApplicationDto backendApplicationDto);
    BackendApplicationDto updateBackendApplication(BackendApplicationDto backendApplicationDto)
        throws Exception;
    void deleteBackendApplication(String sid) throws Exception;

}