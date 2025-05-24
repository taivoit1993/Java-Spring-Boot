package com.taidevjava.springboot_hello;

import com.taidevjava.springboot_hello.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {
    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendEmailTextTest() {
        String email = "taivo.mile@gmail.com";
        String subject = "Test Email Sender";
        String content = "This is a test email";
        emailSenderUtil.sendTextMail(email, subject, content);
    }

    @Test
    void sendEmailHtmlTest() throws IOException {
        String email = "taivo.mile@gmail.com";
        String subject = "Test Email Sender";

        Resource resource = new ClassPathResource("/template/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendHtmlMail(email, subject, htmlContent);
    }
}
