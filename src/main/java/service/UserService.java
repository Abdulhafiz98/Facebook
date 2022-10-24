package service;

import dataBase.Lists;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService  {

    public User signUp(String userName,String surName,String firstName, String password ,String email,String monthOfBirth ,String gender,int birtDay,int yearOfBirth){
             User user=new User();
             user.setUserName(userName);
             user.setFirstName(firstName);
             user.setPassword(password);
             user.setSureName(surName);
             user.setBirtDay(birtDay);
             user.setMonthOfBirth(monthOfBirth);
             user.setYearOfBirth(yearOfBirth);
             user.setGender(gender);
             user.setEmail(email);
        Lists.USERS_LIST.add(user);
        return user;
    }
}
