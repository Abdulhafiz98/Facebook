package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Chat extends Base {

    public List<String > messageList = new ArrayList<>();

    private User sender;
    private User receiver;

    public Chat(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
