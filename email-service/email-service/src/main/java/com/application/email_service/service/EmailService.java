package com.application.email_service.service;

import com.application.email_service.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmailService {
    ResponseDTO sendEmail( Long id);
}
