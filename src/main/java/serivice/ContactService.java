package serivice;
import model.Contact;
import serivice.baseService.BaseService;
import java.util.ArrayList;
import java.util.List;


public class ContactService implements BaseService {
    public List<Contact> contacts = new ArrayList<>();

    @Override
    public boolean add(Object o) {
        String name = (String) o;
        if (searchContact(name)){

        }
        return true;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    public boolean searchContact(String nameOrUsername){

    }
}
