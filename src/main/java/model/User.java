package model;

import base.Base;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User extends Base {

    private String userNameOrEmail;
    private String surName;
    private String firstName;
    private String password;
    private String dataOfBirth;
    private String gender;



}
