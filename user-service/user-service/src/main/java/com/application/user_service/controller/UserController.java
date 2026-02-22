package com.application.user_service.controller;


import com.application.user_service.dto.UserRequestDTO;
import com.application.user_service.dto.UserResponseDTO;
import com.application.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping
    public UserResponseDTO addUser(@RequestBody UserRequestDTO dto){
        return service.addUser(dto);
    }
    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

}
