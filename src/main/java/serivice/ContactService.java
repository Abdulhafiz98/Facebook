package serivice;
import serivice.baseService.BaseService;
import java.util.ArrayList;
import java.util.List;


public class ContactService implements BaseService {
    public List<Contact> contacts = new ArrayList<>();

    @Override
    public boolean add(Object o) {
        Contact contact = (Contact)o;
        contacts.add(contact);
        return true;
    }

    @Override
    public boolean add(Object o, int groupId) {
        return false;
    }

    @Override
    public Object getById(int id) {
            for (Contact contact : contacts){
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
        for (Contact contact : contacts){
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
        for (Contact contact : contacts){
            if (contact.getContactName().equals(nameOrUsername)) {
                return true;
            }
        }
        return false;
    }
}
