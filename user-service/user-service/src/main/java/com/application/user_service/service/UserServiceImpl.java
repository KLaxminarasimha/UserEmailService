package com.application.user_service.service;

import com.application.user_service.dto.UserRequestDTO;
import com.application.user_service.dto.UserResponseDTO;
import com.application.user_service.entity.User;
import com.application.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repo;
    @Override
    public UserResponseDTO addUser(UserRequestDTO dto) {
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setPhonenumber(dto.getPhonenumber());
        user.setEmail(dto.getEmail());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setPincode(dto.getPincode());
        User saved=repo.save(user);
        return new UserResponseDTO(
                saved.getId(),
                saved.getFirstname(),
                saved.getLastname(),
                saved.getPhonenumber(),
                saved.getEmail(),
                saved.getCity(),
                saved.getState(),
                saved.getPincode()

        );

    }

    @Override
    public UserResponseDTO getById(Long id) {
        User saved=repo.findById(id).orElseThrow();
        return new UserResponseDTO(
                saved.getId(),
                saved.getFirstname(),
                saved.getLastname(),
                saved.getPhonenumber(),
                saved.getEmail(),
                saved.getCity(),
                saved.getState(),
                saved.getPincode()

        );
    }
}
