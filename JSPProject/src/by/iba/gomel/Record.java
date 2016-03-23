package by.iba.gomel;

import java.util.Date;

/**
 * This class contains
 */
public class Record {

    private final int    item;
    private final String fullName;
    private final String address;
    private final String phoneNumber;
    private final Date   creationDate;
    private final String mail;
    private final Date   birthDate;

    public Record(final int item, final String fullName, final String address,
            final String phoneNumber, final Date creationDate, final String mail,
            final Date birthDate) {
        this.item = item;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
        this.mail = mail;
        this.birthDate = birthDate;
    }

    public int getItem() {
        return item;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getMail() {
        return mail;
    }

    public Date getBirthDate() {
        return birthDate;
    }

}
