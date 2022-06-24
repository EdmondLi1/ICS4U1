public class Magazine extends Item {
    private String genre;
    private int numOfPages;

    /**
     * Constructor which instantiates a Magazine object with the given parameters.
     *
     * @param title the title
     * @param author the author
     * @param year year of publication
     * @param genre genre of magazine
     * @param numOfPages number of pages
     */
    public Magazine(String title, String author, int year,
                    String genre, int numOfPages) {
        super(title, author, year);
        this.genre = genre;
        this.numOfPages = numOfPages;
    }

    /**
     * Returns the genre of the Magazine.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the number of pages of the Magazine.
     *
     * @return number of pages
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * Sets the genre of the Magazine to the given new one.
     *
     * @param genre new genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets the number of pages of the Magazine, given the new one.
     *
     * @param numOfPages new number of pages
     */
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * Checks if the two Magazine's genres are the same.
     *
     * @param m other Magazine
     * @return whether the magazines have the same genre
     */
    public boolean sameGenre(Magazine m) {
        return genre.equals(m.genre);
    }

    /**
     * Checks if the current Magazine is longer than the other one.
     *
     * @param m other Magazine
     * @return whether current Magazine is longer than other one
     */
    public boolean isLongerThan(Magazine m) {
        return numOfPages > m.numOfPages;
    }

    /**
     * Checks if two Magazine objects sare equal based on their title, author, and length.
     *
     * @param o other Magazine
     * @return whether two Magazines are equal
     */
    public boolean equals(Item o) {
        if (o instanceof Magazine) {
            // check if the title, author, and pg length are the same.
            return (((Magazine) o).title.equals(title) &&
                    ((Magazine) o).author.equals(author) &&
                    ((Magazine) o).numOfPages == numOfPages);
        }
        return false;
    }

    /**
     * String representation of the Magazine object.
     *
     * @return the Magazine's details
     */
    @Override
    public String toString() {
        return super.toString()  + ", Genre: " + genre + ", Pages: " + numOfPages;
    }
}