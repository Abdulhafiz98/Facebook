package serivice;

import dataBase.Colors;
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
        chat.getMessageList().add(Colors.GREEN.getColorCode()+sender.getFirstName()+ Colors.RESET.getColorCode() +": "+getMessageTime(message));
        try {
            DataBase.saveChatToDataBase(chat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String getMessageTime(String message){
        LocalTime localTime = LocalTime.now();
        return message + " \n|"+Colors.YELLOW.getColorCode()+ localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
