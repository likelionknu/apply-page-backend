package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.DesignApplicationDAO;
import com.springboot.applypage.data.dao.impl.DesignApplicationDAOImpl;
import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.dto.DesignApplicationDto;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.data.entity.DesignApplication;
import com.springboot.applypage.service.DesignApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DesignApplicationServiceImpl implements DesignApplicationService {

    private final DesignApplicationDAO designApplicationDAO;
    @Autowired
    public DesignApplicationServiceImpl(DesignApplicationDAO designApplicationDAO){
        this.designApplicationDAO = designApplicationDAO;
    }

    @Override
    public DesignApplicationDto getDesignApplication(String sid) {
        DesignApplication designApplication = designApplicationDAO.selectDesignApplication(sid);
        DesignApplicationDto designApplicationResponse = new DesignApplicationDto();

        designApplicationResponse.setSid(designApplication.getSid());
        designApplicationResponse.setPhoneNumber(designApplication.getPhoneNumber());
        designApplicationResponse.setPortfolioFile(designApplication.getPortfolioFile());
        designApplicationResponse.setPortfolioLink(designApplication.getPortfolioLink());
        designApplicationResponse.setName(designApplication.getName());
        designApplicationResponse.setEmail(designApplication.getEmail());
        designApplicationResponse.setDepartment(designApplication.getDepartment());
        designApplicationResponse.setSubmissionStatus(designApplication.getSubmissionStatus());

        designApplicationResponse.setMotive(designApplication.getMotive());
        designApplicationResponse.setHardWork(designApplication.getHardWork());
        designApplicationResponse.setKeyWord(designApplication.getKeyWord());
        designApplicationResponse.setMostDeeplyWork(designApplication.getMostDeeplyWork());

        designApplicationResponse.setPassOrNot(designApplication.getPassOrNot());

        designApplicationResponse.setWhyDesign(designApplication.getWhyDesign());
        designApplicationResponse.setToolExperience(designApplication.getToolExperience());
        designApplicationResponse.setTeamworkExperience(designApplication.getTeamworkExperience());
        designApplicationResponse.setDesignGrowth(designApplication.getDesignGrowth());

        return designApplicationResponse;
    }

    @Override
    public DesignApplicationDto saveDesignApplication(DesignApplicationDto designApplicationDto) {
        DesignApplication designApplication = new DesignApplication();

        designApplication.setSid(designApplicationDto.getSid());
        designApplication.setPhoneNumber(designApplicationDto.getPhoneNumber());
        designApplication.setPortfolioFile(designApplicationDto.getPortfolioFile());
        designApplication.setPortfolioLink(designApplicationDto.getPortfolioLink());
        designApplication.setName(designApplicationDto.getName());
        designApplication.setEmail(designApplicationDto.getEmail());
        designApplication.setDepartment(designApplicationDto.getDepartment());
        designApplication.setSubmissionStatus(designApplicationDto.getSubmissionStatus());

        designApplication.setMotive(designApplicationDto.getMotive());
        designApplication.setHardWork(designApplicationDto.getHardWork());
        designApplication.setKeyWord(designApplicationDto.getKeyWord());
        designApplication.setMostDeeplyWork(designApplicationDto.getMostDeeplyWork());

        designApplication.setPassOrNot(designApplicationDto.getPassOrNot());

        designApplication.setWhyDesign(designApplicationDto.getWhyDesign());
        designApplication.setToolExperience(designApplicationDto.getToolExperience());
        designApplication.setTeamworkExperience(designApplicationDto.getTeamworkExperience());
        designApplication.setDesignGrowth(designApplicationDto.getDesignGrowth());

        DesignApplication saveDesignApplication = designApplicationDAO.insertDesignApplication(designApplication);
        DesignApplicationDto designApplicationResponse = new DesignApplicationDto();

        designApplicationResponse.setSid(saveDesignApplication.getSid());
        designApplicationResponse.setPhoneNumber(saveDesignApplication.getPhoneNumber());
        designApplicationResponse.setPortfolioFile(saveDesignApplication.getPortfolioFile());
        designApplicationResponse.setPortfolioLink(saveDesignApplication.getPortfolioLink());
        designApplicationResponse.setName(saveDesignApplication.getName());
        designApplicationResponse.setEmail(saveDesignApplication.getEmail());
        designApplicationResponse.setDepartment(saveDesignApplication.getDepartment());
        designApplicationResponse.setSubmissionStatus(saveDesignApplication.getSubmissionStatus());

        designApplicationResponse.setMotive(saveDesignApplication.getMotive());
        designApplicationResponse.setHardWork(saveDesignApplication.getHardWork());
        designApplicationResponse.setKeyWord(saveDesignApplication.getKeyWord());
        designApplicationResponse.setMostDeeplyWork(saveDesignApplication.getMostDeeplyWork());

        designApplicationResponse.setPassOrNot(saveDesignApplication.getPassOrNot());

        designApplicationResponse.setWhyDesign(saveDesignApplication.getWhyDesign());
        designApplicationResponse.setToolExperience(saveDesignApplication.getToolExperience());
        designApplicationResponse.setTeamworkExperience(saveDesignApplication.getTeamworkExperience());
        designApplicationResponse.setDesignGrowth(saveDesignApplication.getDesignGrowth());


        return designApplicationResponse;
    }

    @Override
    public DesignApplicationDto updateDesignApplication(DesignApplicationDto designApplicationDto) throws Exception {
        DesignApplication designApplication = new DesignApplication();

        designApplication.setSid(designApplicationDto.getSid());
        designApplication.setPhoneNumber(designApplicationDto.getPhoneNumber());
        designApplication.setPortfolioFile(designApplicationDto.getPortfolioFile());
        designApplication.setPortfolioLink(designApplicationDto.getPortfolioLink());
        designApplication.setName(designApplicationDto.getName());
        designApplication.setEmail(designApplicationDto.getEmail());
        designApplication.setDepartment(designApplicationDto.getDepartment());
        designApplication.setSubmissionStatus(designApplicationDto.getSubmissionStatus());

        designApplication.setMotive(designApplicationDto.getMotive());
        designApplication.setHardWork(designApplicationDto.getHardWork());
        designApplication.setKeyWord(designApplicationDto.getKeyWord());
        designApplication.setMostDeeplyWork(designApplicationDto.getMostDeeplyWork());

        designApplication.setPassOrNot(designApplicationDto.getPassOrNot());

        designApplication.setWhyDesign(designApplicationDto.getWhyDesign());
        designApplication.setToolExperience(designApplicationDto.getToolExperience());
        designApplication.setTeamworkExperience(designApplicationDto.getTeamworkExperience());
        designApplication.setDesignGrowth(designApplicationDto.getDesignGrowth());

        DesignApplication updateDesignApplication = designApplicationDAO.updateDesignApplication(designApplication);
        DesignApplicationDto updateDesignApplicationDto = new DesignApplicationDto();

        updateDesignApplicationDto.setSid(updateDesignApplication.getSid());
        updateDesignApplicationDto.setPhoneNumber(updateDesignApplication.getPhoneNumber());
        updateDesignApplicationDto.setPortfolioFile(updateDesignApplication.getPortfolioFile());
        updateDesignApplicationDto.setPortfolioLink(updateDesignApplication.getPortfolioLink());
        updateDesignApplicationDto.setName(updateDesignApplication.getName());
        updateDesignApplicationDto.setEmail(updateDesignApplication.getEmail());
        updateDesignApplicationDto.setDepartment(updateDesignApplication.getDepartment());
        updateDesignApplicationDto.setSubmissionStatus(updateDesignApplication.getSubmissionStatus());

        updateDesignApplicationDto.setMotive(updateDesignApplication.getMotive());
        updateDesignApplicationDto.setHardWork(updateDesignApplication.getHardWork());
        updateDesignApplicationDto.setKeyWord(updateDesignApplication.getKeyWord());
        updateDesignApplicationDto.setMostDeeplyWork(updateDesignApplication.getMostDeeplyWork());

        updateDesignApplicationDto.setPassOrNot(updateDesignApplication.getPassOrNot());

        updateDesignApplicationDto.setWhyDesign(updateDesignApplication.getWhyDesign());
        updateDesignApplicationDto.setToolExperience(updateDesignApplication.getToolExperience());
        updateDesignApplicationDto.setTeamworkExperience(updateDesignApplication.getTeamworkExperience());
        updateDesignApplicationDto.setDesignGrowth(updateDesignApplication.getDesignGrowth());

        return updateDesignApplicationDto;
    }

    @Override
    public void deleteDesignApplication(String sid) throws Exception {
        
        designApplicationDAO.deleteDesignApplication(sid);

    }

    @Override
    public void changePossOrNot(String sid) throws Exception {
        designApplicationDAO.changePassOrNot(sid);
    }

    @Override
    public List<DesignApplication> getReturn(Boolean dir) {
        return designApplicationDAO.getReturn(dir);
    }
}
