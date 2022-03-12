/**
 * A class that represents a 3-dimensional Cartesian vector, and has parameters x, y, z, and the magnitude.
 * The class supports basic operations between vectors such as: adding, subtracting, scalar multiplication,
 * dot product, and cross product. It also includes other operators such as finding the angle between two vectors,
 * returning a unit vector representation of the vector, printing the vector nicely in different notations, checking
 * if two vectors are orthogonal, and comparing two vectors to see if they're equal.
 */
public class Vector {

    private double x;
    private double y;
    private double z;
    private double magnitude;

    /**
     * Instantiates a Vector object instance and fills the field variables with the given parameters.
     *
     * @param x x-component of the vector
     * @param y y-component of the vector
     * @param z z-component of the vector
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        magnitude = Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Instantiates a Vector object instance that copies another Vector object's field.
     *
     * @param v the Vector being copied
     */
    public Vector(Vector v) {
        x = v.x;
        y = v.y;
        z = v.z;
        magnitude = v.magnitude;
    }

    /**
     * Instantiates Vector object instance with properties of a Zero vector when no parameters are given.
     *
     */
    public Vector() {
        x = 0;
        y = 0;
        z = 0;
        magnitude = 0;
    }

    /**
     * Returns the x-component of the vector.
     *
     * @return the x-component
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-component of the vector.
     *
     *  @return the y-component
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the z-component of the vector.
     *
     * @return the z-component
     */
    public double getZ() {
        return z;
    }

    /**
     * Returns the magnitude (length) of the vector.
     *
     * @return the magnitude
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * Changes the Vector's field variables to the given ones in the parameter.
     *
     * @param x new x-component
     * @param y new y-component
     * @param z new z-component
     */
    public void setVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        magnitude = Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Copies the field of another Vector object and sets it to the current Vector object.
     *
     * @param v the vector being copied
     */
    public void setVector(Vector v) {
        x = v.x;
        y = v.y;
        z = v.z;
        magnitude = v.magnitude;
    }

    /**
     * Adds two vectors and returns the sum of the vectors.
     *
     * @param v the other vector being added
     * @return the sum of the two vectors
     */
    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y, z + v.z);
    }

    /**
     * Subtracts two vectors and returns the difference of the vectors.
     *
     * @param v the subtrahend vector
     * @return the difference of the two vectors
     */
    public Vector subtract(Vector v) {
        return new Vector(x - v.x, y - v.y, z - v.z);
    }

    /**
     * Multiplies the vector by a given scalar (constant) and returns the new scaled vector.
     *
     * @param k the scalar to multiply
     * @return the scaled vector
     */
    public Vector scalarMultiply(double k) {
        return new Vector(k * x, k * y, k * z);
    }

    /**
     * Computes the dot product between two vectors and returns a scalar.
     *
     * @param v the other vector to compute dot product
     * @return a scalar, representing how much the vectors point in the same direction
     */
    public double dotProd(Vector v) {
        /* Formula for dot product:
           v1 ⋅ v2 = v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
        */
        return x * v.x + y * v.y + z * v.z;
    }

    /**
     * Computes the cross product of two vectors, and returns the vector perpendicular to both vectors.
     *
     * @param v the other vector compute cross product with
     * @return a vector, normal to both vectors
     */
    public Vector crossProd(Vector v) {
        /* Formula for the cross product:
                      | i       j       k |
        v1 x v2 =     |v1.x   v1.y    v1.z|
                      |v2.x   v2.y    v2.z|

                = (v1.y * v2.z - v1.z * v2.y) i
                - (v1.x * v2.z - v1.z * v2.x) j
                + (v1.x * v2.y - v1.y * v2.x) k
        */
        double xComp = y * v.z - z * v.y ;
        double yComp = - x * v.z + z * v.x;
        double zComp = x * v.y - y * v.x;

        return new Vector(xComp, yComp, zComp);
    }

    /**
     * Returns a new unit vector (directional vector) of the current Vector object.
     *
     * @return vector that has a magnitude of one, but preserves the direction of the parent vector
     */
    public Vector unitVector() {
        return this.scalarMultiply(1 / magnitude);
    }

    /**
     * Prints the vector object nicely in the Unit Vector notation and Cylindrical notation with the angle in degrees; [0, 2π).
     * Unit Vector : (v = xi + yj + zk),
     * Cylindrical : (r, φ, z)
     */
    public void printVector() {

        // Variables that help make printing vector in standard basis nicely
        String xSign = " ";
        String ySign = "+";
        String zSign = "+";

        // Variables that compute the polar coordinates for Cylindrical vector notation
        double radAngle = Math.atan2(y, x);
        double radDistance = Math.sqrt(x * x + y * y);

        if (x < 0) {
            xSign = "-";
        }
        if (y < 0) {
            ySign = "-";
        }
        if (z < 0) {
            zSign = "-";
        }

        // since cylindrical coordinates go from [0, 2π); atan2 returns (-π, π)
        // therefore we add + 2π to make the range from (-π, π) -> [0, 2π)
        if (radAngle < 0) {
            radAngle += 2 * Math.PI;
        }
        System.out.printf("Unit Vector Notation: %s %.2f i %s %.2f j %s %.2f k %n",
                xSign, Math.abs(x), ySign, Math.abs(y), zSign, Math.abs(z));

        // Print the angle in degree [0, 360) for cylindrical notation
        System.out.printf("Cylindrical Vector Notation: (r, angle, z) = (%.2f, %.2f, %.2f)%n%n",
                radDistance, Math.toDegrees(radAngle), z);
    }

    /**
     * Takes two vectors and returns the angle between them in degrees between 0 and 180.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the angle between the two vectors
     */
    public static double getAngleBetween(Vector v1, Vector v2) {
        /*
        Use the fact the dot product has a geometric representation too,
        namely: cos (angle) = v1 ⋅ v2 / (|v1||v2|);
        */
        double angleBetween = Math.acos(v1.dotProd(v2) / (v1.magnitude * v2.magnitude));
        return Math.toDegrees(angleBetween);
    }

    /**
     * Compares two vectors and returns whether if the vectors are orthogonal.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return if two vectors are orthogonal; boolean
     */
    public static boolean isOrthogonal(Vector v1, Vector v2) {
        /*
        since cos (angle) = v1 ⋅ v2 / (|v1||v2|),
        if cos(angle) = 0 or v1 ⋅ v2; angle = 90
        */
        return v1.dotProd(v2) == 0;
    }

    /**
     * Compares two vector objects to see if they're equal or not.
     *
     * @param other the other vector
     * @return if two vectors are equal; boolean
     */
    public boolean equals(Vector other) {
        return (x == other.x) && (y == other.y) && (z == other.z);
    }

    /**
     * Returns the string representation of the Vector object.
     *
     * @return The vector properties
     */
    @Override
    public String toString() {
        return String.format("Vector: (%.2f, %.2f, %.2f), magnitude: %.2f", x, y, z, magnitude);
    }
}