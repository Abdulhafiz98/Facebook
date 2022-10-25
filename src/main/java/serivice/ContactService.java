package serivice;

import model.User;
import serivice.baseService.BaseService;


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
        User contact = null;
        try {
            if (owner.contacts != null) {
                for (User thisContact : owner.getContacts()) {
                    if (thisContact.getId() == contactId) {
                        contact = thisContact;
                    }
                    else {
                        System.out.println(" Friend not found ");
                    }
                }
            }
        }catch (Exception e) {
            System.out.println(" No Friends ");
        }
        return contact;
    }

    public boolean deleteContactById(int contactId, User owner) {
       boolean flag = false;
        try {
            if (owner.getContacts() != null) {
                for (User contact : owner.getContacts()) {
                    if (contact.getId() == contactId) {
                        owner.getContacts().remove(contact);
                        System.out.println(" Friend removed ");
                        flag = true;
                    } else System.out.println("\t\t Friend does not found ");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public void allContacts(User owner) {
        try {
            if (owner.contacts != null) {
                System.out.println("\t\t  *** Friends *** "+"\n");
                for (User contact : owner.contacts) {
                    System.out.println("\n\n");
                    System.out.println(" Username      : " + contact.getUserNameOrEmail());
                    System.out.println(" ID            : " + contact.getId());
                    System.out.println(" Name          : " + contact.getFirstName());
                    System.out.println(" Surname       : " + contact.getSurName());
                    System.out.println(" Gender        : " + contact.getGender());
                    System.out.println(" Date of birth : " + contact.getDataOfBirth());
                    System.out.println("\n");
                }
            }
            else System.out.println(" \t\t *** No friends *** ");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean addToContact(User owner, User contactUser) {
       boolean flag = false;
        try {
            if (owner != null) {
                owner.getContacts().add(contactUser);
                System.out.println(" \t\t *** Added to friends ***");
                flag = true;
            }
        }
        catch (Exception e) {
            System.out.println(" \t\t *** Error : " + e.getMessage());
        }
      return flag;
    }
}
