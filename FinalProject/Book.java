public class Book extends Item {
    private String bookType;
    private String genre;
    private long isbn;
    private int numOfPages;

    /**
     * Constructor which instantiates a Book with the given parameters.
     *
     * @param title title of Book
     * @param author author of Book
     * @param year year of publication
     * @param bookType type of book (fiction or non-fiction)
     * @param genre genre of book
     * @param isbn identification system of the book (13-digits)
     * @param numOfPages number of pages
     */
    public Book(String title, String author, int year, String bookType,
                String genre, long isbn, int numOfPages) {
        super(title, author, year);
        this.bookType = bookType;
        this.genre = genre;
        this.isbn = isbn;
        this.numOfPages = numOfPages;
    }

    /**
     * Returns the book type (fiction/non-fiction).
     *
     * @return the book type
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * Returns the genre of the book.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Returns the ISBN of the book.
     *
     * @return the isbn of the book
     */
    public long getIsbn() {
        return isbn;
    }


    /**
     * Returns the number of pages of the book.
     *
     * @return the number of pages of the book.
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * Sets the book type, given the new book type.
     *
     * @param bookType new book type
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    /**
     * Sets the genre of the book, given the new genre.
     *
     * @param genre new genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets the isbn of the book, given the new isbn.
     *
     * @param isbn new isbn
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     * Sets the number of pages for the book, given the new number of pages.
     *
     * @param numOfPages new number of pages
     */
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * Checks if two books have the same genre.
     *
     * @param b other Book
     * @return if two books have the same genre
     */
    public boolean sameGenre(Book b) {
        return genre.equals(b.genre);
    }

    /**
     * Checks if two books have the same book type.
     *
     * @param b other Book
     * @return if the two books have the same book type
     */
    public boolean sameBookType(Book b) {
        return bookType.equals(b.bookType);
    }

    /**
     * Checks if the current book is longer than the other book.
     *
     * @param b other Book
     * @return if the current book is longer than the other book
     */
    public boolean isLongerThan(Book b) {
        return numOfPages > b.numOfPages;
    }

    /**
     * Method which checks if two Books are equivalent (based on unique ISBN)
     *
     * @param o other Book
     * @return whether if two books are equal
     */
    public boolean equals(Item o) {
        if (o instanceof Book) {
            // isbns are always unique
            // That means the paper-format, digital, illustrated or translated versions of the same book have different ISBNs.
            return ((Book) o).isbn == isbn;
        }
        return false;
    }

    /**
     * Returns the string representation of the Book.
     *
     * @return the book's details
     */
    @Override
    public String toString() {
        return super.toString() + ", Type: " + bookType + ", Genre: " + genre
                + ", ISBN: " + isbn + ", Pages: " + numOfPages;
    }
}