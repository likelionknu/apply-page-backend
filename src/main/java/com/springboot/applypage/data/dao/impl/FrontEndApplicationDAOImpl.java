package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.FrontendApplicationDAO;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.FrontendApplication;
import com.springboot.applypage.data.repository.FrontendApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class FrontEndApplicationDAOImpl implements FrontendApplicationDAO {

    FrontendApplicationRepository frontendApplicationRepository;
    @Autowired
    public FrontEndApplicationDAOImpl(FrontendApplicationRepository frontendApplicationRepository){
        this.frontendApplicationRepository = frontendApplicationRepository;
    }

    @Override
    public FrontendApplication insertFrontendApplication(FrontendApplication frontendApplication) {
        FrontendApplication savedFrontendApplication = frontendApplicationRepository.save(frontendApplication);
        return savedFrontendApplication;
    }

    @Override
    public FrontendApplication selectFrontendApplication(String sid) {
        FrontendApplication selectedFrontendApplication;

        if(frontendApplicationRepository.existsById(sid)){
            selectedFrontendApplication = frontendApplicationRepository.getById(sid);
        }else{
            selectedFrontendApplication = new FrontendApplication();
        }
        return selectedFrontendApplication;
    }

    @Override
    public FrontendApplication updateFrontendApplication(FrontendApplication frontendApplication) throws Exception {
        Optional<FrontendApplication> selectedFrontendApplication
                = frontendApplicationRepository.findById(frontendApplication.getSid());
        FrontendApplication updatedFrontendApplication;

        if(selectedFrontendApplication.isPresent()){
            FrontendApplication newFrontendApplication = selectedFrontendApplication.get();
            newFrontendApplication.setPhoneNumber(frontendApplication.getPhoneNumber());
            newFrontendApplication.setPortfolioFile(frontendApplication.getPortfolioFile());
            newFrontendApplication.setPortfolioLink(frontendApplication.getPortfolioLink());
            newFrontendApplication.setName(frontendApplication.getName());
            newFrontendApplication.setEmail(frontendApplication.getEmail());
            newFrontendApplication.setUpdatedAt(LocalDateTime.now());
            newFrontendApplication.setDepartment(frontendApplication.getDepartment());
            newFrontendApplication.setSid(frontendApplication.getSid());
            newFrontendApplication.setSubmissionStatus(frontendApplication.getSubmissionStatus());

            newFrontendApplication.setMotive(frontendApplication.getMotive());
            newFrontendApplication.setHardWork(frontendApplication.getHardWork());
            newFrontendApplication.setKeyWord(frontendApplication.getKeyWord());
            newFrontendApplication.setMostDeeplyWork(frontendApplication.getMostDeeplyWork());

            newFrontendApplication.setPassOrNot(frontendApplication.getPassOrNot());

            newFrontendApplication.setWhyFrontend(frontendApplication.getWhyFrontend());
            newFrontendApplication.setUsingStack(frontendApplication.getUsingStack());
            newFrontendApplication.setTeamProject(frontendApplication.getTeamProject());
            newFrontendApplication.setAchieve(frontendApplication.getAchieve());

            updatedFrontendApplication = frontendApplicationRepository.save(newFrontendApplication);

        }else{
            throw new Exception();
        }

        return updatedFrontendApplication;
    }

    @Override
    public void deleteFrontendApplication(String sid) throws Exception {
        Optional<FrontendApplication> selectedFrontendApplication
                = frontendApplicationRepository.findById(sid);

        if(selectedFrontendApplication.isPresent()){

            frontendApplicationRepository.delete(selectedFrontendApplication.get());

        }else{
            throw new Exception();
        }

    }

    @Override
    public void changePassOrNot(String sid) throws Exception {
        Optional<FrontendApplication> selectedFrontendApplication = frontendApplicationRepository.findById(sid);

        if(selectedFrontendApplication.isPresent()){
            FrontendApplication newFrontApplication = selectedFrontendApplication.get();

            newFrontApplication.setPassOrNot(!newFrontApplication.getPassOrNot());
            frontendApplicationRepository.save(newFrontApplication);
        }else{
            throw new Exception();
        }
    }
}
