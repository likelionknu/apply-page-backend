package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.FrontendApplicationDAO;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.FrontendApplication;
import com.springboot.applypage.data.repository.FrontendApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public FrontendApplication selectFrontendApplicationWithEmail(String sid, String email) {
        FrontendApplication selectedFrontendApplication;

        if(frontendApplicationRepository.existsById(sid)){
            selectedFrontendApplication = frontendApplicationRepository.getById(sid);
            if(!selectedFrontendApplication.getEmail().equals(email)){
                selectedFrontendApplication = new FrontendApplication();
            }
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
            newFrontendApplication.setSendMail(frontendApplication.getSendMail());

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

    @Override
    public void changeSendMail(String sid) throws Exception {
        Optional<FrontendApplication> selectedFrontendApplication = frontendApplicationRepository.findById(sid);

        if(selectedFrontendApplication.isPresent()){
            FrontendApplication newFrontApplication = selectedFrontendApplication.get();

            newFrontApplication.setSendMail(!newFrontApplication.getSendMail());
            frontendApplicationRepository.save(newFrontApplication);
        }else{
            throw new Exception();
        }
    }

    @Override
    public List<FrontendApplication> getReturn(Boolean dir) {
        return frontendApplicationRepository.findAll().stream()
                .filter(passOrNot -> passOrNot.getPassOrNot().equals(dir))
                .collect(Collectors.toList());
    }

    @Override
    public List<FrontendApplication> getSubmissionApplications(Boolean dir) {
        return frontendApplicationRepository.findAll().stream()
                .filter(submissionStatus -> submissionStatus.getSubmissionStatus().equals(dir))
                .collect(Collectors.toList());
    }

    @Override
    public List<FrontendApplication> getAllApplications() {
        return frontendApplicationRepository.findAll();
    }
}
