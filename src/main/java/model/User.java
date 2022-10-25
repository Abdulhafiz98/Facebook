package model;

import base.Base;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User extends Base {

    private String userName;
    private String sureName;
    private String firstName;
    private String password;
    private String email;
    private String monthOfBirth;
    private int birtDay;
    private int yearOfBirth;
    private String gender;



}
