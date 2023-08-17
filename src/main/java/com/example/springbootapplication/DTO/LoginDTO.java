package com.example.springbootapplication.DTO;
import lombok.Data;

@Data
public class LoginDTO {
    private String usernameOrEmail;
    private String password;
}