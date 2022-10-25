package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class User extends Base {

    private String userName;
    private String sureName;
    private String firstName;
    private String password;
    private String email;
    private String monthOfBirth;
    private int birtDay;
    private int yearOfBirth;
    private Gender gender;
    private String phoneNumber;
    private String isInActive;



}
