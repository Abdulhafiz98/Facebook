package model;


import base.Base;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

public class Post extends Base {

    private int userId;
    private String text;
}

