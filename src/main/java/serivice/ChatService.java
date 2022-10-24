package serivice;

import model.Chat;
import model.User;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatService {
    List<Chat> chatMessageList = new ArrayList<>();


    public void sendMessage(User sender, User receiver, String message){
        Chat chat = new Chat(sender,receiver);
        chat.getMessageList().add(sender.getFirstName()+": "+getMessageTime(message));
    }
    public String getMessageTime(String message){
        LocalTime localTime = LocalTime.now();
        return message+". |"+localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

}
