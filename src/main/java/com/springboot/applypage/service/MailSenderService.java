package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.AcceptEmailDto;

import javax.mail.MessagingException;
import java.util.List;

public interface MailSenderService {
    public void sendAcceptMail(List<AcceptEmailDto> acceptEmailDto) throws MessagingException;
}
