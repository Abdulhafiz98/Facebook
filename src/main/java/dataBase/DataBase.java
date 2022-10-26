package dataBase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Chat;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DataBase {
    public static List<User> USERS_LIST = new ArrayList<>();
    public static List<List<Chat>> ALL_CHAT_LIST = new ArrayList<>();

    public static void saveUserToDataBase(User user) throws IOException {
        Gson gson = new Gson();
        File file = new File("src/main/resources/UsersGson.json");
        if(file.createNewFile()){
            String str = gson.toJson(user);
            str = "[" + str + "]";  // agar shunday save qilinmasa kegn oqiy olmaydi;
            fileWriter(file,str);
        }else{
            List<User> users = gson.fromJson(new FileReader(file),new TypeToken<List<User>>(){}.getType());
            users.add(user);
            gson.toJson(users);
        }
    }
    private static void fileWriter(File file,String str) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    public List<User> checkJsonFile() throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File("src/main/resources/UsersGson.json");
        if(file.exists()){
            return gson.fromJson(new FileReader(file),new TypeToken<List<User>>(){}.getType());
        }
        else{
            return null;
        }
    }
    public void showUserDataBase(){

    }
}
