package serivice;

import model.User;
import serivice.baseService.BaseService;


// OVERRIDE QILINGAN METHODLAR MEINDA ISHLATILMASIN *****
// OVERRIDE QILINGAN METHODLAR MEINDA ISHLATILMASIN *****

public class ContactService implements BaseService {

    // ishlatilmidi
    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public Object getById(int id) {

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
    // shu yergacha


    public User getContactById(int contactId, User owner) {
        User contactr = null;
        try {
            if (owner.contacts != null) {
                for (User contact : owner.getContacts()) {
                    if (contact.getId() == contactId) {
                       contactr = contact;
                        return contact;
                    }
                }
            }
        }catch (Exception e) {
            System.out.println(" No Friends ");
        }
        return contactr;
    }

    public void deleteContactById(int contactId, User owner) {
        try {
            if (owner.getContacts() != null) {
                for (User contact : owner.getContacts()) {
                    if (contact.getId() == contactId) {
                        owner.getContacts().remove(contact);
                        System.out.println(" Removed friend");
                    } else System.out.println("\t\t Friend does not found ");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void allContacts(User owner) {
        try {
            if (owner.contacts != null) {
                System.out.println("\t\t  *** Friends *** "+"\n");
                for (User contact : owner.contacts) {
                    System.out.println(" Username      : " + contact.getUserNameOrEmail());
                    System.out.println(" ID            : " + contact.getId());
                    System.out.println(" Name          : " + contact.getFirstName());
                    System.out.println(" Surname       : " + contact.getSurName());
                    System.out.println(" Gender        : " + contact.getGender());
                    System.out.println(" Date of birth : " + contact.getDataOfBirth());
                    System.out.println("\n");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToContact(User owner, User contactUser) {
        try {
            if (owner != null) {
                owner.getContacts().add(contactUser);
                System.out.println(" \t\t *** Add to friend ");
            }
        }
        catch (Exception e) {
            System.out.println(" \t\t *** Error : " + e.getMessage());
        }

    }
}
