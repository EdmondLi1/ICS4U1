import java.util.ArrayList;

public class Client extends Person {
    private ArrayList<Item> checkout;
    private long libraryId;
    private int pin;

    /**
     * Constructor which instantiates a Client object with the given parameters.
     *
     * @param firstName the Client's first name
     * @param lastName the Client's last name
     * @param age the Client's age
     * @param libraryId the Client's library id
     * @param pin the Client's pin
     */
    public Client(String firstName, String lastName, int age,
                  long libraryId, int pin) {
        super(firstName, lastName, age);
        checkout = new ArrayList<>();
        this.libraryId = libraryId;
        this.pin = pin;
    }

    /**
     * Returns the Client's checkout list.
     *
     * @return checkout list
     */
    public ArrayList<Item> getCheckout() {
        return checkout;
    }

    /**
     * Returns the library Id of the client.
     *
     * @return library id
     */
    public long getLibraryId() {
        return libraryId;
    }

    /**
     * Returns the pin of the client.
     *
     * @return the client's pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * Adds the item to the checkout list.
     *
     * @param o Item to be added
     */
    public void checkout(Item o) {
        checkout.add(o);
    }

    /**
     * Checks if the item exists in the checkout list; if so, removes it from the list.
     *
     * @param o Item to be removed
     */
    public void checkin(Item o) {
        boolean inList = false;

        // checks if item is in list; cannot concurrently modify it
        for (Item item : checkout) {
            if (item.equals(o)) {
                inList = true;
            }
        }
        // if in list, remove now
        if (inList) {
            checkout.remove(o);
        }
        else {
            System.out.println("Item not in list.\n");
        }
    }

    /**
     * Sets the Client's library id to the given new library id.
     *
     * @param libraryId new library id
     */
    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
    }

    /**
     * Sets the Client's pin to the given new pin.
     * @param pin new pin
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * Checks if two Clients are equal based on their library id and pin.
     *
     * @param p other Client to compare
     * @return if the two clients are equal
     */
    public boolean equals(Person p) {
        if (p instanceof Client) {
            return (((Client) p).libraryId == libraryId && ((Client) p).pin == pin);
        }
        return false;
    }

    /**
     * String representation of the Client object.
     *
     * @return the Client's details
     */
    @Override
    public String toString() {
        return super.toString() + ", ID: " + libraryId;
    }
}