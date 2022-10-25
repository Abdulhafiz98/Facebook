package model;

import base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;


@Setter
@Getter

public class Contact  extends Base {
    private int userId;
    private String contactName;
    private String contactSurname;
    private String contactNumber;


    public Contact(int userId, String contactName, String contactNumber, String contactSurname) {
        super();
        this.userId = userId;
        this.contactSurname = contactSurname;
        this.contactName = contactName;
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
