package com.example.springbootapplication.DTO;
import lombok.Data;

@Data
public class SignupDTO{
    private String name;
    private String username;
    private String email;
    private String password;
}