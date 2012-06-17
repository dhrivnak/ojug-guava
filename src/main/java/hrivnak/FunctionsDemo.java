package hrivnak;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class FunctionsDemo {
    public static void main(String[] args) {
        List<Person> people = Lists.newArrayList();
        people.add(new Person("Rutherford", "Hayes"));
        people.add(new Person("Benjamin", "Harrison"));
        people.add(new Person("Ulysses", "Grant"));
        people.add(new Person("James Abram", "Garfield"));
        people.add(new Person("Grover", "Cleveland"));
        people.add(new Person("Chester", "Arthur"));
        people.add(new Person("Theodore", "Roosevelt"));
        people.add(new Person("William", "Taft"));
        // bonus points for who knows what all of these presidents had in common

        Function<Person, String> firstAndLast = new Function<Person, String>() {
            public String apply(Person person) {
                return person.getFirstName() + " " + person.getLastName();
            }
        };
        Iterable<String> firstLast = Iterables.transform(people, firstAndLast);
        Utils.printCollection("names:", firstLast);

        Function<Person, String> lastCommaFirst = new Function<Person, String>() {
            public String apply(Person person) {
                return person.getLastName() + ", " + person.getFirstName();
            }
        };
        Iterable<String> lastFirst = Iterables.transform(people, lastCommaFirst);
        Utils.printCollection("last, first:", lastFirst);
    }

    static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String first, String last) {
            firstName = first;
            lastName = last;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
