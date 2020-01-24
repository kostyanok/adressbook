import model.ContactData;
import model.Error;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class ContactEditionTests extends BaseClass{

    @Test
    public void editContact() {
        ContactData newDate = new ContactData("Jack", "Jackson",
                "samJ@gmail.com", "+380998715673", new GregorianCalendar(2000, 8, 10));
        ContactData contactToEdit = addressbook.getContacts().iterator().next();
        addressbook.editContact(contactToEdit,newDate );
        Assert.assertEquals(contactToEdit, newDate);
    }

    @Test
    public void editNotExistContactNegativeCase() {
        addressbook.editContact(
                new ContactData("FakeName", "fakeMobile"),
                new ContactData("Jack", "Jackson", "samJ@gmail.com", "+380998715673", new GregorianCalendar(2000, 8, 10)));
        Assert.assertEquals(addressbook.getErrorMessage(), Error.valueOf("CONTACT_IS_NOT_FOUND"));
    }
}
