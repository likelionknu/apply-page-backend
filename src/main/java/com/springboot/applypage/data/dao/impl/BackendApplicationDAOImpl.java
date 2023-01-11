package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.BackendApplicationDAO;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.repository.BackendApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public BackendApplication selectBackendApplication(String sid) {
        BackendApplication selectedBackendApplication = backendApplicationRepository.getById(sid);
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
            newBackendApplication.setPortfolio(backendApplication.getPortfolio());
            newBackendApplication.setMotive(backendApplication.getMotive());
            newBackendApplication.setName(backendApplication.getName());
            newBackendApplication.setEmail(backendApplication.getEmail());
            newBackendApplication.setUpdatedAt(LocalDateTime.now());

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
}
