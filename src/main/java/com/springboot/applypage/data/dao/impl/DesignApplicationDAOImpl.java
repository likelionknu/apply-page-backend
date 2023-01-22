package com.springboot.applypage.data.dao.impl;

import com.springboot.applypage.data.dao.DesignApplicationDAO;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.repository.DesignApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class DesignApplicationDAOImpl implements DesignApplicationDAO {

    private final DesignApplicationRepository designApplicationRepository;
    @Autowired
    public DesignApplicationDAOImpl(DesignApplicationRepository designApplicationRepository){
        this.designApplicationRepository = designApplicationRepository;
    }

    @Override
    public DesignApplication insertDesignApplication(DesignApplication designApplication) {
        DesignApplication savedDesignApplication = designApplicationRepository.save(designApplication);
        return savedDesignApplication;
    }

    @Override
    public DesignApplication selectDesignApplication(String sid) {
        DesignApplication selectedDesignApplication;

        if(designApplicationRepository.existsById(sid)){
            selectedDesignApplication = designApplicationRepository.getById(sid);
        }else{
            selectedDesignApplication = new DesignApplication();
        }
        return selectedDesignApplication;
    }

    @Override
    public DesignApplication updateDesignApplication(DesignApplication designApplication) throws Exception {
        Optional<DesignApplication> selectDesignApplication
                = designApplicationRepository.findById(designApplication.getSid());
        DesignApplication updateDesignApplication;

        if(selectDesignApplication.isPresent()){
            DesignApplication newDesignApplication = selectDesignApplication.get();

            newDesignApplication.setPhoneNumber(designApplication.getPhoneNumber());
            newDesignApplication.setPortfolioFile(designApplication.getPortfolioFile());
            newDesignApplication.setPortfolioLink(designApplication.getPortfolioLink());
            newDesignApplication.setName(designApplication.getName());
            newDesignApplication.setEmail(designApplication.getEmail());
            newDesignApplication.setUpdatedAt(LocalDateTime.now());
            newDesignApplication.setDepartment(designApplication.getDepartment());
            newDesignApplication.setSubmissionStatus(designApplication.getSubmissionStatus());

            newDesignApplication.setMotive(designApplication.getMotive());
            newDesignApplication.setHardWork(designApplication.getHardWork());
            newDesignApplication.setKeyWord(designApplication.getKeyWord());
            newDesignApplication.setMostDeeplyWork(designApplication.getMostDeeplyWork());

            newDesignApplication.setPassOrNot(designApplication.getPassOrNot());

            newDesignApplication.setWhyDesign(designApplication.getWhyDesign());
            newDesignApplication.setToolExperience(designApplication.getToolExperience());
            newDesignApplication.setTeamworkExperience(designApplication.getTeamworkExperience());
            newDesignApplication.setDesignGrowth(designApplication.getDesignGrowth());

            updateDesignApplication = designApplicationRepository.save(newDesignApplication);
        }else{
            throw new Exception();
        }
        return updateDesignApplication;
    }

    @Override
    public void deleteDesignApplication(String sid) throws Exception {
        Optional<DesignApplication> selectedDesignApplication = designApplicationRepository.findById(sid);
        if(selectedDesignApplication.isPresent()){
            DesignApplication designApplication = selectedDesignApplication.get();
            designApplicationRepository.delete(designApplication);
        }else{
            throw new Exception();
        }

    }

    @Override
    public void changePassOrNot(String sid) throws Exception {
        Optional<DesignApplication> selectedDesignApplication = designApplicationRepository.findById(sid);

        if(selectedDesignApplication.isPresent()){
            DesignApplication newDesignApplication = selectedDesignApplication.get();

            newDesignApplication.setPassOrNot(!newDesignApplication.getPassOrNot());
            designApplicationRepository.save(newDesignApplication);
        }else{
            throw new Exception();
        }
    }
}
