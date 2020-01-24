import model.ContactData;
import model.Error;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;


public class ContactDeletionTests extends BaseClass{


    @Test
    public void removeContact() {
        int contactSize = addressbook.getContacts().size();
        addressbook.removeContact(addressbook.getContacts().iterator().next());
        Assert.assertEquals(addressbook.getContacts().size(), contactSize - 1);
    }

    @Test
    public void removeNotExistContact() {
        addressbook.removeContact(new ContactData("Tom", "Jackson", "samJ@gmail.com", "+38099879999",
                new GregorianCalendar(1991, 5, 1)));
        Assert.assertEquals(addressbook.getErrorMessage(), Error.valueOf("CONTACT_IS_NOT_FOUND"));
    }
}
