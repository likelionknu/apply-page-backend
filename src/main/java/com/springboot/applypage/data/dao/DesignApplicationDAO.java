package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.DesignApplication;

import java.util.List;

public interface DesignApplicationDAO {

    DesignApplication insertDesignApplication(DesignApplication designApplication);
    DesignApplication selectDesignApplication(String sid);
    DesignApplication updateDesignApplication(DesignApplication designApplication) throws Exception;
    void deleteDesignApplication(String sid) throws Exception;
    void changePassOrNot(String sid) throws Exception;
    List<DesignApplication> getReturn(Boolean dir);
}
