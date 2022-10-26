package serivice;
<<<<<<< HEAD
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
=======

import model.User;

public class ContactService {

    public User getContactById(int contactId, User owner) {
        if (owner.getContactList() != null) {
            for (User contact : owner.getContactList()) {
                if (contact.getId() == contactId) {
                    return contact;
                }
            }
        }
        return null;
    }

    public void deleteContactById(int contactId, User owner) {
        if (owner.getContactList() != null) {
            for (User contact : owner.getContactList()) {
                if (contact.getId() == contactId) {
                    owner.getContactList().remove(contact);
                    System.out.println(" user has been removed successfully");
                } else System.out.println("\t\t user has not been found !!! ");
            }
        }
    }

    public void allContacts(User owner) {
        if (owner.getContactList() != null) {
            System.out.println("\t\t  *** Friends *** " + "\n");
            for (User contact : owner.getContactList()) {
                System.out.println(contact.toString());
            }
        }
    }

    public void addToContact(User owner, User contactUser) {
        if (owner != null) {
            owner.getContactList().add(contactUser);
            System.out.println(" \t\t *** Add to friend ");
        }
>>>>>>> origin/master
    }
}
