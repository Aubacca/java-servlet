package ch.renhor.services;

import ch.renhor.models.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonServiceTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getUserList() {
        final PersonService personService = new PersonService();
//
        final Person person1 = new Person();
        person1.setAge((byte)25);
        person1.setFirstName("First");
        person1.setLastName("Last");
        person1.setMail("first.last@mail.com");
        person1.setCity("Mars");
        person1.setStreet("Longroad");
        person1.setStreetNumber("9999999");
        person1.setId(personService.getNextPersonId());
        personService.addPerson(person1);

        final List<Person> personList = personService.getPersonList();
        for (Person person : personList) {
            System.out.println(person.toString());
        }

    }
}