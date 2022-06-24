public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName;
    }

    @Override
    public int compareTo(Person p) {
        if (lastName.compareTo(p.lastName) == 0) {
            return firstName.compareTo(p.firstName);
        }
        return lastName.compareTo(p.lastName);
    }
}
