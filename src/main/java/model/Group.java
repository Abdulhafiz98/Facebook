package model;

import base.Base;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@ToString(callSuper = true)
@Setter
@Getter
public class Group extends Base {
    private String name;
    private int adminId;
    List<Integer> users=new ArrayList<>();
    List<String>chats=new ArrayList<>();
}
