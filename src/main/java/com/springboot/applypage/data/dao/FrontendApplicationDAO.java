package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.FrontendApplication;

public interface FrontendApplicationDAO {
    FrontendApplication insertFrontendApplication(FrontendApplication frontendApplication);
    FrontendApplication selectFrontendApplication(String sid);
    FrontendApplication updateFrontendApplication(FrontendApplication frontendApplication) throws Exception;
    void deleteFrontendApplication(String sid) throws Exception;
}
