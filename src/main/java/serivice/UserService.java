package serivice;

import dataBase.DataBase;
import model.Gender;
import model.User;

import java.io.IOException;

public class UserService {
    public User signUp(String userName, String sureName, String firstName, String password , String email, String monthOfBirth , Gender gender, int birtDay, int yearOfBirth, String phoneNumber, boolean active){
        User user=new User(userName,sureName,firstName,password,email,monthOfBirth,birtDay,yearOfBirth,phoneNumber,gender,active);
        DataBase.USERS_LIST.add(user);
        try {
            DataBase.saveUserToDataBase(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User signIn(String email,String password){
        for (User user : DataBase.USERS_LIST) {
            if(user!=null){
                if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
                    return user;
                }
            }
        }
        return null;
    }

    public boolean checkEmail(String email){
        if(!(email.contains("@gmail")&&email.contains(".com"))){
            System.out.println("Invalid email address. Please try again");
            return false;
        }
        return true;
    }

    public boolean editPersonalDetails(String userName, String sureName, String firstName,  String phoneNumber,String  password) {
        for (User user : DataBase.USERS_LIST) {
            if (user != null) {
                System.out.println(user);
                user.setUserName(userName);
                user.setSureName(sureName);
                user.setFirstName(firstName);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                return true;
            }
        }
        return false;
    }
}
