public class DVD extends Item {
    private double capacity;
    private double duration;

    /**
     * Constructor which instantiates a DVD object with the given parameters.
     *
     * @param title DVD title
     * @param author author's name
     * @param year year of publication
     * @param capacity DVDs information capacity
     * @param duration the duration of the DVD
     */
    public DVD(String title, String author, int year,
               double capacity, double duration) {
        super(title, author, year);
        this.capacity = capacity;
        this.duration = duration;
    }

    /**
     * Returns the capacity of the DVD.
     *
     * @return capacity of the DVD
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Return the duration of the DVD.
     *
     * @return duration of the DVD
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets the capacity of the DVD with the given new one.
     *
     * @param capacity new capacity
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Sets the duration of the DVD with the given new one
     *
     * @param duration new duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Checks if the current DVD is bigger (capacity-wise) than the other one.
     *
     * @param d other DVD
     * @return whether current DVD is bigger than other one
     */
    public boolean isBiggerThan(DVD d) {
        return capacity > d.capacity;
    }

    /**
     * Checks if the current DVD is longer than the other one.
     *
     * @param d other DVD
     * @return whether current DVD is longer than the other one
     */
    public boolean isLongerThan(DVD d) {
        return duration > d.duration;
    }

    /**
     * Checks if two DVDs are equal based on their title, capacity, and duration.
     *
     * @param o other DVD
     * @return whether two DVDs are equal
     */
    public boolean equals(Item o) {
        if (o instanceof DVD) {
            // check if the title, author, and pg length are the same.
            return (((DVD) o).title.equals(title) &&
                    ((DVD) o).capacity == capacity &&
                    ((DVD) o).duration == duration);
        }
        return false;
    }

    /**
     * String representation of the DVD object.
     *
     * @return the DVD's details
     */
    @Override
    public String toString() {
        return super.toString()  + ", Capacity: " + capacity + ", Duration: " + duration;
    }
}