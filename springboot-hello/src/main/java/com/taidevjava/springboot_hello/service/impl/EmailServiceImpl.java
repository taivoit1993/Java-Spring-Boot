package com.taidevjava.springboot_hello.service.impl;

import com.taidevjava.springboot_hello.entity.mail.EmailEntity;
import com.taidevjava.springboot_hello.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendSimpleMail(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getToEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getMessageBody());
        try {
            javaMailSender.send(message);
            return "Email sned successfuller";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendHtmlMail(EmailEntity email) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email.getToEmail());
            helper.setSubject(email.getSubject());
            helper.setText(email.getMessageBody(), true);
            javaMailSender.send(message);
            return "Email sned successfuller";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendAttachmentsMail(EmailEntity email) {
        return "";
    }
}
