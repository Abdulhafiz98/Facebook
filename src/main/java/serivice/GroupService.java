package serivice;

import model.Group;
import model.User;
import serivice.baseService.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupService implements BaseService {
    List<Group>groups=new ArrayList<>();


    public boolean createGroup(String name,int adminId){
        Group group=new Group();
        group.setName(name);
        group.setAdminId(adminId);
        return true;
    }
    @Override
    public boolean add(Object o,int groupId) {
        User user=(User)o;
        for (Group g : groups) {
            if (g!=null){
                if (g.getId()==groupId){
                    g.getUsers().add(user.getId());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int groupId) {
        return groups.get(groupId);
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean deleteById(int groupId) {
        for (Group g:groups) {
            if (g!=null){
                if(g.getId()==groupId){
                    groups.remove(g);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteUserFromGroup(User user,int groupId){
        for (Group g:groups) {
            if (g!=null){
                if (g.getId()==groupId){
                    if (!(g.getUsers().contains(user))) {
                        return false;
                    }
                    g.getUsers().remove(user);
                    return true;
                }
            }
        }
        return false;
    }
    public void groupChat(int groupId,int userId){
        Group group=groups.get(groupId);
        showGroupChat(group);
        String chat="";
        while (true){
            chat=new Scanner(System.in).nextLine();
            if (chat.equals("/exit")){
                break;
            }
            group.getChats().add(userId+": "+chat);
        }

    }
    public void showGroupChat(Group group){
        for (String s:group.getChats()) {
            System.out.println(s);
        }
    }
    public void showGroupByUser(int userId){
        for (Group group:groups) {
            if (group.getUsers().contains(userId)) {
                System.out.println(group.getName());
            }
        }
    }
}
