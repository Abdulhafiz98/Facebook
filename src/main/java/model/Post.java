package model;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post extends Base{
    List<User> likes = new ArrayList<>();
    HashMap<User,String> comments = new HashMap<>();

    private int userId;
    private String text;
    private String date;
}
