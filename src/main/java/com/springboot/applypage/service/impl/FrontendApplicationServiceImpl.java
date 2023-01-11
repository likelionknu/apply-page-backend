package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.FrontendApplicationDAO;
import com.springboot.applypage.data.dto.FrontendApplicationDto;
import com.springboot.applypage.data.entity.FrontendApplication;
import com.springboot.applypage.service.FrontendApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontendApplicationServiceImpl implements FrontendApplicationService {

    FrontendApplicationDAO frontendApplicationDAO;
    @Autowired
    public FrontendApplicationServiceImpl(FrontendApplicationDAO frontendApplicationDAO){
        this.frontendApplicationDAO = frontendApplicationDAO;
    }

    @Override
    public FrontendApplicationDto getFrontendApplication(String sid) {
        FrontendApplication frontendApplication = frontendApplicationDAO.selectFrontendApplication(sid);
        FrontendApplicationDto frontendApplicationResponse = new FrontendApplicationDto();

        frontendApplicationResponse.setName(frontendApplication.getName());
        frontendApplicationResponse.setSid(frontendApplication.getSid());
        frontendApplicationResponse.setEmail(frontendApplication.getEmail());
        frontendApplicationResponse.setMotive(frontendApplication.getMotive());
        frontendApplicationResponse.setPortfolio(frontendApplication.getPortfolio());
        frontendApplicationResponse.setPhoneNumber(frontendApplication.getPhoneNumber());

        return frontendApplicationResponse;
    }

    @Override
    public FrontendApplicationDto saveFrontendApplication(FrontendApplicationDto frontendApplicationDto) {
        FrontendApplication frontendApplication = new FrontendApplication();

        frontendApplication.setEmail(frontendApplicationDto.getEmail());
        frontendApplication.setName(frontendApplicationDto.getName());
        frontendApplication.setSid(frontendApplicationDto.getSid());
        frontendApplication.setMotive(frontendApplicationDto.getMotive());
        frontendApplication.setPortfolio(frontendApplicationDto.getPortfolio());
        frontendApplication.setPhoneNumber(frontendApplicationDto.getPhoneNumber());

        FrontendApplication savedFrontendApplication = frontendApplicationDAO.insertFrontendApplication(frontendApplication);
        FrontendApplicationDto FrontendApplicationResponse = new FrontendApplicationDto();

        FrontendApplicationResponse.setName(savedFrontendApplication.getName());
        FrontendApplicationResponse.setSid(savedFrontendApplication.getSid());
        FrontendApplicationResponse.setEmail(savedFrontendApplication.getEmail());
        FrontendApplicationResponse.setMotive(savedFrontendApplication.getMotive());
        FrontendApplicationResponse.setPortfolio(savedFrontendApplication.getPortfolio());
        FrontendApplicationResponse.setPhoneNumber(savedFrontendApplication.getPhoneNumber());


        return FrontendApplicationResponse;
    }

    @Override
    public FrontendApplicationDto updateFrontendApplication(FrontendApplicationDto frontendApplicationDto) throws Exception {
        FrontendApplication frontendApplication = new FrontendApplication();
        frontendApplication.setEmail(frontendApplicationDto.getEmail());
        frontendApplication.setName(frontendApplicationDto.getName());
        frontendApplication.setPortfolio(frontendApplicationDto.getPortfolio());
        frontendApplication.setMotive(frontendApplicationDto.getMotive());
        frontendApplication.setSid(frontendApplicationDto.getSid());
        frontendApplication.setPhoneNumber(frontendApplicationDto.getPhoneNumber());

        FrontendApplication updateFrontendApplication = frontendApplicationDAO.updateFrontendApplication(frontendApplication);
        FrontendApplicationDto updateFrontendApplicatonDto = new FrontendApplicationDto();

        updateFrontendApplicatonDto.setEmail(updateFrontendApplication.getEmail());
        updateFrontendApplicatonDto.setName(updateFrontendApplication.getName());
        updateFrontendApplicatonDto.setPortfolio(updateFrontendApplication.getPortfolio());
        updateFrontendApplicatonDto.setMotive(updateFrontendApplication.getMotive());
        updateFrontendApplicatonDto.setSid(updateFrontendApplication.getSid());
        updateFrontendApplicatonDto.setPhoneNumber(updateFrontendApplication.getPhoneNumber());

        return updateFrontendApplicatonDto;
    }

    @Override
    public void deleteFrontendApplication(String sid) throws Exception {
        frontendApplicationDAO.deleteFrontendApplication(sid);

    }
}
