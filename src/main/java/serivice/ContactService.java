package serivice;
import model.User;
import serivice.baseService.BaseService;
import java.util.ArrayList;
import java.util.List;


public class ContactService implements BaseService {
    public List<User> contacts = new ArrayList<>();

    @Override
    public boolean add(Object o) {
        User contact = (User)o;
        contacts.add(contact);
        return true;
    }

    @Override
    public Object getById(int id) {
            for (User contact : contacts){
                if (contact != null) {
                    if (contact.getId() == id) {
                        return contact;
                    }
                }
            }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        for (User contact : contacts){
            if(contact != null) {
                if (contact.getId() == id) {
                    contacts.remove(contact);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchContact(String nameOrUsername){
        for (User contact : contacts){
            if (contact.getFirstName().equals(nameOrUsername)) {
                return true;
            }
        }
        return false;
    }
}
