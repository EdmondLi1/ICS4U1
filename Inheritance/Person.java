public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // a) Add an override method for toString for Person to print
    // the name and age fields nicely, e.g. Name: Alan, Age: 42
     @Override
     public String toString() {
        return "Name: " + name + ", Age: " + age;
     }

    // d) Add an override method for equals for Person. Here is the header:

    // The method should check: if the object o is not null;
    // if the object o is the same class as this using getClass(); create a new person p which is o cast to Person,
    // eg. (Person) o; return true if the instance fields of both objects (p and this) are equivalent.
     @Override
     public boolean equals(Object o) {
         if (o.getClass().equals(this.getClass()) && o != null) {
             Person p = (Person) o;
             return (p.name.equals(name) && p.age == age);
         }
         return false;
     }
}
