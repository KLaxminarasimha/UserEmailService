package com.application.email_service.service;

import com.application.email_service.dto.ResponseDTO;
import com.application.email_service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public ResponseDTO sendEmail(Long id) {

        UserDTO user = restTemplate.getForObject("http://user-service/users/"+id,UserDTO.class);

        if (user == null) {
            return new ResponseDTO("FAILED", "User not found");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return new ResponseDTO("FAILED", "User email missing");
        }


        String message = "Hi " + user.getFirstname() + ", your user is saved.";

        send(user.getEmail(), message);

        return new ResponseDTO("SUCCESS", "Email sent to " + user.getEmail());
    }
    private void send(String email, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("User Saved Notification");
        mail.setText(message);

        mailSender.send(mail);
        System.out.println("Sending email to: " + email);
        System.out.println("Message: " + message);

    }
}
