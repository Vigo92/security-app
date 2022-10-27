package com.vigo.securityapp.service.impl;

import com.vigo.securityapp.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 27/10/2022
 **/


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {


    private final JavaMailSender javaMailSender;

    @Value("email.register.subject:Confirm Your Email")
    private final String subject;

    @Value("email.register.from:hello@lazeapp.com")
    private final String emailFrom;

    @Override
    @Async
    public void sendMail(String to, String message) {
        try{
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, StandardCharsets.UTF_8.name());
            mimeMessageHelper.setText(message,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(emailFrom);
            javaMailSender.send(mimeMailMessage);
        }
        catch (MessagingException e){
            log.error("Failed to send email", e);
        }
    }
}
