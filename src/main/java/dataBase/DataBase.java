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
    public static List<Post> ALL_POSTS = new ArrayList<>();

    public static void saveUserToDataBase(User user) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
    private static void fileWriter(File file,String str) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    public static List<User> checkJsonFile(File file) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if(file.exists()){
            return gson.fromJson(new FileReader(file),new TypeToken<List<User>>(){}.getType());
        }
        else{
            return null;
        }
    }
    

}
