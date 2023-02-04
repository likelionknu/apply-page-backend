package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.BackendApplicationDAO;
import com.springboot.applypage.data.dto.BackendApplicationDto;
import com.springboot.applypage.data.entity.BackendApplication;
import com.springboot.applypage.service.BackendApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BackendApplicationServiceImpl implements BackendApplicationService {

    private final BackendApplicationDAO backendApplicationDAO;
    @Autowired
    public BackendApplicationServiceImpl(BackendApplicationDAO backendApplicationDAO){
        this.backendApplicationDAO = backendApplicationDAO;
    }

    @Override
    public BackendApplicationDto getBackendApplication(String sid){

        BackendApplication backendApplication = backendApplicationDAO.selectBackendApplication(sid);
        BackendApplicationDto backendApplicationResponse = new BackendApplicationDto();

        backendApplicationResponse.setSid(backendApplication.getSid());
        backendApplicationResponse.setPhoneNumber(backendApplication.getPhoneNumber());
        backendApplicationResponse.setPortfolioFile(backendApplication.getPortfolioFile());
        backendApplicationResponse.setPortfolioLink(backendApplication.getPortfolioLink());
        backendApplicationResponse.setName(backendApplication.getName());
        backendApplicationResponse.setEmail(backendApplication.getEmail());
        backendApplicationResponse.setDepartment(backendApplication.getDepartment());
        backendApplicationResponse.setSubmissionStatus(backendApplication.getSubmissionStatus());
        backendApplicationResponse.setSendMail(backendApplication.getSendMail());

        backendApplicationResponse.setMotive(backendApplication.getMotive());
        backendApplicationResponse.setHardWork(backendApplication.getHardWork());
        backendApplicationResponse.setKeyWord(backendApplication.getKeyWord());
        backendApplicationResponse.setMostDeeplyWork(backendApplication.getMostDeeplyWork());

        backendApplicationResponse.setPassOrNot(backendApplication.getPassOrNot());

        backendApplicationResponse.setDifficultAndOvercoming(backendApplication.getDifficultAndOvercoming());
        backendApplicationResponse.setStudyFramework(backendApplication.getStudyFramework());
        backendApplicationResponse.setImportantGroup(backendApplication.getImportantGroup());

        return backendApplicationResponse;
    }

    @Override
    public BackendApplicationDto getBackendApplicationWithEmail(String sid, String email) {
        BackendApplication backendApplication = backendApplicationDAO.selectBackendApplicationWithEmail(sid, email);
        BackendApplicationDto backendApplicationResponse = new BackendApplicationDto();

        backendApplicationResponse.setSid(backendApplication.getSid());
        backendApplicationResponse.setPhoneNumber(backendApplication.getPhoneNumber());
        backendApplicationResponse.setPortfolioFile(backendApplication.getPortfolioFile());
        backendApplicationResponse.setPortfolioLink(backendApplication.getPortfolioLink());
        backendApplicationResponse.setName(backendApplication.getName());
        backendApplicationResponse.setEmail(backendApplication.getEmail());
        backendApplicationResponse.setDepartment(backendApplication.getDepartment());
        backendApplicationResponse.setSubmissionStatus(backendApplication.getSubmissionStatus());
        backendApplicationResponse.setSendMail(backendApplication.getSendMail());

        backendApplicationResponse.setMotive(backendApplication.getMotive());
        backendApplicationResponse.setHardWork(backendApplication.getHardWork());
        backendApplicationResponse.setKeyWord(backendApplication.getKeyWord());
        backendApplicationResponse.setMostDeeplyWork(backendApplication.getMostDeeplyWork());

        backendApplicationResponse.setPassOrNot(backendApplication.getPassOrNot());

        backendApplicationResponse.setDifficultAndOvercoming(backendApplication.getDifficultAndOvercoming());
        backendApplicationResponse.setStudyFramework(backendApplication.getStudyFramework());
        backendApplicationResponse.setImportantGroup(backendApplication.getImportantGroup());

        return backendApplicationResponse;
    }

    @Override
    public BackendApplicationDto saveBackendApplication(BackendApplicationDto backendApplicationDto) {
        BackendApplication backendApplication = new BackendApplication();

        backendApplication.setSid(backendApplicationDto.getSid());
        backendApplication.setPhoneNumber(backendApplicationDto.getPhoneNumber());
        backendApplication.setPortfolioFile(backendApplicationDto.getPortfolioFile());
        backendApplication.setPortfolioLink(backendApplicationDto.getPortfolioLink());
        backendApplication.setName(backendApplicationDto.getName());
        backendApplication.setEmail(backendApplicationDto.getEmail());
        backendApplication.setDepartment(backendApplicationDto.getDepartment());
        backendApplication.setSubmissionStatus(backendApplicationDto.getSubmissionStatus());
        backendApplication.setSendMail(backendApplicationDto.getSendMail());

        backendApplication.setMotive(backendApplicationDto.getMotive());
        backendApplication.setHardWork(backendApplicationDto.getHardWork());
        backendApplication.setKeyWord(backendApplicationDto.getKeyWord());
        backendApplication.setMostDeeplyWork(backendApplicationDto.getMostDeeplyWork());

        backendApplication.setPassOrNot(backendApplicationDto.getPassOrNot());

        backendApplication.setDifficultAndOvercoming(backendApplicationDto.getDifficultAndOvercoming());
        backendApplication.setStudyFramework(backendApplicationDto.getStudyFramework());
        backendApplication.setImportantGroup(backendApplicationDto.getImportantGroup());


        BackendApplication savedBackendApplication = backendApplicationDAO.insertBackendApplication(backendApplication);
        BackendApplicationDto backendApplicationResponse = new BackendApplicationDto();

        backendApplicationResponse.setSid(savedBackendApplication.getSid());
        backendApplicationResponse.setPhoneNumber(savedBackendApplication.getPhoneNumber());
        backendApplicationResponse.setPortfolioFile(savedBackendApplication.getPortfolioFile());
        backendApplicationResponse.setPortfolioLink(savedBackendApplication.getPortfolioLink());
        backendApplicationResponse.setName(savedBackendApplication.getName());
        backendApplicationResponse.setEmail(savedBackendApplication.getEmail());
        backendApplicationResponse.setDepartment(savedBackendApplication.getDepartment());
        backendApplicationResponse.setSubmissionStatus(savedBackendApplication.getSubmissionStatus());
        backendApplicationResponse.setSendMail(savedBackendApplication.getSendMail());

        backendApplicationResponse.setMotive(savedBackendApplication.getMotive());
        backendApplicationResponse.setHardWork(savedBackendApplication.getHardWork());
        backendApplicationResponse.setKeyWord(savedBackendApplication.getKeyWord());
        backendApplicationResponse.setMostDeeplyWork(savedBackendApplication.getMostDeeplyWork());

        backendApplicationResponse.setPassOrNot(savedBackendApplication.getPassOrNot());

        backendApplicationResponse.setDifficultAndOvercoming(savedBackendApplication.getDifficultAndOvercoming());
        backendApplicationResponse.setStudyFramework(savedBackendApplication.getStudyFramework());
        backendApplicationResponse.setImportantGroup(savedBackendApplication.getImportantGroup());


        return backendApplicationResponse;
    }

    @Override
    public BackendApplicationDto updateBackendApplication(BackendApplicationDto backendApplicationDto) throws Exception {

        BackendApplication backendApplication = new BackendApplication();
        backendApplication.setSid(backendApplicationDto.getSid());
        backendApplication.setPhoneNumber(backendApplicationDto.getPhoneNumber());
        backendApplication.setPortfolioFile(backendApplicationDto.getPortfolioFile());
        backendApplication.setPortfolioLink(backendApplicationDto.getPortfolioLink());
        backendApplication.setName(backendApplicationDto.getName());
        backendApplication.setEmail(backendApplicationDto.getEmail());
        backendApplication.setDepartment(backendApplicationDto.getDepartment());
        backendApplication.setSubmissionStatus(backendApplicationDto.getSubmissionStatus());
        backendApplication.setSendMail(backendApplicationDto.getSendMail());

        backendApplication.setMotive(backendApplicationDto.getMotive());
        backendApplication.setHardWork(backendApplicationDto.getHardWork());
        backendApplication.setKeyWord(backendApplicationDto.getKeyWord());
        backendApplication.setMostDeeplyWork(backendApplicationDto.getMostDeeplyWork());

        backendApplication.setPassOrNot(backendApplicationDto.getPassOrNot());

        backendApplication.setDifficultAndOvercoming(backendApplicationDto.getDifficultAndOvercoming());
        backendApplication.setStudyFramework(backendApplicationDto.getStudyFramework());
        backendApplication.setImportantGroup(backendApplicationDto.getImportantGroup());

        BackendApplication updateBackendApplication = backendApplicationDAO.updateBackendApplication(backendApplication);
        BackendApplicationDto updateBackendApplicationDto = new BackendApplicationDto();

        updateBackendApplicationDto.setSid(updateBackendApplication.getSid());
        updateBackendApplicationDto.setPhoneNumber(updateBackendApplication.getPhoneNumber());
        updateBackendApplicationDto.setPortfolioFile(updateBackendApplication.getPortfolioFile());
        updateBackendApplicationDto.setPortfolioLink(updateBackendApplication.getPortfolioLink());
        updateBackendApplicationDto.setName(updateBackendApplication.getName());
        updateBackendApplicationDto.setEmail(updateBackendApplication.getEmail());
        updateBackendApplicationDto.setDepartment(updateBackendApplication.getDepartment());
        updateBackendApplicationDto.setSubmissionStatus(updateBackendApplication.getSubmissionStatus());
        updateBackendApplicationDto.setSendMail(updateBackendApplication.getSendMail());

        updateBackendApplicationDto.setMotive(updateBackendApplication.getMotive());
        updateBackendApplicationDto.setHardWork(updateBackendApplication.getHardWork());
        updateBackendApplicationDto.setKeyWord(updateBackendApplication.getKeyWord());
        updateBackendApplicationDto.setMostDeeplyWork(updateBackendApplication.getMostDeeplyWork());

        updateBackendApplicationDto.setPassOrNot(updateBackendApplication.getPassOrNot());

        updateBackendApplicationDto.setDifficultAndOvercoming(updateBackendApplication.getDifficultAndOvercoming());
        updateBackendApplicationDto.setStudyFramework(updateBackendApplication.getStudyFramework());
        updateBackendApplicationDto.setImportantGroup(updateBackendApplication.getImportantGroup());

        return updateBackendApplicationDto;
    }

    @Override
    public void deleteBackendApplication(String sid) throws Exception {

        backendApplicationDAO.deleteBackendApplication(sid);

    }

    @Override
    public void changePossOrNot(String sid) throws Exception {
        backendApplicationDAO.changePassOrNot(sid);
    }

    @Override
    public void changeSendMail(String sid) throws Exception {
        backendApplicationDAO.changeSendMail(sid);
    }

    @Override
    public List<BackendApplication> getReturn(Boolean dir) {
        return backendApplicationDAO.getReturn(dir);
    }

    @Override
    public List<BackendApplication> getSubmissionApplications(Boolean dir) {
        return backendApplicationDAO.getSubmissionApplications(dir);
    }

    @Override
    public List<BackendApplication> getAllApplications() {
        return backendApplicationDAO.getAllApplication();
    }

    @Override
    public List<BackendApplication> getBackendApplicationWithPassOrNotAndSubmission(
            Boolean passOrNot, Boolean submission)
    {
        return backendApplicationDAO.getReturn(passOrNot).stream()
                .filter(submissionStatus -> submissionStatus.getSubmissionStatus().equals(submission))
                .collect(Collectors.toList());
    }
}
