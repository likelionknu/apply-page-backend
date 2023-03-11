package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dto.AcceptEmailDto;
import com.springboot.applypage.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Random;

@Service
public class MailSenderServiceImpl implements MailSenderService
{

    private final JavaMailSender javaMailSender;
    private SpringTemplateEngine templateEngine;

    @Autowired
    public MailSenderServiceImpl(JavaMailSender javaMailSender, SpringTemplateEngine springTemplateEngine){
        this.javaMailSender = javaMailSender;
        this.templateEngine = springTemplateEngine;
    }

    public void sendAcceptMail(List<AcceptEmailDto> acceptEmailDto) throws MessagingException {

        for (AcceptEmailDto mailInfo:
                acceptEmailDto) {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(mailInfo.getEmail());
            helper.setSubject("강남대학교 멋쟁이사자처럼 서류전형 결과 공지");

            //템플릿에 전달할 데이터 설정
            Context context = new Context();
            context.setVariable("name", mailInfo.getName());
            context.setVariable("interviewDate", mailInfo.getInterviewDate());
            context.setVariable("interviewLocation", mailInfo.getInterviewLocation());
            context.setVariable("interviewTime", mailInfo.getInterviewTime());

            //메일 내용 설정 : 템플릿 프로세스
            String html = templateEngine.process("acceptEmail.html",context);
            helper.setText(html, true);

            //helper.addInline("image1", new ClassPathResource("templates/images/_.png"));
            //helper.addInline("image2", new ClassPathResource("templates/images/.jpg"));

            //메일 보내기
            javaMailSender.send(message);
        }
    }

    @Override
    public void sendFailMail(List<AcceptEmailDto> acceptEmailDto) throws MessagingException {
        for (AcceptEmailDto mailInfo:
                acceptEmailDto) {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(mailInfo.getEmail());
            helper.setSubject("강남대학교 멋쟁이사자처럼 서류전형 결과 공지");

            //템플릿에 전달할 데이터 설정
            Context context = new Context();
            context.setVariable("name", mailInfo.getName());

            //메일 내용 설정 : 템플릿 프로세스
            String html = templateEngine.process("failEmail.html",context);
            helper.setText(html, true);

            //helper.addInline("image1", new ClassPathResource("templates/images/_.png"));

            //메일 보내기
            javaMailSender.send(message);
        }
    }

    @Override
    public int sendVerificationMail(AcceptEmailDto acceptEmailDto) throws MessagingException {

        Integer verificationNum = getVerificationNumber();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(acceptEmailDto.getEmail());
        helper.setSubject("강남대학교 멋쟁이사자처럼 인증메일");

        //템플릿에 전달할 데이터 설정
        Context context = new Context();
        context.setVariable("name", verificationNum);

        //메일 내용 설정 : 템플릿 프로세스
        String html = templateEngine.process("acceptEmail.html",context);
        helper.setText(html, true);

        //helper.addInline("image1", new ClassPathResource("templates/images/_.png"));
        //helper.addInline("image2", new ClassPathResource("templates/images/.jpg"));

        //메일 보내기
        javaMailSender.send(message);

        return verificationNum;
    }

    public Integer getVerificationNumber() {
        // 난수의 범위 111111 ~ 999999 (6자리 난수)
        Random r = new Random();
        Integer checkNum = r.nextInt(888888) + 111111;
        System.out.println("인증번호 : " + checkNum);

        return checkNum;
    }
}
