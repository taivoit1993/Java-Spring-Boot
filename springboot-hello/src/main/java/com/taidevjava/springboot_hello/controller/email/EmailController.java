package com.taidevjava.springboot_hello.controller.email;

import com.taidevjava.springboot_hello.entity.mail.EmailEntity;
import com.taidevjava.springboot_hello.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send_text")
    public String sendEmail(@RequestBody EmailEntity email) {
        return emailService.sendSimpleMail(email);
    }

    @PostMapping("/send_html")
    public String sendHtmlEmail(@RequestBody EmailEntity email) {
        return emailService.sendHtmlMail(email);
    }
}
