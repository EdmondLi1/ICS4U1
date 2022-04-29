public class Main {

    public static void main(String[] args) {
	// write your code here
        Person p = new Person("Alan", 42);
        Student q = new Student("Ada", 37, "10010101");
        // print each person using toString
        Person r = p;
        System.out.println(r.equals(p));        // Same reference type;  therefore true
        Student s = new Student("Ada", 37, "10010101");
        System.out.println(s.equals(q));    // Since these variables point to diff references, they arent the SAME OBJ.
    }
}
