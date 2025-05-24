package com.taidevjava.springboot_hello.service;

import com.taidevjava.springboot_hello.entity.mail.EmailEntity;

public interface EmailService {
    String sendSimpleMail(EmailEntity email);
    String sendHtmlMail(EmailEntity email);
    String sendAttachmentsMail(EmailEntity email);
}
