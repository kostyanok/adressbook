package model;

import java.util.Calendar;
import java.util.Objects;

public class ContactData implements Comparable<ContactData> {

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Calendar birthDate;

    public ContactData(String firstName, String lastName, String email, String mobile, Calendar birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.birthDate = birthDate;
    }

    public ContactData(String firstName, String mobile) {
        this.firstName = firstName;
        this.mobile = mobile;
    }

    public ContactData() {

    }

    public boolean isValid(ContactData contactData) {
        if ((contactData.getFirstName() == null) && (contactData.getLastName() == null) && (contactData.getMobile() == null) &&
                (contactData.getEmail() == null) && (contactData.getBirthDate() == null)) {
            return false;
        } else return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(mobile, that.mobile);
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
        return contactData.getFirstName().compareTo(this.firstName);
    }
}
