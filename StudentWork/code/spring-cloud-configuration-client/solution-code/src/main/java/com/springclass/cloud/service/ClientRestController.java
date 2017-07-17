package com.springclass.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author mickknutson
 *
 */

// LAB: Add Refresh scope and Rest Controller annotations:
@RefreshScope
@RestController
class ClientRestController {

    @Value("${user.role:noRole}")
    private String role;

    @Value("${message:Hello message}")
    private String message;

    @Value("${name:Foo Bar}")
    private String name;


    @RequestMapping("/")
    public String home() {
        return "Spring Boot Cloud Configuration Client";
    }

    /**
     * http://lcoalhost:8080/validate
     * 
     * @return
     */
    @RequestMapping("/validate")
    public String validateConfiguration() {
        return "/validate result: " 
        		+ "'role': '" + this.role + "'"
        		+ ", 'name': '" + this.name + "'"
        		+ ", 'message': '" + this.message + "'"
        		;
    }

} // The End...