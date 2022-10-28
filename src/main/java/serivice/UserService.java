package serivice;
import data.DataBase;
import model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UserService extends DataBase {
    public User signUp(User user) {
        DataBase.USERS_LIST.add(user);
        try {
            DataBase.saveUserToDataBase(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User signIn(String email,String password) throws FileNotFoundException {
        for (User user : getUsersFromDataBase()) {
            if(user != null){
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

    public boolean editPersonalDetails(String userName, String surName, String firstName,  String phoneNumber,String  password) {
        for (User user : DataBase.USERS_LIST) {
            if (user != null) {
                System.out.println(user);
                user.setUserName(userName);
                user.setSurName(surName);
                user.setFirstName(firstName);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                return true;
            }
        }
        return false;
    }

    public  String emailAuthentication(String to){
        String password = String.valueOf((int)(Math.random() * 999999) + 6);

        String from = "abiyerovxojiakbar@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {

            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("abiyerovxojiakbar@gmail.com",
                        "zdksmbdesbhnijpm");
            }
        });

        session.setDebug(false);

        boolean response = false;

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Facebook_Support ");

            message.setText("Your Facebook authentication code is: "+password);

            System.out.println("sending...");

            Transport.send(message);
//            System.out.println("Sent message successfully....");
            response = true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        if (response) {
            return password;
        } else
            return null;
    }

    public User searchUserByName(String name) throws FileNotFoundException {
        List<User>users = getUsersFromDataBase();
        for (User user : users) {
            if (user.getUserName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}