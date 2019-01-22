package ch.renhor.services;

import ch.renhor.models.Person;
import ch.renhor.models.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PersonGenerator {
    private final static List<String> firstNames = Arrays.asList("Peter", "Claudia", "Sandy", "Sue", "Tom", "Marry", "Joycline", "Nemo");
    private final static List<String> lastNames = Arrays.asList("Rohner", "Böni", "Doe", "Smith", "Stark");
    private final static List<String> cities = Arrays.asList("Basel", "Münchenstein", "Engelberg", "San Francisco");
    private final static List<String> streets = Arrays.asList("Schulackerstrasse", "Eichenstrasse", "Hohle Gasse", "Sonnmatt");
    private final static List<Sex> sexList = Arrays.asList(Sex.FEMALE, Sex.MALE);
    private static final byte minimum = 18;
    private static final byte maximum = 80;
    private static List<Person> personList = new ArrayList<>();

    private PersonGenerator() {
    }

    static List<Person> getUserList(int numberOfUsers){
        //
        for (int i = 0; i < numberOfUsers; i++) {
            Person person = new Person();
            int age = ThreadLocalRandom.current().nextInt(minimum, maximum);
            person.setId(i);
            person.setAge((byte) age);
            person.setFirstName(firstNames.get((int) (Math.random() * firstNames.size())));
            person.setLastName(lastNames.get((int) (Math.random() * lastNames.size())));
            person.setMail(person.getFirstName().toLowerCase() + "." + person.getLastName().toLowerCase() + "@gmail.com");
            person.setCity(cities.get((int) (Math.random() * cities.size())));
            person.setStreet(streets.get((int) (Math.random() * streets.size())));
            person.setStreetNumber(String.valueOf(ThreadLocalRandom.current().nextInt(200)));
            person.setSex(sexList.get((int) (Math.random() * sexList.size())));
            personList.add(person);
        }
        //
        return personList;
    }
}
