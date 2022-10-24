package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User>users=new ArrayList<>();
    public User signUp(String userName,String surName,String firstName, String password ,String email,String dataOfBirth,String gender){
             User user=new User();
             user.setUserName(userName);


    }
}
