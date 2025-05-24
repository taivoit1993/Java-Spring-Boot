package com.taidevjava.springboot_hello.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taidevjava.springboot_hello.entity.mail.EmailEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {
    @Autowired
    private EmailService emailService;

    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "otp-auth-topic", groupId = "otp-group-id")
    private void listenOTP(String message) {
        System.out.println(message);
        try{
            JsonNode jsonNode = objectMapper.readTree(message);
            /**
             * jsonNode
             * email
             * otp
             */
            String email = jsonNode.get("email").asText();
            String otp = jsonNode.get("otp").asText();
            log.info("otp is {} and email is {}", otp, email);
            EmailEntity emailEntity = new EmailEntity();
            emailEntity.setToEmail(email);
            emailEntity.setSubject("OTP Verify");
            emailEntity.setMessageBody(otp);
            String result = emailService.sendSimpleMail(emailEntity);
            log.info("OTP verify email is {}", result);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
