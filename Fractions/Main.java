public class Main {

    public static void main(String[] args) {
	// write your code here
        Fraction f = new Fraction(1, 2);
        Fraction g = new Fraction(3, -4);
        Fraction h = new Fraction(-5, 2);
        Fraction i = new Fraction(-8.372);

        System.out.println("Fractions are here: ");
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);

        System.out.println("\nGetter Methods");
        System.out.println(f.getNumerator());
        System.out.println(g.getNumerator());
        System.out.println(h.getNumerator());
        
        // f.setDenominator(-3);
        System.out.println("Fraction as Decimal");
        System.out.println(f.toDecimal());
        System.out.println(i.toDecimal());

        // same result
        System.out.println(f.add(i));
        System.out.println(i.multiply(g));

        System.out.println(g.add(h));
        System.out.println(g.multiply(h));

        Fraction prod = Fraction.product(f, h);
        System.out.println("f * h = " + prod);

        Fraction sum = f.add(g);
        System.out.println("f + g = " + sum);

        System.out.println(f.subtract(g));
        System.out.println(Fraction.difference(i, g));
    }
}
