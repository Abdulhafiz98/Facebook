import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import constants.Constants;
import data.DataBase;
import lombok.ToString;
import model.Gender;
import model.User;
import org.apache.http.annotation.Contract;
import serivice.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


@ToString
@Contract

public class Main extends DataBase implements Constants {
    static User currentUser = null;
    static UserService userService = new UserService();
    static Scanner SCANNER_INT = new Scanner(System.in);
    static Scanner SCANNER_STR = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Phone : ");
        String phone =SCANNER_STR.nextLine();
        System.out.println(phoneConfirmation(phone));
        mainMenu();

    }

    private static void mainMenu() throws IOException {
        while (true) {
            System.out.println(SIGN_UP + "\n" + SIGN_IN + "\n" + EXIT_PROGRAM);
            System.out.print("Please enter.. :");
            int var1 = SCANNER_INT.nextInt();
            switch (var1) {
                case 1 -> signUp();
                case 2 -> signIn();
                case 0 -> {
                    return;
                }
                default -> System.out.println(WRONG_CHOICE);
            }
        }
    }

    private static void signUp() throws IOException {
        System.out.print("Enter a first name: ");
        String firstName = SCANNER_STR.nextLine();
        System.out.print("Enter a last name: ");
        String surName = SCANNER_STR.nextLine();
        System.out.print("Enter email address\uD83D\uDCEC: ");
        String email = SCANNER_STR.nextLine();
        if (!userService.checkEmail(email)) {
            return;
        }
        System.out.print("Enter new password: ");
        String password = SCANNER_STR.nextLine();
        System.out.print("Year of birth: ");
        int year = SCANNER_INT.nextInt();
        System.out.print("Month of birth (January): ");
        String month = SCANNER_STR.nextLine();
        System.out.print("Day of birth: ");
        int day = SCANNER_INT.nextInt();
        System.out.println("1 => " + Gender.Male.name() + "\n2 => " + Gender.Female.name());
        System.out.println("Choose the gender: ");
        Gender gender;
        if (SCANNER_INT.nextInt() == 1) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        String pass = String.valueOf(userService.emailAuthentication(email));
        if (pass != null) {
            System.out.println(" We send password to your gmail address \uD83D\uDCEC ");
        }
        String pasEmail = null;
        boolean flag = false;
        while (flag != true) {
            System.out.print(" Insert password from your email address : ");
            pasEmail = SCANNER_STR.nextLine();
            if (pass.equals(pasEmail) || pass.equals("0")) {
                flag = true;
            } else System.out.println(" Wrong password ");
        }
        if (pasEmail.equals(pass)) {
            User user = new User();
            user.setFirstName(firstName);
            user.setSurName(surName);
            user.setEmail(email);
            user.setPassword(password);
            user.setYearOfBirth(year);
            user.setMonthOfBirth(month);
            user.setBirthDay(day);
            user.setGender(gender);
            currentUser = userService.signUp(user);
            System.out.println(" Profile created successfully ");
            userMenu();
        } else System.err.println(" Invalid password ");
    }

    private static String phoneConfirmation(String phonNumber) throws ApiException {
        String phPas= String.valueOf((int) (Math.random() * 999999) + 6);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phonNumber),
                        new com.twilio.type.PhoneNumber("+14632383658"),
                        " Password for facebook : " + phPas)
                .create();
        Message.Status status = message.getStatus();
        String statusr = status.toString();
        System.out.println(statusr);
        System.out.println(message.getSid());
        return phPas;
    }

    private static void signIn() throws FileNotFoundException {
        System.out.print("Enter email address \uD83D\uDCEC: ");
        String email = SCANNER_STR.nextLine();
        if (!userService.checkEmail(email)) {
            return;
        }
        System.out.print("Enter your password : ");
        String password = SCANNER_STR.nextLine();
        User user = userService.signIn(email, password);
        if (user != null) {
            userMenu();
        } else {
            System.out.println(Constants.WRONG);
        }

    }

    private static void userMenu() throws FileNotFoundException {
        int num = 10;
        while (num != 0) {
            System.out.println("\n\n\t\t  FACEBOOK ");
            System.out.println(SEARCH);
            System.out.println(GROUPS);
            System.out.println(CONTACTS);
            System.out.println(CHAT);
            System.out.println(PROFILE);
            System.out.println("Choose.. ");
            num = SCANNER_INT.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println(" Enter name : ");
                    String name = SCANNER_STR.nextLine();
                    User user = userService.searchUserByName(name);
                    System.out.println(" \t\t User  ");
                    System.out.println(" User Name : " + user.getUserName());
                    System.out.println(" Surname : " + user.getSurName());
                    System.out.println(" First Name : " + user.getFirstName());
                }
                case 2 -> {
                    int n = 10;
                    while (n != 0) {
                        System.out.println("1.Create Group  2.Edit Group 3. Delete Group 4.ADD Friend to Group ");
                        n = SCANNER_STR.nextInt();
                        switch (n) {
                            case 1 -> {
                                System.out.println(" Enter Group Name: ");
                                String groupName = SCANNER_STR.nextLine();

                            }
                        }
                    }
                }
                case 5 -> {
                    int n = 10;
                    while (n != 0) {
                        System.out.println("1. Edit User ");
                        n = SCANNER_STR.nextInt();
                        switch (n) {
                            case 1 -> {
                                System.out.println(" Enter password : ");
                                String password = SCANNER_STR.nextLine();
                                System.out.println(" Enter User Name: ");
                                String userName = SCANNER_STR.nextLine();
                                System.out.println(" Enter First Name: ");
                                String firstName = SCANNER_STR.nextLine();
                                System.out.println(" Enter Last Name: ");
                                String lastName = SCANNER_STR.nextLine();
                                System.out.println(" Enter Email: ");
                                String email = SCANNER_STR.nextLine();
                                System.out.println(" Enter Password: ");
                                String newPas = SCANNER_STR.nextLine();
                                System.out.println(" Add phone number: ");
                                String phone = SCANNER_STR.nextLine();
                                String pas = String.valueOf(phoneConfirmation(phone));
                                System.out.println("Enter password: ");
                                String pasEnt = SCANNER_STR.nextLine();
                                if (pas.equals(password)){
                                    System.out.println("Success");
                                }

                                userService.editPersonalDetails(password,userName,lastName,firstName,phone,newPas);

                            }
                        }
                    }
                }
            }

        }
    }
}
