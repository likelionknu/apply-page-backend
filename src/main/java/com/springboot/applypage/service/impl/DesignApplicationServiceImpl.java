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

        designApplicationResponse.setName(designApplication.getName());
        designApplicationResponse.setSid(designApplication.getSid());
        designApplicationResponse.setEmail(designApplication.getEmail());
        designApplicationResponse.setMotive(designApplication.getMotive());
        designApplicationResponse.setPortfolioFile(designApplication.getPortfolioFile());
        designApplicationResponse.setPortfolioLink(designApplication.getPortfolioLink());
        designApplicationResponse.setPhoneNumber(designApplication.getPhoneNumber());

        return designApplicationResponse;
    }

    @Override
    public DesignApplicationDto saveDesignApplication(DesignApplicationDto designApplicationDto) {
        DesignApplication designApplication = new DesignApplication();

        designApplication.setEmail(designApplicationDto.getEmail());
        designApplication.setName(designApplicationDto.getName());
        designApplication.setSid(designApplicationDto.getSid());
        designApplication.setMotive(designApplicationDto.getMotive());
        designApplication.setPortfolioFile(designApplicationDto.getPortfolioFile());
        designApplication.setPortfolioLink(designApplicationDto.getPortfolioLink());
        designApplication.setPhoneNumber(designApplicationDto.getPhoneNumber());

        DesignApplication saveDesignApplication = designApplicationDAO.insertDesignApplication(designApplication);
        DesignApplicationDto designApplicationResponse = new DesignApplicationDto();

        designApplicationResponse.setName(saveDesignApplication.getName());
        designApplicationResponse.setSid(saveDesignApplication.getSid());
        designApplicationResponse.setEmail(saveDesignApplication.getEmail());
        designApplicationResponse.setMotive(saveDesignApplication.getMotive());
        designApplicationResponse.setPortfolioFile(saveDesignApplication.getPortfolioFile());
        designApplicationResponse.setPortfolioLink(saveDesignApplication.getPortfolioLink());
        designApplicationResponse.setPhoneNumber(saveDesignApplication.getPhoneNumber());


        return designApplicationResponse;
    }

    @Override
    public DesignApplicationDto updateDesignApplication(DesignApplicationDto designApplicationDto) throws Exception {
        DesignApplication designApplication = new DesignApplication();
        designApplication.setEmail(designApplicationDto.getEmail());
        designApplication.setName(designApplicationDto.getName());
        designApplication.setPortfolioFile(designApplicationDto.getPortfolioFile());
        designApplication.setPortfolioLink(designApplicationDto.getPortfolioLink());
        designApplication.setMotive(designApplicationDto.getMotive());
        designApplication.setSid(designApplicationDto.getSid());
        designApplication.setPhoneNumber(designApplicationDto.getPhoneNumber());

        DesignApplication updateDesignApplication = designApplicationDAO.updateDesignApplication(designApplication);
        DesignApplicationDto updateDesignApplicationDto = new DesignApplicationDto();

        updateDesignApplicationDto.setEmail(updateDesignApplication.getEmail());
        updateDesignApplicationDto.setName(updateDesignApplication.getName());
        updateDesignApplicationDto.setPortfolioLink(updateDesignApplication.getPortfolioLink());
        updateDesignApplicationDto.setPortfolioFile(updateDesignApplication.getPortfolioFile());
        updateDesignApplicationDto.setMotive(updateDesignApplication.getMotive());
        updateDesignApplicationDto.setSid(updateDesignApplication.getSid());
        updateDesignApplicationDto.setPhoneNumber(updateDesignApplication.getPhoneNumber());

        return updateDesignApplicationDto;
    }

    @Override
    public void deleteDesignApplication(String sid) throws Exception {
        
        designApplicationDAO.deleteDesignApplication(sid);

    }
}
