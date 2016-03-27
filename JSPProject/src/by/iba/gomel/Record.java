package by.iba.gomel;

import java.util.Date;

/**
 * This class contains
 */
public class Record {

    private int    item         = -1;
    private String fullName     = null;
    private String address      = null;
    private String phoneNumber  = null;
    private Date   creationDate = null;
    private String mail         = null;
    private Date   birthDate    = null; ;

    public Record() {
    }

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

    public void setItem(final int item) {
        this.item = item;
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

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setMail(final String mail) {
        this.mail = mail;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Record [item=" + item + ", fullName=" + fullName + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", creationDate=" + creationDate + ", mail="
                + mail + ", birthDate=" + birthDate + "]";
    }

}
