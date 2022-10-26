package model;

import base.Base;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class User extends Base {
    List<User> contactList = new ArrayList<>();
    private String userName;
    private String surName;
    private String firstName;
    private String password;
    private String email;
    private String monthOfBirth;
    private int birthDay;
    private int yearOfBirth;
    private String phoneNumber;
    private Gender gender;
    private boolean isInActive;

    public User(String userName, String surName, String firstName, String password, String email, String monthOfBirth, int birthDay, int yearOfBirth, String phoneNumber, Gender gender,boolean active) {
        this.userName = userName;
        this.surName = surName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.monthOfBirth = monthOfBirth;
        this.birthDay = birthDay;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.isInActive = active;
    }


}
