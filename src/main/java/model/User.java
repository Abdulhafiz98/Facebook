package model;

import base.Base;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User extends Base {

    public  List<User> contacts = new ArrayList<>();
    private String userNameOrEmail;
    private String surName;
    private String firstName;
    private String password;
    private String dataOfBirth;
    private String gender;



}
