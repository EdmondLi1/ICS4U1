import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Testing Person Class
        Person a = new Person("Edmond", "Li");
        Person b = new Person("Jamie", "Easterbrook");
        Person c = new Person("Irina", "Khan");
        Person d = new Person("Khadija", "Khan");

        ArrayList<Person> ppl = new ArrayList<>();
        ppl.add(a);
        ppl.add(b);
        ppl.add(c);
        ppl.add(d);

        System.out.println(ppl);
        Collections.sort(ppl);
        System.out.print("sorted by name (alphabetically): ");
        System.out.println(ppl);

        // Game 1
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        boolean isNotEqual = true;

        while (isNotEqual) {

            if(!die1.equals(die2)) {
                System.out.printf("You rolled %d and %d. Try again!%n", die1.getValue(), die2.getValue());
                die1.roll();
                die2.roll();
            }
            else {
                System.out.printf("You rolled doubles: %d, %d%n", die1.getValue(), die2.getValue());
                isNotEqual = false;
            }
        }

        System.out.println();
        
        // Game 2
        ArrayList<Die> playerOne = new ArrayList<>();
        ArrayList<Die> playerTwo = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Die d1 = new Die(20);
            Die d2 = new Die(20);

            playerOne.add(d1);
            playerTwo.add(d2);            
        }

        System.out.println("Results: ");
        System.out.println(" P1 P2");
        
        for (int i = 0; i < 3; i++) {
            playerOne.get(i).roll();
            playerTwo.get(i).roll();

            System.out.printf(" %-2d %-2d %n", playerOne.get(i).getValue(), playerTwo.get(i).getValue());
        }

        int playerOnePoints = 0, playerTwoPoints = 0;

        Collections.sort(playerOne);
        Collections.sort(playerTwo);

        for (int i = 0; i < 3; i++) {
            if (playerOne.get(i).getValue() > playerTwo.get(i).getValue()) {
                playerOnePoints++;
            }
            else if (playerOne.get(i).getValue() < playerTwo.get(i).getValue()) {
                playerTwoPoints++;
            }
        }
        System.out.println("Player 1 points: " + playerOnePoints);
        System.out.println("Player 2 points: " + playerTwoPoints);

        if (playerOnePoints > playerTwoPoints) {
            System.out.println("Player 1 Wins!");
        }
        else if (playerOnePoints < playerTwoPoints) {
            System.out.println("Player 2 Wins!");
        }
        else {
            System.out.println("Tie Game, No one Wins!");
        }
    }

//        Person p = new Person("Alan", 42);
//        Person q = new Person("Linus", 38);
//        Person r = new Person("Monty", 62);
//        ArrayList<Person> ppl = new ArrayList<>();
//        ppl.add(r);
//        ppl.add(q);
//        ppl.add(p);
//        System.out.println(ppl);
//        Collections.sort(ppl);
//        System.out.print("sorted by age: ");
//        System.out.println(ppl);

//    public static class Person implements Comparable<Person> {
//        private String name;
//        private int age;
//
//        public Person(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        @Override
//        public String toString() {
//            return name + ": " + age;
//        }
//        @Override
//        public int compareTo(Person o) {
////            return age - o.age;
//            return name.compareTo(o.name);
//        }
//    }
//
//    class Student extends Person {
//        private String id;
//
//        public Student(String name, int age, String id) {
//            super(name, age);
//            this.id = id;
//        }
//
//        @Override
//        public String toString() {
//            return super.toString() + ", " + id;
//        }
//
//        @Override
//        public int compareTo(Person p) {
//            if (p != null && p instanceof Student) {
//                Student s = (Student) p;
//                return id.compareTo(s.id);
//            }
//        }
//    }
}

