import model.ContactData;
import model.Error;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class ContactCreationTests extends BaseClass {

    @Test
    public void addContactToAddressBook() {
        ContactData contact = new ContactData("Andrey", "Popov", "popov@gmail.com", "+380998715999", new GregorianCalendar(1991, 5, 1));
        addressbook.addContact(contact);
        Assert.assertTrue(addressbook.getContacts().contains(contact));
    }

    @Test
    public void addContactWithFirstNameAndMobile() {
        ContactData contact = new ContactData("Sam", "+380929292");
        addressbook.addContact(contact);
        Assert.assertTrue(addressbook.getContacts().contains(contact));
    }

    @Test
    public void addInvalidContactToAddressBook() {
        ContactData contact = new ContactData();
        addressbook.addContact(contact);
        Assert.assertEquals(addressbook.getErrorMessage(), Error.valueOf("CONTACT_IS_NOT_VALID"));
    }

    @Test
    public void addAlreadyExistContactToAddressBook() {
        ContactData contact = new ContactData();
        addressbook.addContact(contact);
        Assert.assertEquals(addressbook.getErrorMessage(), Error.valueOf("CONTACT_IS_NOT_VALID"));
    }
}
