package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Group extends Base{
    private String name;
    private int adminId;
    List<Integer> users=new ArrayList<>();
    List<String>chats=new ArrayList<>();
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
