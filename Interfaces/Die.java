import java.util.Random;

public class Die implements Comparable<Die>{
    private int value;
    private int sides;
    private static final Random RNG = new Random();

    public Die(int sides) {
        this.sides = sides;
        roll();
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        value = RNG.nextInt(sides) + 1;
    }

    @Override
    public String toString() {
        return "d" + sides + ": " + value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Die) {
            Die d = (Die) object;
            return value == d.value;
        }
        return false;
    }

    @Override
    public int compareTo(Die die) {
        return value - die.value;
    }
}