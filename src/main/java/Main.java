import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dataBase.Colors;
import dataBase.DataBase;
import model.Gender;
import model.User;
import serivice.ChatService;
import serivice.ContactService;
import serivice.PostService;
import serivice.UserService;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserService userService = new UserService();
    static PostService postService = new PostService();
    static ContactService contactService = new ContactService();
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
        System.out.print("Insert the password: ");
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
                case 1 -> home();
                case 2 -> friends(user);
                case 3 ->{
                    notification(user);
                }
                case 4 -> homeMenu(user);
                case 0 ->{return;}
                default -> System.out.println(error);
            }
        }
    }

    public static void home(){
        postService.showAllAvailablePosts();
    }
    public static void homeMenu(User user){
        while (true) {
            System.out.println("1 => Add post\n2 => Settings\n3 => Personal information\n0 => Back");
            int var = scannerInt.nextInt();
            switch (var) {
                case 1 -> addPost(user);
                case 2 -> settings(user);
                case 3 -> personalInfo(user);
                case 0 -> {
                    return;
                }
                default -> System.out.println(error);
            }
        }
    }

    public static void addPost(User user){
        if(user!=null) {
            System.out.print("What's on your mind ?\nInsert text for post >>>");
            String text = scannerStr.nextLine();
            postService.addPost(user, text);
        }else {
            throw new NullPointerException();
        }

    }
    public static void settings(User user){
        while (true){
            System.out.println("1 => Edit personal information\n2 => Friends\n3 => User's posts\n0 => Back");
            int var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    System.out.print("Insert new first name: ");
                    String firstName = scannerStr.nextLine();
                    System.out.print("Insert new last name: ");
                    String lastName = scannerStr.nextLine();
                    System.out.print("Inset new username: ");
                    String userName = scannerStr.nextLine();
                    System.out.print("Inset new phone number: ");
                    String phoneNubmer = scannerStr.nextLine();
                    System.out.print("Inset new password: ");
                    String password = scannerStr.nextLine();
                    if(userService.editPersonalDetails(userName,lastName,firstName,phoneNubmer,password)){
                        System.out.println("Account info has been change successfully.");
                    }else {
                        System.out.println("Something went wrong please try again !!!");
                    }
                }
                case 2-> friends(user);
                case 3-> postService.showUsersPostOnly(user.getId());
                case 0->{return;}
                default -> System.out.println(error);
            }
        }
    }
    public static void personalInfo(User user){
        userService.showPersonalInfo(user);
        postService.showUsersPostOnly(user.getId());
    }
    public static void friends(User user){
        while (true){
            System.out.println("1 => Contact list\n2 => Add contact\n3 => Delete contact\n0 => Back");
            int var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    if(user.getContactList().isEmpty()){
                        System.out.println("You do not have any contact yet !!!");
                        continue;
                    }
                    contactService.allContacts(user);
                }
                case 2->{
                    System.out.print("Insert name: ");
                    String name = scannerStr.nextLine();
                    System.out.print("Insert last name: ");
                    String lastName = scannerStr.nextLine();
                    for (User user1 : DataBase.USERS_LIST) {
                        if(name.equals(user1.getFirstName())&&lastName.equals(user1.getSureName())){
                            System.out.println(user1.getFirstName()+" "+user1.getSureName());
                            System.out.println("1 => Add user to your contact\n0 => Back");
                            int var1 = scannerInt.nextInt();
                            if(var1==1){
                                contactService.addToContact(user,user1,"Friend request");
                            }
                        }
                    }
                }
                case 3 ->{
                    for (User user1 : user.getContactList()) {
                        System.out.println(user1.getId()+" "+user1.getFirstName()+" "+user1.getSureName());
                    }
                    System.out.print("Insert id of user which you want to delete from your contact: ");
                    int id = scannerInt.nextInt();
                    contactService.deleteContactById(id,user);
                }
                case 0->{return;}
                default -> System.out.println(error);
            }
        }


    }
    public static void notification(User user){
        for (User user1 : user.getNotification().keySet()) {
            System.out.println(Colors.GREEN.getColorCode()+"New notification"+Colors.RESET.getColorCode()+"");
            System.out.println(Colors.YELLOW.getColorCode()+user1.getFirstName()+" "+user1.getSureName()+Colors.RESET.getColorCode()+"");
            if(user.getNotification().get(user1).equals("Friend request")){
                System.out.println("sent friend request");
                System.out.print("1 => Accept\t2 => Cancel\n>>>");
                int question = scannerInt.nextInt();
                if(question==2){
                    contactService.deleteContactById(user.getId(),user1);
                    System.out.println("Request canceled");
                }else{
                    System.out.println("Request accepted");
                }
                System.out.println();
            }else{
                System.out.println(Colors.YELLOW.getColorCode()+user1.getFirstName()+" "+user1.getSureName()+Colors.RESET.getColorCode());
                System.out.println("Added new Post");
                System.out.println();
            }
        }
    }

}
