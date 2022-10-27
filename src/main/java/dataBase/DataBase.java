package dataBase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Chat;
import model.Post;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DataBase {
    public static List<User> USERS_LIST = new ArrayList<>();
    public static List<List<Chat>> ALL_CHAT_LIST = new ArrayList<>();
    public static List<Post> ALL_POSTS_LIST = new ArrayList<>();

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveUserToDataBase(User user) throws IOException {

        File file = new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\users\\UsersJson.json");
        if(file.createNewFile()){
            String str = "[" + gson.toJson(user) + "]"; // agar shunday save qilinmasa kegn oqiy olmaydi;
            fileWriter(file,str);
        }else{
            List<User> users = gson.fromJson(new FileReader(file),new TypeToken<List<User>>(){}.getType());
            users.add(user);
            fileWriter(file, gson.toJson(users));
        }
    }

    public static void saveChatToDataBase(Chat chat) throws IOException {
        File file = new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\chats\\chatJson.json");
        if(file.createNewFile()){
            String str ="["+gson.toJson(chat)+"]";
            fileWriter(file,str);
        }else {
            List<Chat> chats = gson.fromJson(new FileReader(file), new TypeToken<List<Chat>>(){}.getType());
            chats.add(chat);
            fileWriter(file, gson.toJson(chats));
        }
    }
    public static void savePostToDataBase(Post post) throws IOException {
        File file=new File("F:\\Java lessons\\Facebook\\src\\main\\resources\\posts\\postJson.json");
        if(file.createNewFile()){
            String str = "["+gson.toJson(post)+"]";
            fileWriter(file,str);
        }else{
            List<Post> posts = gson.fromJson(new FileReader(file), new TypeToken<List<Post>>(){}.getType());
            posts.add(post);
            fileWriter(file, gson.toJson(posts));
        }
    }
    private static void fileWriter(File file,String str) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    public static List<User> checkJsonFile(File file) throws FileNotFoundException {
        if(file.exists()){
            return gson.fromJson(new FileReader(file),new TypeToken<List<User>>(){}.getType());
        }
        else{
            return null;
        }
    }

    public static void readJsonUsersFilesIfExist(File file){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            USERS_LIST = gson.fromJson(bufferedReader,new TypeToken<List<User>>(){}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readJsonChatsFilesIfExist(File file){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ALL_CHAT_LIST = gson.fromJson(bufferedReader,new TypeToken<List<Chat>>(){}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readJsonPostsFilesIfExist(File file){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ALL_POSTS_LIST = gson.fromJson(bufferedReader,new TypeToken<List<Chat>>(){}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
