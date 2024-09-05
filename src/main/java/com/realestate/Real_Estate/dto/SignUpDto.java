package com.realestate.Real_Estate.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String username;
    private String email;
    private String password;
    private int phoneNumber;

}