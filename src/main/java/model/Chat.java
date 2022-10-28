package model;

import base.Base;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Chat extends Base {

    public List<String > messageList = new ArrayList<>();

    private User user1;
    private User user2;

}
