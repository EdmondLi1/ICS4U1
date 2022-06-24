public abstract class Item implements Comparable<Item> {
    protected String title;
    protected String author;
    protected int year;

    /**
     * Constructor which instantiates an Item object with the given parameters.
     *
     * @param title the title of the Item
     * @param author the author
     * @param year year of publication
     */
    public Item(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * Returns the title of the Item.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the Item.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the year of publication of the Item.
     *
     * @return year of publication
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the title of the Item, given the new title.
     *
     * @param title new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the Item, given the new author.
     *
     * @param author new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the year of publication of the Item, given the new year.
     *
     * @param year new year of publication
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Checks if the current Item is older than the other Item.
     *
     * @param o other Item
     * @return whether the current item is older than other one
     */
    public boolean isOlderThan(Item o) {
        return o.year == year;
    }

    /**
     * Comparator method which gives a numeric value for alphabetical sorting.
     * Negative if less, Positive if more (alphabetically).
     *
     * @param o other Item
     * @return The value corresponding the Item's alphabetized position
     */
    public int compareTo(Item o) {
        return this.title.compareTo(o.title);
    }

    /**
     * Abstract method which checks if two Items are equivalent for
     * varying categories.
     *
     * @param o other Item
     * @return whether if two items are equal
     */
    abstract boolean equals(Item o);

    /**
     * String representation of the Item object.
     *
     * @return the Item's details
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publish date: " + year;
    }
}