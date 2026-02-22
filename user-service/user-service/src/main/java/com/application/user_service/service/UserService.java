package com.application.user_service.service;

import com.application.user_service.dto.UserRequestDTO;
import com.application.user_service.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    UserResponseDTO addUser(UserRequestDTO dto);
    UserResponseDTO getById(Long id);
}
