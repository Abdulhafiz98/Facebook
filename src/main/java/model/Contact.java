package model;
import base.Base;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Contact  extends Base {
    private int userId;
    private String contactName;
    private String contactSurname;
    private String contactNumber;

    @Override
    public String toString() {
        return  "\t\t *** Contacts ***" +"\n"+
                " User Id : " + userId +"\n"+
                " Name : " + contactName + "\n" +
                " Surname : " + contactSurname + "\n" +
                " Number : " + contactNumber + "\n";
    }
}
