public class Student extends Person {
    public String id;

    public Student(String name, int age, String id) {
        super(name, age);
        this.id = id;
    }

    // b) Add an override method of toString for Student which adds
    // the student id to the string, using the super method
    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }

    // e) Add an override method for equals for Student. Use super to save time and code.
    @Override
    public boolean equals(Object o) {
        Student p = (Student) o;
        return (super.equals(o) && p.id == id);
    }
}
