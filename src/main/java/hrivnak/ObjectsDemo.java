package hrivnak;

import com.google.common.base.Objects;

public class ObjectsDemo {
    public static void main(String[] args) {
        Person dan = new Person("Dan", "Hrivnak", 30);
        Person carlos = new Person("Carlos", "Norris", 72);
        Person chuck = carlos;

        System.out.println("dan.equals(chuck) = " + dan.equals(chuck));
        System.out.println("chuck.equals(carlos) = " + chuck.equals(carlos));

        System.out.println("dan.hashCode() = " + dan.hashCode());
        System.out.println("dan.toString() = " + dan.toString());
    }

    static class Person {
        private final String firstName;
        private final String lastName;
        private final int age;

        public Person(String first, String last, int age) {
            firstName = first;
            lastName = last;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Person) {
                final Person that = (Person) obj;
                return this == that //
                        || Objects.equal(this.firstName, that.firstName) //
                        && Objects.equal(this.lastName, that.lastName) //
                        && Objects.equal(this.age, that.age);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(firstName, lastName, age);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).add("firstName", firstName).add("lastName", lastName).add("age", age)
                    .toString();
        }
    }
}
