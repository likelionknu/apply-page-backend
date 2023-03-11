package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.AcceptEmailDto;

import javax.mail.MessagingException;
import java.util.List;

public interface MailSenderService {
    void sendAcceptMail(List<AcceptEmailDto> acceptEmailDto) throws MessagingException;
    void sendFailMail(List<AcceptEmailDto> acceptEmailDto) throws MessagingException;
    int sendVerificationMail(AcceptEmailDto acceptEmailDto) throws MessagingException;
}
