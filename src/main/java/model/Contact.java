package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString

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
}
