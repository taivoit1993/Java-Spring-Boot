package org.example.security.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mapping")
public class AdminController {

    @GetMapping("/vip")
    public String vipZone(){
        return "vip zone";
    }

    @GetMapping("/normal")
    public String normalZone(){
        return "normal zone";
    }
}
