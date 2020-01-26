package model;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

public class ContactData implements Comparable<ContactData> {

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Calendar birthDate;
    private int contactId;

    public ContactData(String firstName, String lastName, String email, String mobile, Calendar birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.birthDate = birthDate;
        this.contactId = new Random().nextInt(1000);
    }

    public ContactData(String firstName, String mobile) {
        this.firstName = firstName;
        this.mobile = mobile;
        this.contactId = new Random().nextInt(1000);
    }

    public ContactData() {
        this.contactId = new Random().nextInt(1000);
    }

    public boolean isValid(ContactData contactData) {
        if ((contactData.getFirstName() == null) && (contactData.getLastName() == null) && (contactData.getMobile() == null)) {
            return false;
        } else return true;
    }

    @Override
    public boolean equals(Object o) {
        ContactData that = (ContactData) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || firstName == null || that.firstName == null) return false;
        return Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobile);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public int getContactId() {
        return contactId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public int compareTo(ContactData contactData) {
        if (contactData.getFirstName() != null && this.getFirstName() != null) {
            return this.getFirstName().compareTo(contactData.getFirstName());
        } else if (contactData.getLastName() != null && this.getLastName() != null) {
            return this.getLastName().compareTo(contactData.getLastName());
        } else {
            return this.getMobile().compareTo(contactData.getMobile());
        }
    }
}

