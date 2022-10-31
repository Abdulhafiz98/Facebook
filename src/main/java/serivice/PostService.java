package serivice;

import dataBase.Colors;
import dataBase.DataBase;
import model.Post;
import model.User;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PostService {
    public boolean addPost(User user, String text)  {
        Post post=new Post();
        if (user != null) {
            post.setText(Colors.GREEN.getColorCode()+user.getFirstName()+Colors.RESET.getColorCode()+"\n"+addPostTime(text));
            post.setUserId(user.getId());
            for (User user1 : user.getContactList()) {
                user1.getNotification().put(user,"New post");
            }
        }else{
            throw new NullPointerException();
        }
        DataBase.ALL_POSTS_LIST.add(post);
        try {
            DataBase.savePostToDataBase(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public void showUsersPostOnly(int userId){
        for(int i=DataBase.ALL_POSTS_LIST.size()-1; i>=0; i--){
            if(DataBase.ALL_POSTS_LIST.get(i)!=null) {
                if (DataBase.ALL_POSTS_LIST.get(i).getUserId() == userId) {
                    System.out.println(DataBase.ALL_POSTS_LIST.get(i).getText());
                }
            }
        }
    }
    public void showAllAvailablePosts(){
        for(int i=DataBase.ALL_POSTS_LIST.size()-1; i>=0; i--){
            if(DataBase.ALL_POSTS_LIST.get(i)!=null){
                System.out.println(DataBase.ALL_POSTS_LIST.get(i).getText());
            }
        }
    }

    private String addPostTime(String text){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        return text+" \n|"+ Colors.YELLOW.getColorCode()+dateTimeFormatter.format(localDateTime)+Colors.RESET.getColorCode()+"";
    }
}
