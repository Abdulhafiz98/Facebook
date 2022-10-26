package serivice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Post;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PostService {
    public boolean addPost(int userId,String text) throws IOException {
        Post post=new Post();
        post.setText(text);
        post.setUserId(userId);
        File file=new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\post"+userId+".txt");
        file.createNewFile();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String s=gson.toJson(post);
        byte[]bytes=s.getBytes();
        FileOutputStream fileOutputStream=new FileOutputStream(file, true);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        return true;
    }
}
