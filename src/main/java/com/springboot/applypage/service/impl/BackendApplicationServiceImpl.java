package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.BackendApplicationDAO;
import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.service.BackendApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackendApplicationServiceImpl implements BackendApplicationService {

    private final BackendApplicationDAO backendApplicationDAO;
    @Autowired
    public BackendApplicationServiceImpl(BackendApplicationDAO backendApplicationDAO){
        this.backendApplicationDAO = backendApplicationDAO;
    }

    @Override
    public BackendApplicationDto getBackendApplication(String sid) {
        BackendApplication backendApplication = backendApplicationDAO.selectBackendApplication(sid);
        BackendApplicationDto backendApplicationResponse = new BackendApplicationDto();

        backendApplicationResponse.setName(backendApplication.getName());
        backendApplicationResponse.setSid(backendApplication.getSid());
        backendApplicationResponse.setEmail(backendApplication.getEmail());
        backendApplicationResponse.setMotive(backendApplication.getMotive());
        backendApplicationResponse.setPortfolioFile(backendApplication.getPortfolioFile());
        backendApplicationResponse.setPortfolioLink(backendApplication.getPortfolioLink());
        backendApplicationResponse.setPhoneNumber(backendApplication.getPhoneNumber());

        return backendApplicationResponse;
    }

    @Override
    public BackendApplicationDto saveBackendApplication(BackendApplicationDto backendApplicationDto) {
        BackendApplication backendApplication = new BackendApplication();

        backendApplication.setEmail(backendApplicationDto.getEmail());
        backendApplication.setName(backendApplicationDto.getName());
        backendApplication.setSid(backendApplicationDto.getSid());
        backendApplication.setMotive(backendApplicationDto.getMotive());
        backendApplication.setPortfolioFile(backendApplicationDto.getPortfolioFile());
        backendApplication.setPortfolioLink(backendApplicationDto.getPortfolioLink());
        backendApplication.setPhoneNumber(backendApplicationDto.getPhoneNumber());

        BackendApplication savedBackendApplication = backendApplicationDAO.insertBackendApplication(backendApplication);
        BackendApplicationDto backendApplicationResponse = new BackendApplicationDto();

        backendApplicationResponse.setName(savedBackendApplication.getName());
        backendApplicationResponse.setSid(savedBackendApplication.getSid());
        backendApplicationResponse.setEmail(savedBackendApplication.getEmail());
        backendApplicationResponse.setMotive(savedBackendApplication.getMotive());
        backendApplicationResponse.setPortfolioFile(savedBackendApplication.getPortfolioFile());
        backendApplicationResponse.setPortfolioLink(savedBackendApplication.getPortfolioLink());
        backendApplicationResponse.setPhoneNumber(savedBackendApplication.getPhoneNumber());


        return backendApplicationResponse;
    }

    @Override
    public BackendApplicationDto updateBackendApplication(BackendApplicationDto backendApplicationDto) throws Exception {

        BackendApplication backendApplication = new BackendApplication();
        backendApplication.setEmail(backendApplicationDto.getEmail());
        backendApplication.setName(backendApplicationDto.getName());
        backendApplication.setPortfolioFile(backendApplicationDto.getPortfolioFile());
        backendApplication.setPortfolioLink(backendApplicationDto.getPortfolioLink());
        backendApplication.setMotive(backendApplicationDto.getMotive());
        backendApplication.setSid(backendApplicationDto.getSid());
        backendApplication.setPhoneNumber(backendApplicationDto.getPhoneNumber());

        BackendApplication updateBackendApplication = backendApplicationDAO.updateBackendApplication(backendApplication);
        BackendApplicationDto updateBackendApplicationDto = new BackendApplicationDto();

        updateBackendApplicationDto.setEmail(updateBackendApplication.getEmail());
        updateBackendApplicationDto.setName(updateBackendApplication.getName());
        updateBackendApplicationDto.setPortfolioLink(updateBackendApplication.getPortfolioLink());
        updateBackendApplicationDto.setPortfolioFile(updateBackendApplication.getPortfolioFile());
        updateBackendApplicationDto.setMotive(updateBackendApplication.getMotive());
        updateBackendApplicationDto.setSid(updateBackendApplication.getSid());
        updateBackendApplicationDto.setPhoneNumber(updateBackendApplication.getPhoneNumber());

        return updateBackendApplicationDto;
    }

    @Override
    public void deleteBackendApplication(String sid) throws Exception {

        backendApplicationDAO.deleteBackendApplication(sid);

    }
}
