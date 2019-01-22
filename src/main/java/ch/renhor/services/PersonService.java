package ch.renhor.services;

import ch.renhor.models.Person;

import java.util.List;
import java.util.Optional;

public class PersonService {
/*    private static final byte minimum = 18;
    private static final byte maximum = 80;*/
    private List<Person> personList;

/*    {
        personList = new ArrayList();
    }*/

    public PersonService() {
        personList = PersonGenerator.getUserList(100);
    }

/*    {
        final List<String> firstNames = Arrays.asList("Peter", "Claudia", "Sandy", "Sue", "Tom", "Marry");
        final List<String> lastNames = Arrays.asList("Rohner", "Böni", "Doe", "Smith");
//
        for (int i = 0; i < 100; i++) {
            Person user = new Person();
            int age = ThreadLocalRandom.current().nextInt(minimum, maximum);
            user.setId(i);
            user.setAge((byte) age);
            user.setFirstName(firstNames.get((int) (Math.random() * firstNames.size())));
            user.setLastName(lastNames.get((int) (Math.random() * lastNames.size())));
            user.setMail(user.getFirstName().toLowerCase() + "." + user.getLastName().toLowerCase() + "@gmail.com");
            personList.add(user);
        }

    }*/
/*
    {
        final Person user = new Person();
        user.setId(getNextPersonId());
        user.setAge((byte)50);
        user.setFirstName("Peter Jürg");
        user.setLastName("Rohner");
        user.setMail("x.x@google.com");
        personList.add(user);
    }*/

    public List<Person> getPersonList() {
        return personList;
    }

    public int getNextPersonId() {
        final Optional<Person> first = personList.stream().sorted((person1, person2) -> person2.getId() - person1.getId()).findFirst();
//        return first.isPresent()? first.get().getId() + 1: 1;
        return first.map(p -> p.getId() + 1).orElse(1);
    }

    public List<Person> addPerson(Person person) {
        this.personList.add(person);
        return personList;
    }

    public void showPersons() {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    public boolean validatePerson(Person person) throws Exception {
        if (person.getAge() < 1) {
            throw new Exception("Person may not be younger than one year in age!");
        }
        //
        if (person.getAge() > 110) {
            throw new Exception("Person may not be older than 120 years!");
        }
        return true;
    }

    public Person getPersonById(int personId) {
        final Optional<Person> person = personList.stream().filter(p -> p.getId() == personId).findFirst();
        return person.isPresent()? person.get(): new Person();
    }
}

