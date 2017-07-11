package com.springclass.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class MessageRestController {

    @Value("${user.role:noRole}")
    private String role;

    @Value("${message:Hello default message}")
    private String message;

    @Value("${name:Foo Bar}")
    private String name;


    @RequestMapping("/")
    public String home() {
        return "Spring Boot Cloud Configuration Client";
    }

    @RequestMapping("/message")
    public String getMessage() {
        return "/message: '" + this.message + "', role: '" + role + "', name: '" + name + "'";
    }

} // The End...