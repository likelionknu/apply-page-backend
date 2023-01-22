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

        frontendApplicationResponse.setPhoneNumber(frontendApplication.getPhoneNumber());
        frontendApplicationResponse.setPortfolioFile(frontendApplication.getPortfolioFile());
        frontendApplicationResponse.setPortfolioLink(frontendApplication.getPortfolioLink());
        frontendApplicationResponse.setName(frontendApplication.getName());
        frontendApplicationResponse.setEmail(frontendApplication.getEmail());
        frontendApplicationResponse.setDepartment(frontendApplication.getDepartment());
        frontendApplicationResponse.setSid(frontendApplication.getSid());
        frontendApplicationResponse.setSubmissionStatus(frontendApplication.getSubmissionStatus());

        frontendApplicationResponse.setMotive(frontendApplication.getMotive());
        frontendApplicationResponse.setHardWork(frontendApplication.getHardWork());
        frontendApplicationResponse.setKeyWord(frontendApplication.getKeyWord());
        frontendApplicationResponse.setMostDeeplyWork(frontendApplication.getMostDeeplyWork());

        frontendApplicationResponse.setPassOrNot(frontendApplication.getPassOrNot());

        frontendApplicationResponse.setWhyFrontend(frontendApplication.getWhyFrontend());
        frontendApplicationResponse.setUsingStack(frontendApplication.getUsingStack());
        frontendApplicationResponse.setTeamProject(frontendApplication.getTeamProject());
        frontendApplicationResponse.setAchieve(frontendApplication.getAchieve());


        return frontendApplicationResponse;
    }

    @Override
    public FrontendApplicationDto saveFrontendApplication(FrontendApplicationDto frontendApplicationDto) {
        FrontendApplication frontendApplication = new FrontendApplication();

        frontendApplication.setPhoneNumber(frontendApplicationDto.getPhoneNumber());
        frontendApplication.setPortfolioFile(frontendApplicationDto.getPortfolioFile());
        frontendApplication.setPortfolioLink(frontendApplicationDto.getPortfolioLink());
        frontendApplication.setName(frontendApplicationDto.getName());
        frontendApplication.setEmail(frontendApplicationDto.getEmail());
        frontendApplication.setDepartment(frontendApplicationDto.getDepartment());
        frontendApplication.setSid(frontendApplicationDto.getSid());
        frontendApplication.setSubmissionStatus(frontendApplicationDto.getSubmissionStatus());

        frontendApplication.setMotive(frontendApplicationDto.getMotive());
        frontendApplication.setHardWork(frontendApplicationDto.getHardWork());
        frontendApplication.setKeyWord(frontendApplicationDto.getKeyWord());
        frontendApplication.setMostDeeplyWork(frontendApplicationDto.getMostDeeplyWork());

        frontendApplication.setPassOrNot(frontendApplicationDto.getPassOrNot());

        frontendApplication.setWhyFrontend(frontendApplicationDto.getWhyFrontend());
        frontendApplication.setUsingStack(frontendApplicationDto.getUsingStack());
        frontendApplication.setTeamProject(frontendApplicationDto.getTeamProject());
        frontendApplication.setAchieve(frontendApplicationDto.getAchieve());

        FrontendApplication savedFrontendApplication = frontendApplicationDAO.insertFrontendApplication(frontendApplication);
        FrontendApplicationDto frontendApplicationResponse = new FrontendApplicationDto();

        frontendApplicationResponse.setPhoneNumber(savedFrontendApplication.getPhoneNumber());
        frontendApplicationResponse.setPortfolioFile(savedFrontendApplication.getPortfolioFile());
        frontendApplicationResponse.setPortfolioLink(savedFrontendApplication.getPortfolioLink());
        frontendApplicationResponse.setName(savedFrontendApplication.getName());
        frontendApplicationResponse.setEmail(savedFrontendApplication.getEmail());
        frontendApplicationResponse.setDepartment(savedFrontendApplication.getDepartment());
        frontendApplicationResponse.setSid(savedFrontendApplication.getSid());
        frontendApplicationResponse.setSubmissionStatus(savedFrontendApplication.getSubmissionStatus());

        frontendApplicationResponse.setMotive(savedFrontendApplication.getMotive());
        frontendApplicationResponse.setHardWork(savedFrontendApplication.getHardWork());
        frontendApplicationResponse.setKeyWord(savedFrontendApplication.getKeyWord());
        frontendApplicationResponse.setMostDeeplyWork(savedFrontendApplication.getMostDeeplyWork());

        frontendApplicationResponse.setPassOrNot(savedFrontendApplication.getPassOrNot());

        frontendApplicationResponse.setWhyFrontend(savedFrontendApplication.getWhyFrontend());
        frontendApplicationResponse.setUsingStack(savedFrontendApplication.getUsingStack());
        frontendApplicationResponse.setTeamProject(savedFrontendApplication.getTeamProject());
        frontendApplicationResponse.setAchieve(savedFrontendApplication.getAchieve());

        return frontendApplicationResponse;
    }

    @Override
    public FrontendApplicationDto updateFrontendApplication(FrontendApplicationDto frontendApplicationDto) throws Exception {
        FrontendApplication frontendApplication = new FrontendApplication();

        frontendApplication.setPhoneNumber(frontendApplicationDto.getPhoneNumber());
        frontendApplication.setPortfolioFile(frontendApplicationDto.getPortfolioFile());
        frontendApplication.setPortfolioLink(frontendApplicationDto.getPortfolioLink());
        frontendApplication.setName(frontendApplicationDto.getName());
        frontendApplication.setEmail(frontendApplicationDto.getEmail());
        frontendApplication.setDepartment(frontendApplicationDto.getDepartment());
        frontendApplication.setSid(frontendApplicationDto.getSid());
        frontendApplication.setSubmissionStatus(frontendApplicationDto.getSubmissionStatus());

        frontendApplication.setMotive(frontendApplicationDto.getMotive());
        frontendApplication.setHardWork(frontendApplicationDto.getHardWork());
        frontendApplication.setKeyWord(frontendApplicationDto.getKeyWord());
        frontendApplication.setMostDeeplyWork(frontendApplicationDto.getMostDeeplyWork());

        frontendApplication.setPassOrNot(frontendApplicationDto.getPassOrNot());

        frontendApplication.setWhyFrontend(frontendApplicationDto.getWhyFrontend());
        frontendApplication.setUsingStack(frontendApplicationDto.getUsingStack());
        frontendApplication.setTeamProject(frontendApplicationDto.getTeamProject());
        frontendApplication.setAchieve(frontendApplicationDto.getAchieve());

        FrontendApplication updateFrontendApplication = frontendApplicationDAO.updateFrontendApplication(frontendApplication);
        FrontendApplicationDto updateFrontendApplicatonDto = new FrontendApplicationDto();

        updateFrontendApplicatonDto.setPhoneNumber(updateFrontendApplication.getPhoneNumber());
        updateFrontendApplicatonDto.setPortfolioFile(updateFrontendApplication.getPortfolioFile());
        updateFrontendApplicatonDto.setPortfolioLink(updateFrontendApplication.getPortfolioLink());
        updateFrontendApplicatonDto.setName(updateFrontendApplication.getName());
        updateFrontendApplicatonDto.setEmail(updateFrontendApplication.getEmail());
        updateFrontendApplicatonDto.setDepartment(updateFrontendApplication.getDepartment());
        updateFrontendApplicatonDto.setSid(updateFrontendApplication.getSid());
        updateFrontendApplicatonDto.setSubmissionStatus(updateFrontendApplication.getSubmissionStatus());

        updateFrontendApplicatonDto.setMotive(updateFrontendApplication.getMotive());
        updateFrontendApplicatonDto.setHardWork(updateFrontendApplication.getHardWork());
        updateFrontendApplicatonDto.setKeyWord(updateFrontendApplication.getKeyWord());
        updateFrontendApplicatonDto.setMostDeeplyWork(updateFrontendApplication.getMostDeeplyWork());

        updateFrontendApplicatonDto.setPassOrNot(updateFrontendApplication.getPassOrNot());

        updateFrontendApplicatonDto.setWhyFrontend(updateFrontendApplication.getWhyFrontend());
        updateFrontendApplicatonDto.setUsingStack(updateFrontendApplication.getUsingStack());
        updateFrontendApplicatonDto.setTeamProject(updateFrontendApplication.getTeamProject());
        updateFrontendApplicatonDto.setAchieve(updateFrontendApplication.getAchieve());

        return updateFrontendApplicatonDto;
    }

    @Override
    public void deleteFrontendApplication(String sid) throws Exception {
        frontendApplicationDAO.deleteFrontendApplication(sid);

    }

    @Override
    public void changePossOrNot(String sid) throws Exception {
        frontendApplicationDAO.changePassOrNot(sid);
    }
}
