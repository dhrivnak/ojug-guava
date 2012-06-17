package hrivnak;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class PredicatesDemo {
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

        Iterable<Person> lastNamesStartingWithG = Iterables.filter(people, Person.lastNameStartsWith("G"));
        Utils.printCollection("people with last names starting with G:", lastNamesStartingWithG);

        Iterable<Person> namesContainingTh = Iterables.filter(people, Person.nameContains("th"));
        Utils.printCollection("people with names containing th:", namesContainingTh);
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

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }

        public static Predicate<Person> lastNameStartsWith(final String prefix) {
            return new Predicate<Person>() {
                public boolean apply(Person person) {
                    return person.lastName.startsWith(prefix);
                }
            };
        }

        public static Predicate<Person> nameContains(final String str) {
            return new Predicate<Person>() {
                public boolean apply(Person person) {
                    return person.firstName.toUpperCase().contains(str.toUpperCase()) //
                            || person.lastName.toUpperCase().contains(str.toUpperCase());
                }
            };
        }
    }

}
