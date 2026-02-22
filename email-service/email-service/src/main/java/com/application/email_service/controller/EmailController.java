package com.application.email_service.controller;

import com.application.email_service.dto.ResponseDTO;
import com.application.email_service.dto.UserDTO;
import com.application.email_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/{id}")
    public ResponseDTO sendEmail(@PathVariable Long id) {
        return service.sendEmail(id);
    }
}
