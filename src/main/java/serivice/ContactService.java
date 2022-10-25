package serivice;

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
    }
}
