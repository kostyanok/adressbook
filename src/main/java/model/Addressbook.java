package model;

import java.util.*;

public class Addressbook {

    private Set<ContactData> contacts;
    private ContactData contact = new ContactData();
    private Error errorMessage;

    public Addressbook(TreeSet<ContactData> contacts) {
        this.contacts = contacts;
    }

    public void addContact(ContactData contactData) {
        if (!contact.isValid(contactData)) {
            errorMessage = Error.valueOf("CONTACT_IS_NOT_VALID");
        } else if (findContact(contactData)) {
            errorMessage = Error.valueOf("CONTACT_ALREADY_EXISTS");
        } else {
            contacts.add(contactData);
        }
    }

    public void removeContact(ContactData contactData) {
        if (findContact(contactData)) {
            contacts.remove(contactData);
        } else {
            errorMessage = Error.valueOf("CONTACT_IS_NOT_FOUND");
        }
    }

    public void editContact(ContactData contactData, ContactData newContactData) {
        if (findContact(contactData)) {
            contactData.setFirstName(newContactData.getFirstName());
            contactData.setLastName(newContactData.getLastName());
            contactData.setEmail(newContactData.getEmail());
            contactData.setMobile(newContactData.getMobile());
            contactData.setBirthDate(newContactData.getBirthDate());
        } else {
            errorMessage = Error.valueOf("CONTACT_IS_NOT_FOUND");
        }
    }

    public boolean findContact(ContactData contactData) {
        for (ContactData contact : contacts) {
            if (contact.equals(contactData)) {
                return true;
            }
        }
        return false;
    }

    public Set<ContactData> searchContacts(String valueForSearch) {
        Set<ContactData> foundContacts = new TreeSet<>();
        contacts.forEach(contactData -> {
            if (contactData.getFirstName().equals(valueForSearch) || contactData.getLastName().equals(valueForSearch) ||
                    contactData.getMobile().equals(valueForSearch) || contactData.getEmail().equals(valueForSearch)) {
                foundContacts.add(contactData);
            }
        });
        return foundContacts;
    }

    public Set<ContactData> searchContacts(String firstName, String lastName) {
        Set<ContactData> foundContacts = new TreeSet<>();
        contacts.forEach(contactData -> {
            if (contactData.getFirstName().equals(firstName) && contactData.getLastName().equals(lastName)) {
                foundContacts.add(contactData);
            }
        });
        return foundContacts;
    }

    public Set<ContactData> searchContacts(int fromAge, int toAge) {
        Set<ContactData> foundContacts = new TreeSet<>();
        Calendar currentDate = new GregorianCalendar();
        contacts.forEach(contactData -> {
            int age = (currentDate.get(Calendar.YEAR) - contactData.getBirthDate().get(Calendar.YEAR));
            if (age >= fromAge && age <= toAge) {
                foundContacts.add(contactData);
            }
        });
        return foundContacts;
    }

    public Set<ContactData> getContacts() {
        return contacts;
    }

    public Error getErrorMessage() {
        return errorMessage;
    }

}
