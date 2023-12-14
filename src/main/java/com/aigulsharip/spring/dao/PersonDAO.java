package com.aigulsharip.spring.dao;

import com.aigulsharip.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int peopleCount;

    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount, "Tom"));
        people.add(new Person(++peopleCount, "Bob"));
        people.add(new Person(++peopleCount, "Mike"));
        people.add(new Person(++peopleCount, "Sara"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show (int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save (Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update (int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());

    }

    public void delete (int id) {
        people.removeIf(p ->p.getId() == id);
    }



}
