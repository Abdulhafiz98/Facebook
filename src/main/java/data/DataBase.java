package data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.ToString;
import model.Chat;
import model.Group;
import model.Post;
import model.User;
import org.jetbrains.annotations.Unmodifiable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@ToString
public abstract class DataBase {
    public static List<User> USERS_LIST = new ArrayList<>();
    public static List<List<Chat>> ALL_CHAT_LIST = new ArrayList<>();
    public static List<Post> ALL_POSTS = new ArrayList<>();
    public static List<Group> ALL_GROUPS_LIST = new ArrayList<>();

    public static void savePostToDataBase(Post post) throws IOException {
        File file=new File("src\\main\\java\\resources\\GroupsJson.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if(file.createNewFile()){
            String str = "["+gson.toJson(post)+"]";
            fileWriter(file,str);
        }else{
            List<Post> posts = gson.fromJson(new FileReader(file), new TypeToken<List<Post>>(){}.getType());
            posts.add(post);
            fileWriter(file, gson.toJson(posts));
        }
    }

    public static void readJsonGroupsFilesIfExist(File file){
        Gson gson = new Gson();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ALL_GROUPS_LIST = gson.fromJson(bufferedReader,new TypeToken<List<Chat>>(){}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public static void saveGroupToDataBase(Group group) throws IOException {
        File file = new File("src\\main\\java\\resources\\GroupsJson.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if(file.createNewFile()){
            String str ="["+gson.toJson(group)+"]";
            fileWriter(file,str);
        }else {
            List<Group> groups = gson.fromJson(new FileReader(file), new TypeToken<List<Group>>(){}.getType());
            groups.add(group);
            fileWriter(file, gson.toJson(groups));
        }
    }
    @Unmodifiable
    public static List<User> returnUserListFromJson() throws FileNotFoundException {
        File file = new File("src\\main\\java\\resources\\UsersJson.json");
        Reader reader = new FileReader(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return List.of(gson.fromJson(reader, User[].class));
    }

    public List<User> getUsersFromDataBase() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(new FileReader("src\\main\\java\\resources\\UsersJson.json"),
                new TypeToken<List<User>>(){}.getType());

    }

    public static void saveUserToDataBase(User user) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("src\\main\\java\\resources\\UsersJson.json");
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
        File file = new File("src\\main\\java\\resources\\UsersJson.json");
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
