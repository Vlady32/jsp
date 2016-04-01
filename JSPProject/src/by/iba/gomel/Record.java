package by.iba.gomel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import com.ibm.ws.util.Base64;

/**
 * This class contains fields and methods for working with records.
 */
public class Record {

    private int                 item         = Constants.DEFAULT_INDEX_ITEM;
    private String              fullName     = null;
    private String              address      = null;
    private String              phoneNumber  = null;
    private Date                creationDate = null;
    private String              mail         = null;
    private Date                birthDate    = null;
    private String              pathFile     = null;

    private static List<Record> listRecords;

    public static List<Record> getListRecords() {
        return Record.listRecords;
    }

    private byte[] getByteFile(final String pathToFile) {
        FileInputStream fileInputStream = null;
        final File file = new File(pathToFile);
        final byte[] bFile = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }

    public String getBase64Code() {
        return Base64.encode(getByteFile(pathFile));
    }

    public static void setListRecords(final List<Record> listRecords) {
        Record.listRecords = listRecords;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(final String pathFile) {
        this.pathFile = pathFile;
    }

    public Record() {
    }

    /**
     * 
     * @param item
     *            key record.
     * @param fullName
     *            full name.
     * @param address
     *            address.
     * @param phoneNumber
     *            phone number.
     * @param creationDate
     *            date of creation.
     * @param mail
     *            mail.
     * @param birthDate
     *            birthday date.
     */
    public Record(final int item, final String fullName, final String address,
            final String phoneNumber, final Date creationDate, final String mail,
            final Date birthDate, final String pathFile) {
        this.item = item;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
        this.mail = mail;
        this.birthDate = birthDate;
        this.pathFile = pathFile;
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

}
