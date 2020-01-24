import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;


public class SearchContactsTests extends BaseClass {

    @Test
    public void searchByFirstName() {
        Set<ContactData> expectedContacts = new TreeSet<>();
        for (ContactData contact : addressbook.getContacts()) {
            if (contact.getFirstName().equals("Sam")) {
                expectedContacts.add(contact);
            }
        }
        Assert.assertEquals(addressbook.searchContacts("Sam"), expectedContacts);
    }

    @Test
    public void searchByNotExistContact() {
        Assert.assertEquals(addressbook.searchContacts("FakeName"), Collections.emptyList());
    }

    @Test
    public void searchByLastName() {
        Set<ContactData> expectedContacts = new TreeSet<>();
        for (ContactData contact : addressbook.getContacts()) {
            if (contact.getLastName().equals("Dark")) {
                expectedContacts.add(contact);
            }
        }
        Assert.assertEquals(addressbook.searchContacts("Dark"), expectedContacts);
    }

    @Test
    public void searchByMobile() {
        Set<ContactData> expectedContacts = new TreeSet<>();
        for (ContactData contact : addressbook.getContacts()) {
            if (contact.getMobile().equals("+380998799888")) {
                expectedContacts.add(contact);
            }
        }
        Assert.assertEquals(addressbook.searchContacts("+380998799888"), expectedContacts);
    }

    @Test
    public void searchByEmail() {
        Set<ContactData> expectedContacts = new TreeSet<>();
        for (ContactData contact : addressbook.getContacts()) {
            if (contact.getEmail().equals("jj@gmail.com")) {
                expectedContacts.add(contact);
            }
        }
        Assert.assertEquals(addressbook.searchContacts("jj@gmail.com"), expectedContacts);
    }

    @Test
    public void searchByFirstNameAndLastName() {
        Set<ContactData> expectedContacts = new TreeSet<>();
        for (ContactData contact : addressbook.getContacts()) {
            if (contact.getFirstName().equals("Sam") && contact.getLastName().equals("Jackson")) {
                expectedContacts.add(contact);
            }
        }
        Assert.assertEquals(addressbook.searchContacts("Sam", "Jackson"), expectedContacts);
    }


    @Test(dataProvider = "ageRange")
    public void searchByAge(int fromAge, int toAge, int expectedSize) {
        Assert.assertEquals(addressbook.searchContacts(fromAge, toAge).size(), expectedSize);
    }

    @Test(dataProvider = "ageRangeNegativeCase")
    public void searchByAgeNegativeCase(int fromAge, int toAge, int expectedSize) {
        Assert.assertEquals(addressbook.searchContacts(fromAge, toAge).size(), expectedSize);
    }

    @DataProvider
    public Object[][] ageRange() {
        return new Object[][]{
                {1, 20, 1},
                {20, 50, 2},
                {50, 99, 1}
        };
    }

    @DataProvider
    public Object[][] ageRangeNegativeCase() {
        return new Object[][]{
                {-1, 0, 0},
                {99, 100, 0}
        };
    }
}
