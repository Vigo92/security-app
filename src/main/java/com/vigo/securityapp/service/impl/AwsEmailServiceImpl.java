package com.vigo.securityapp.service.impl;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.vigo.securityapp.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 27/10/2022
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class AwsEmailServiceImpl implements EmailService {


    @Value("email.register.subject:Confirm Your Email")
    private final String subject;

    @Value("email.register.from:hello@lazeapp.com")
    private final String emailFrom;

    @Value("email.register.from:Kindly click on the link below to confirm your account!")
    private final String textBody ;

    @Override
    public void sendMail(String to, String message) {
        try {
            AmazonSimpleEmailService amazonSimpleEmailService =
                    AmazonSimpleEmailServiceClientBuilder.standard()
                            .withRegion(Regions.US_EAST_2).build();
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(to))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content().withCharset(StandardCharsets.UTF_8.name())
                                            .withData(message))
                                    .withText(new Content()
                                            .withCharset(StandardCharsets.UTF_8.name()).
                                                    withData(textBody)))
                            .withSubject(new Content()
                                    .withCharset(StandardCharsets.UTF_8.name())
                                    .withData(subject)))
                    .withSource(emailFrom);
            amazonSimpleEmailService.sendEmail(request);
            log.info("Email Sent");
        } catch (Exception e) {
            log.error("Error sending email: ", e);
        }
    }
}
