package model;

import base.Base;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)

public class Chat extends Base {

    public List<String > messageList = new ArrayList<>();

    private User user1;
    private User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Chat() {
    }
}
