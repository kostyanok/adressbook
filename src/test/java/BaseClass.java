import model.Addressbook;
import model.ContactData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.*;

public class BaseClass {

    public Addressbook addressbook;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        addressbook = new Addressbook(new TreeSet<>(Set.of(
                new ContactData("Igor", "Jackson", "igorJ@gmail.com", "+380998715673", new GregorianCalendar(2008, 5, 1)),
                new ContactData("Yulia", "Lim", "jL@gmail.com", "+380998799973", new GregorianCalendar(1991, 5, 1)),
                new ContactData("Sam", "Dark", "sl@gmail.com", "+380998799888", new GregorianCalendar(1990, 4, 1)),
                new ContactData("Jack", "Jackson", "jj@gmail.com", "+380000715673", new GregorianCalendar(1931, 4, 1)))));
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterMethod() {
        addressbook.getContacts().clear();
    }
}
