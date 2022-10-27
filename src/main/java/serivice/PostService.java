package serivice;

import dataBase.Colors;
import dataBase.DataBase;
import model.Post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class PostService {
    public boolean addPost(int userId,String text, String date)  {
        Post post=new Post();
        post.setText(text);
        post.setUserId(userId);
        post.setDate(date);
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
                System.out.println(DataBase.ALL_POSTS_LIST.get(i).getUserId());
                System.out.println(DataBase.ALL_POSTS_LIST.get(i).getDate());
            }
        }
    }

    private String addPostTime(String text){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        LocalTime localTime = LocalTime.now();
        return text+" \n|"+ Colors.YELLOW.getColorCode()+simpleDateFormat.format(localTime);
    }
}
