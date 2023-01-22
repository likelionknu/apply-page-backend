package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.DesignApplicationDto;

public interface DesignApplicationService {
    DesignApplicationDto getDesignApplication(String sid);
    DesignApplicationDto saveDesignApplication(DesignApplicationDto designApplicationDto);
    DesignApplicationDto updateDesignApplication(DesignApplicationDto designApplicationDto)
            throws Exception;
    void deleteDesignApplication(String sid) throws Exception;
    void changePossOrNot(String sid) throws Exception;
}
