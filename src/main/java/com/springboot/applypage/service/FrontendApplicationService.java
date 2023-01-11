package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.FrontendApplicationDto;

public interface FrontendApplicationService {
    FrontendApplicationDto getFrontendApplication(String sid);
    FrontendApplicationDto saveFrontendApplication(FrontendApplicationDto backendApplicationDto);
    FrontendApplicationDto updateFrontendApplication(FrontendApplicationDto backendApplicationDto)
            throws Exception;
    void deleteFrontendApplication(String sid) throws Exception;
}
