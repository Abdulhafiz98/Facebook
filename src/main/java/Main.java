import model.Gender;
import model.User;
import serivice.ChatService;
import serivice.PostService;
import serivice.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserService userService = new UserService();
    public static void main(String[] args) {
        String error = "Wrong choice, please try again.";
        while (true) {
            System.out.println("1 => Sign up\n2 => Sign in\n0 => Stop the program");
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
            // menu
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
            // menu
        }else{
            System.out.println("Something went wrong, please try again");
        }

    }

    public static void menu(User user){
        while (true){
            System.out.println("1 => \uD83C\uDFE0 Home\n2 => \uD83D\uDC6C Friends\n3 => ");
        }
    }
}
