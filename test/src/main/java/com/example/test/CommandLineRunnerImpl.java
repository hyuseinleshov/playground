package com.example.test;

import com.example.test.autovalue.Person;
import com.example.test.autovalue.PersonRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Immutable data objects instantiation

        // Approach 1 - with AutoValue framework
        Person person = Person.create("John Doe", 30);

        System.out.println(person.name());
        System.out.println(person.age());
        System.out.println(person);

        // Approach 2 - with Java Records (since Java 14+)
        PersonRecord personRecord = new PersonRecord("John Doe", 30);

        System.out.println(personRecord.name());
        System.out.println(personRecord.age());
        System.out.println(personRecord);
    }
}
