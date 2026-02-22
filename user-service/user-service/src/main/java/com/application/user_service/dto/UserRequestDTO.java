package com.application.user_service.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String firstname;
    private String lastname;
    private Long phonenumber;
    private String email;
    private String city;
    private String state;
    private String pincode;
}
