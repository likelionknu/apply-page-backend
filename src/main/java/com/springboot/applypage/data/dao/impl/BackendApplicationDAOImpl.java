package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.BackendApplicationDAO;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.repository.BackendApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BackendApplicationDAOImpl implements BackendApplicationDAO {

    private final BackendApplicationRepository backendApplicationRepository;
    @Autowired
    public BackendApplicationDAOImpl(BackendApplicationRepository backendApplicationRepository){
        this.backendApplicationRepository = backendApplicationRepository;
    }

    @Override
    public BackendApplication insertBackendApplication(BackendApplication backendApplication) {
        BackendApplication savedBackendApplication = backendApplicationRepository.save(backendApplication);
        return savedBackendApplication;
    }

    @Override
    public BackendApplication selectBackendApplication(String sid){
        BackendApplication selectedBackendApplication;
        if(backendApplicationRepository.existsById(sid)){
            selectedBackendApplication = backendApplicationRepository.getById(sid);
        }else{
            selectedBackendApplication = new BackendApplication();
        }
        return selectedBackendApplication;

    }

    @Override
    public BackendApplication updateBackendApplication(BackendApplication backendApplication) throws Exception{

        Optional<BackendApplication> selectBackendApplication
                = backendApplicationRepository.findById(backendApplication.getSid());
        BackendApplication updateBackendApplication;

        if(selectBackendApplication.isPresent()){
            BackendApplication newBackendApplication = selectBackendApplication.get();

            newBackendApplication.setPhoneNumber(backendApplication.getPhoneNumber());
            newBackendApplication.setPortfolioFile(backendApplication.getPortfolioFile());
            newBackendApplication.setPortfolioLink(backendApplication.getPortfolioLink());
            newBackendApplication.setName(backendApplication.getName());
            newBackendApplication.setEmail(backendApplication.getEmail());
            newBackendApplication.setUpdatedAt(LocalDateTime.now());
            newBackendApplication.setDepartment(backendApplication.getDepartment());
            newBackendApplication.setSubmissionStatus(backendApplication.getSubmissionStatus());

            newBackendApplication.setMotive(backendApplication.getMotive());
            newBackendApplication.setHardWork(backendApplication.getHardWork());
            newBackendApplication.setKeyWord(backendApplication.getKeyWord());
            newBackendApplication.setMostDeeplyWork(backendApplication.getMostDeeplyWork());

            newBackendApplication.setPassOrNot(backendApplication.getPassOrNot());

            newBackendApplication.setDifficultAndOvercoming(backendApplication.getDifficultAndOvercoming());
            newBackendApplication.setStudyFramework(backendApplication.getStudyFramework());
            newBackendApplication.setImportantGroup(backendApplication.getImportantGroup());



            updateBackendApplication = backendApplicationRepository.save(newBackendApplication);
        }else{
            throw new Exception();
        }
        return updateBackendApplication;
    }

    @Override
    public void deleteBackendApplication(String sid) throws Exception {
        Optional<BackendApplication> selectedBackendApplication = backendApplicationRepository.findById(sid);
        if(selectedBackendApplication.isPresent()){
            BackendApplication backendApplication = selectedBackendApplication.get();
            backendApplicationRepository.delete(backendApplication);
        }else{
            throw new Exception();
        }

    }

    @Override
    public void changePassOrNot(String sid) throws Exception {
        Optional<BackendApplication> selectedBackendApplication = backendApplicationRepository.findById(sid);
        backendApplicationRepository.findAll().stream()
                .filter(passOrNot -> passOrNot.getPassOrNot().equals(true))
                .collect(Collectors.toList());

        if(selectedBackendApplication.isPresent()){
            BackendApplication newBackendApplication = selectedBackendApplication.get();

            newBackendApplication.setPassOrNot(!newBackendApplication.getPassOrNot());
            backendApplicationRepository.save(newBackendApplication);
        }else{
            throw new Exception();
        }
    }

    @Override
    public List<BackendApplication> getReturn(Boolean dir) {
        return backendApplicationRepository.findAll().stream()
                .filter(passOrNot -> passOrNot.getPassOrNot().equals(dir))
                .collect(Collectors.toList());
    }

}
