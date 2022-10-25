package serivice;


import dataBase.Lists;
import model.Gender;
import model.User;

public class UserService implements BaseService {

    public User signUp(String userName, String surName, String firstName, String password , String email, String monthOfBirth , Gender gender, int birtDay, int yearOfBirth,String phoneNumber,String isInActive){
             User user=new User(userName,surName,firstName,password,email,monthOfBirth,birtDay,yearOfBirth,gender,phoneNumber,isInActive);
        Lists.USERS_LIST.add(user);
        return user;
    }
    public User signIn(String email,String password){
        for (User user : Lists.USERS_LIST) {
            if(user!=null){
                if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
                    return user;
                }
            }

        }return null;

    }
    public boolean checkEmail(String email){
        if(email.contains("@")&&email.contains(".com")){
            return true;
        }else{
            return false;
        }
    }
public boolean editPersonalDetails(String userName, String surName, String firstName,  String phoneNumber,String  password){
    for (User user : Lists.USERS_LIST) {
        if(user!=null){
            System.out.println(user);
            user.setUserName(userName);
            user.setSureName(surName);
            user.setFirstName(firstName);
            user.setPhoneNumber(phoneNumber);
            user.setPassword(password);
            return true;
        }

    }return false;
}



    @Override
    public boolean add(Object o) {

        return false;
    }

    @Override
    public Object getById(int id) {
        for (User user : Lists.USERS_LIST) {
            if(user!=null){
                if(user.getId()==id){
                    return user;
                }
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        for (User user : Lists.USERS_LIST) {
            if(user!=null){
                if(user.getId()==id){
                    Lists.USERS_LIST.remove(user);
                    return true;
                }

            }

        }
        return false;
    }}

//public class UserService {
//
//
//}
