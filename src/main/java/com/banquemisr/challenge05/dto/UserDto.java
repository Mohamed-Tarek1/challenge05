package com.banquemisr.challenge05.dto;


import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String role;
}