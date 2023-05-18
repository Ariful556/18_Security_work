package com.example.main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserRequestModel
{
    private  String firstname;
    private  String lastname;
    private  String role;
    private  String email;
    private  String password;
    private  String address;
}