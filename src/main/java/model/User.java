package model;

import lombok.*;

import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends Base {
    List<User> contactList = new ArrayList<>();
    HashMap<User,String> notification = new HashMap<>();
    private String userName;
    private String sureName;
    private String firstName;
    private String password;
    private String email;
    private String monthOfBirth;
    private int birthDay;
    private int yearOfBirth;
    private String phoneNumber;
    private Gender gender;
    private boolean isInActive;

    public User(String userName, String sureName, String firstName, String password, String email, String monthOfBirth, int birthDay, int yearOfBirth, String phoneNumber, Gender gender,boolean active) {
        this.userName = userName;
        this.sureName = sureName;
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
