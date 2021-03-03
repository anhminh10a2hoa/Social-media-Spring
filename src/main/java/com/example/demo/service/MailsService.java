package com.example.demo.service;

import com.example.demo.exception.MailSenderException;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class MailsService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    void sendMail(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("springreddit@email.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Account Activation");
            messageHelper.setText(mailContentBuilder.build(message));
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            throw new MailSenderException("Exception occurred when sending mail to " + recipient);
        }
    }

}