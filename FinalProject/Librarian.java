
public class Librarian extends Person {
    private long libraryId;
    private String password;

    /**
     * Constructor which instantiates a Librarian object with the given parameters.
     *
     * @param firstName first name
     * @param lastName last name
     * @param age age of librarian
     * @param libraryId library id (14-digits)
     * @param password password for the librarian
     */
    public Librarian(String firstName, String lastName, int age,
                     long libraryId, String password) {
        super(firstName, lastName, age);
        this.libraryId = libraryId;
        this.password = password;
    }

    /**
     * Returns the library id of the Librarian.
     *
     * @return library id
     */
    public long getLibraryId() {
        return libraryId;
    }

    /**
     * Returns the password of the Librarian.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the Librarian's library id, given the new library id.
     *
     * @param libraryId new library id
     */
    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
    }

    /**
     * Sets the Librarian's password, given the new password.
     *
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks whether two Librarians are equal based on their library id and
     * password.
     *
     * @param p other Librarian
     * @return whether two Librarians are equal
     */
    public boolean equals(Person p) {
        if (p instanceof Librarian) {
            return (((Librarian) p).libraryId == libraryId &&
                    ((Librarian) p).password.equals(password));
        }
        return false;
    }

    /**
     * String representation of the Librarian object.
     *
     * @return the Librarian's details
     */
    @Override
    public String toString() {
        return super.toString() + ", ID: " + libraryId;
    }
}