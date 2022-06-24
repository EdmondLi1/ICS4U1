public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int age;

    /**
     * Constructor which instantiates a Person object with the given parameters.
     *
     * @param firstName their first name
     * @param lastName their last name
     * @param age age of person
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Returns the first name of the Person.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the Person.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the age of the Person.
     *
     * @return their age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the first name of the Person, given the new first name.
     *
     * @param firstName new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the Person, given the new last name.
     *
     * @param lastName new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the age of the Person, given the new age.
     *
     * @param age new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Checks if the current Person is older than the other Person.
     *
     * @param p other Person
     * @return whether current Person is older than the other one
     */
    public boolean isOlder(Person p) {
        return age > p.age;
    }

    /**
     *  Abstract method which checks if two Persons are equivalent for
     *  varying categories.
     *
     * @param p other Person
     * @return whether two Person are equal
     */
    abstract boolean equals(Person p);

    /**
     * String representation of the Person object.
     *
     * @return the Person's details
     */
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", Age: " + age;
    }
}