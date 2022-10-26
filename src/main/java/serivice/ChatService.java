package serivice;

import dataBase.DataBase;
import model.Chat;
import model.User;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatService {

    public void sendMessage(User sender, User receiver, String message){
        Chat chat = new Chat(sender,receiver);
        chat.getMessageList().add("\u001B[32m"+sender.getFirstName()+"\u001B[0m"+": "+getMessageTime(message));
        try {
            DataBase.saveChatToDataBase(chat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String getMessageTime(String message){
        LocalTime localTime = LocalTime.now();
        return message + ". |\u001B[33m" + localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
