package model;

import base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter


public class Contact  extends Base {
    private int userId;
    private String contactName;
    private String contactSurname;
    private String contactNumber;

    public Contact(){

    }

    public Contact(int id, int userId, String contactName, String contactNumber, String contactSurname) {
        super(id);
        this.userId = userId;
        this.contactSurname = contactSurname;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "\t\t *** Contacts ***" +"\n"+
                " User Id : " + userId +"\n"+
                " Name : " + contactName + "\n" +
                " Number : " + contactNumber + "\n";
    }
}
