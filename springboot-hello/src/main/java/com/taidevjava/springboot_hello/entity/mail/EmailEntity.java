package com.taidevjava.springboot_hello.entity.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailEntity {
    private String toEmail;
    private String subject;
    private String messageBody;
    private String attachment;
}
