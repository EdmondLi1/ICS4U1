public class Fraction {
    
    // (cho's order of stuff in class)
    // constructor methods
    // getters/setters
    // class/int method

    // fields / properties of the class
    private int numerator;
    private int denominator;

    // Constructor Method
    public Fraction(int numerator, int denominator) {
        // use 'this' keyword to refer to the object
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // ***
    // 5. Write another constructor (called overloading)
    // public Fraction(Fraction other) { … } which is a copy of other.
    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    // ****
    // 3. Overloaded Constructors Add the following constructors to the Fraction class:  A constructor that takes a double number as parameter
    // and constructs the corresponding rational number, eg., 0.98 is 49 / 50, -8.343 is -8343 / 1000.  A constructor that takes a
    // single int value as parameter, and so assigns that to the numerator and the denominator to 1. A constructor that takes no parameter
    // and so initialises the fraction to 1.

    public Fraction(double decimal) {
        int n = 0;
        while(decimal % 1 != 0) {
            decimal *= 10;
            n++;
        }
        this.numerator = (int) decimal;
        this.denominator = (int) Math.pow(10, n);
        reduce();
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }

    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    /////////////////////////////////////
    //  Getters and Setters
    /////////////////////////////////////

    // Accessor Methods (Getters)
    public int getNumerator() {
        return numerator;
    }

    // Mutator Methods (Setters)
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // 1. Write the accessor (getter) and mutator (setter) methods for the denominator field.
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    // 2. Write a mutator (setter) method that modifies both the numerator and denominator fields at once.
    public void setFraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // 3. Complete the instance method
    // public Fraction multiply(Fraction other) { … }
    // which returns a Fraction object that is the product of the implicit object parameter
    // and the explicit parameter other.
    public Fraction multiply(Fraction other) {
        int numProd = numerator * other.numerator;
        int denProd = denominator * other.denominator;
        Fraction multiply = new Fraction(numProd, denProd);
        multiply.reduce();
        return multiply;
    }

    // 4. Complete the instance method
    // public Fraction add(Fraction other) { … }
    // which returns a Fraction object whose value is the sum of the implicit object parameter
    // and the explicit parameter other. The method should leave both its explicit and implicit parameters unchanged.
    // (Don't worry about the lowest common denominator for now.)
    public Fraction add(Fraction other) {
        int numSum = numerator * other.denominator + other.numerator * denominator;
        int denSum = denominator * other.denominator;
        Fraction added = new Fraction(numSum, denSum);
        added.reduce();
        return added;
    }

    // 5. ***

    // 6. Modify the equals method such that two Fraction objects are considered equal if and only if the fractions
    // are equivalent, eg. -1/2 is equivalent to 2/-4. Test in the main method.
    // Fractions are equavalent if the cross multiply is the same
    public boolean equal(Fraction other) {
        return numerator * other.denominator == denominator * other.numerator;
    }

    // Instance Methods
    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public boolean greaterThan(Fraction other) {
        // outputs true if current Obj > 'other' Obj.
        return this.toDecimal() > other.toDecimal();
    }
    
    ////////////////////////////////////////////
    //    2.1 Class and Objects Homework
    //////////////////////////////////////////

    // 1.
    // a) public void timesEquals(Fraction other) This method should have the same
    // effect (for Fraction objects) that the *= operator has for primitive numeric types.
    // Thus, if called by the statement p.timesEquals(q);
    public void timesEqual(Fraction other) {
        numerator *= other.numerator ;
        denominator *= other.denominator;
        reduce();
    }

    // b)  public void plusEquals(Fraction other) Same as above, but for +=.
    public void plusEquals(Fraction other) {
        numerator = numerator * other.denominator + denominator * other.numerator;
        denominator *= other.denominator;
        reduce();
    }

    // c) public void integerMultiply(int k) This method should multiply the fraction
    // by the specified integer, eg. 4 * 2 / 3 = 8 / 3
    public void integerMultiply(int k) {
        numerator *= k;
        reduce();
    }

    // d)  public void reduce() This method reduces the implicit object Fraction to its
    // lowest terms. It also changes the signs of the numerator and denominator as follows:
    // if the fraction is negative, ensures only the numerator is negative,
    // rather than the denominator; if both numerator and denominator are negative,
    // they are both made positive, eg. 2 / 8 -> 1 / 4, 7 /-3 -> -7 / 3, -3 /-9 -> 1 / 3.
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public void reduce() {

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        int commonFactor = gcd(Math.abs(numerator), Math.abs(denominator));

        numerator /= commonFactor;
        denominator /= commonFactor;
    }


    // e) public Fraction reciprocal() This method returns the reciprocal of the implicit object.
    public Fraction reciprocal() {
        return new Fraction(denominator, numerator);
    }

    // f) public Fraction divide(Fraction other) This method returns the implicit Fraction object divided by the other Fraction.
    public Fraction divide(Fraction other) {
        return multiply(other.reciprocal());
    }

    // g) public Fraction subtract(Fraction other) This method
    // returns the parameter object subtracted from the implicit Fraction object.
    public Fraction subtract(Fraction other) {
        Fraction neg = new Fraction(-other.numerator, other.denominator);
        return add(other);
    }

    // Class Method (Product Exercise)
    public static Fraction product(Fraction f1, Fraction f2) {
        return f1.multiply(f2);
    }

    // 2. Class Methods Create class (static) methods sum, difference, and quotient. 
    // They should take two Fraction objects f1 and f2 as parameters, perform each operation
    // and return a Fraction in lowest terms. (Hint: utilize existing methods)
    public static Fraction sum(Fraction f1, Fraction f2) {
        return f1.add(f2);
    }

    public static Fraction difference(Fraction f1, Fraction f2) {
        return f1.subtract(f2);
    }

    public static Fraction quotient(Fraction f1, Fraction f2) {
        return f1.divide(f2);
    }

    // 3. ****
    
    // What is the string representation of the string Object
    @Override
    public String toString() {
        reduce();

        if (numerator == 0) {
            return "0";
        }
        else if (denominator == 1) {
            return "" + numerator;
        }
        return numerator + "/" + denominator;
    }
}