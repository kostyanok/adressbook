import model.ContactData;
import model.Error;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.HashSet;

public class ExtraTestsForContactData extends BaseClass {

    @Test
    public void emptyCtorTest() {
        int size = addressbook.getContacts().size();
        ContactData contact1 = new ContactData();
        contact1.setLastName("Shevchenko");
        addressbook.addContact(contact1);
        ContactData contact2 = new ContactData();
        contact2.setLastName("Kostyanok");
        addressbook.addContact(contact2);
        Assert.assertEquals(addressbook.getContacts().size(), size + 2);
    }

    @Test
    public void isValidTest() {
        ContactData validContact = new ContactData("Anatoliy", "149521");
        ContactData someContact = new ContactData();
        Assert.assertEquals(someContact.isValid(validContact), true);
    }

    @Test
    public void equalityTest() {
        Set<ContactData> set = new HashSet<ContactData>();
        ContactData contact1 = new ContactData("A1", "111222");
        ContactData contact2 = new ContactData("A1", "111222");
        set.add(contact1);
        set.add(contact2);

        Assert.assertEquals(set.size(), 1);
    }

    @Test
    public void strangeTest() {
        int size = addressbook.getContacts().size();
        ContactData contact1 = new ContactData("Anatoliy", "123456");
        ContactData contact2 = new ContactData("Mykola", "654321");
        addressbook.addContact(contact1);
        addressbook.getContacts().stream().findFirst().get().setFirstName("Mykola");
        addressbook.addContact(contact2);

        //Assert.assertEquals(addressbook.getContacts().size(), 2);
        Assert.assertEquals(addressbook.getErrorMessage(), Error.valueOf("CONTACT_ALREADY_EXISTS"));
        Assert.assertEquals(addressbook.getContacts().size(), size + 1);
    }
}
