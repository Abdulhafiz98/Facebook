package serivice;

import data.DataBase;
import model.Group;
import model.User;
import serivice.baseService.BaseService;

import java.io.IOException;
import java.util.Scanner;

public class GroupService extends DataBase implements BaseService {

    public boolean createGroup(String name,int adminId) throws IOException {
        Group group = new Group();
        group.setName(name);
        group.setAdminId(adminId);
        saveGroupToDataBase(group);
        return true;
    }
    @Override
    public boolean add(Object o, int groupId) {
        User user=(User)o;
        for (Group g : DataBase.ALL_GROUPS_LIST) {
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
        return DataBase.ALL_GROUPS_LIST.get(groupId);
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public int getById(Object o) {
        return 0;
    }

    @Override
    public boolean deleteById(Object o) {
        return false;
    }

    @Override
    public boolean deleteById(int groupId) {
        for (Group g:DataBase.ALL_GROUPS_LIST) {
            if (g!=null){
                if(g.getId()==groupId){
                    DataBase.ALL_GROUPS_LIST.remove(g);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteUserFromGroup(User user,int groupId){
        for (Group g:DataBase.ALL_GROUPS_LIST) {
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
    public void groupPost(int groupId, int userId, String text){
        Group group= DataBase.ALL_GROUPS_LIST.get(groupId);
        showGroupPost(group);
        String post="";
        while (true){
            post=new Scanner(System.in).nextLine();
            if (post.equals("/exit")){
                break;
            }
            group.getPost().add(userId+": "+post);
        }

    }
    public void showGroupPost(Group group){
        for (String s:group.getPost()) {
            System.out.println(s);
        }
    }
    public void showGroupByUser(int userId){
        for (Group group:DataBase.ALL_GROUPS_LIST) {
            if (group.getUsers().contains(userId)) {
                System.out.println(group.getName());
            }
        }
    }
//    private String addPostTime(String text){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
//        LocalTime localTime = LocalTime.now();
//        return text+" \n|"+ Colors.YELLOW.getColorCode()+simpleDateFormat.format(localTime);
//    }
}
