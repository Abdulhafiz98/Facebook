import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dataBase.DataBase;
import model.Gender;
import model.User;
import serivice.ChatService;
import serivice.PostService;
import serivice.UserService;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserService userService = new UserService();
    static String error = "Wrong choice, please try again.";
    public static void main(String[] args) {
        File file  = new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\users\\UsersJson.json");
        File file1 = new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\chats\\chatJson.json");
        File file2 = new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\posts\\postJson.json");
        if(file.exists()){
            DataBase.readJsonUsersFilesIfExist(file);
        }
        if(file1.exists()){
            DataBase.readJsonChatsFilesIfExist(file1);
        }
        if(file2.exists()){
            DataBase.readJsonPostsFilesIfExist(file2);
        }


        while (true) {
            System.out.print("1 => Sign up\n2 => Sign in\n0 => Stop the program\n>>>");
            int var1 = scannerInt.nextInt();
            switch (var1){
                case 1 -> signUp();
                case 2 -> signIn();
                case 0 -> {return;}
                default -> System.out.println(error);
            }
        }
    }
    public static void signUp(){
        System.out.print("Insert a first name: ");
        String firstName = scannerStr.nextLine();
        System.out.print("Insert a last name: ");
        String sureName = scannerStr.nextLine();
        System.out.print("Insert email address: ");
        String email = scannerStr.nextLine();
        if(!userService.checkEmail(email)){
            return;
        }
        System.out.print("Create strong password: ");
        String password = scannerStr.nextLine();
        System.out.print("Year of birth: ");
        int year = scannerInt.nextInt();
        System.out.print("Month of birth (January): ");
        String month = scannerStr.nextLine();
        System.out.print("Day of birth: ");
        int day = scannerInt.nextInt();
        System.out.println("1 => "+Gender.MALE.name()+"\n2 => "+Gender.FEMALE.name());
        System.out.println("Choose the gender: ");
        Gender gender = null;
        if(scannerInt.nextInt()==1){
            gender = Gender.MALE;
        } else{
            gender = Gender.FEMALE;
        }
        User user1 = userService.signUp("",sureName,firstName,password,email,month,gender,day,year,"", true);
        if(user1!=null){
            menu(user1);
        }else{
            System.out.println("Something went wrong, please try again");
        }
    }

    public static void signIn(){
        System.out.print("Insert email address: ");
        String email = scannerStr.nextLine();
        if(!userService.checkEmail(email)){
            return;
        }
        System.out.print("Create strong password: ");
        String password = scannerStr.nextLine();
        User user = userService.signIn(email,password);
        if(user!=null){
            menu(user);
        }else{
            System.out.println("Something went wrong, please try again");
        }

    }

    public static void menu(User user){
        while (true){
            System.out.print("1 => \uD83C\uDFE0 Home\n2 => \uD83D\uDC6C Friends\n3 => \uD83D\uDD14 Notifications\n4 => \uD83D\uDCCB Menu\n0 => \uD83D\uDEAA Back\n>>>");
            int var = scannerInt.nextInt();
            switch (var){
                case 1 ->{ //home
                }
                case 2 ->{
                    // friends
                }
                case 3 ->{
                    // noticfications
                }
                case 4 ->{
                    // homeMenu
                }
                case 0 ->{return;}
                default -> System.out.println(error);
            }
        }
    }
}
