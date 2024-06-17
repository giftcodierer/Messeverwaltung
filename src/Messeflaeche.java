/**
 * Represents a fairground area.
 */
class Messeflaeche {
    private int size;
    private double price;
    private boolean bookableByEducationalInstitution;
    private boolean booked;

    /**
     * Constructor for Messeflaeche.
     * @param size the size of the fairground area in square meters
     * @param price the price of the fairground area
     * @param bookableByEducationalInstitution whether the area can be booked by educational institutions
     */
    public Messeflaeche(int size, double price, boolean bookableByEducationalInstitution) {
        this.size = size;
        this.price = price;
        this.bookableByEducationalInstitution = bookableByEducationalInstitution;
        this.booked = false;
    }

    /**
     * Retrieves the size of the fairground area.
     * @return the size of the fairground area in square meters
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the fairground area.
     * @param size the size of the fairground area in square meters
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Retrieves the price of the fairground area.
     * @return the price of the fairground area
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the fairground area.
     * @param price the price of the fairground area
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Checks if the fairground area is bookable by educational institutions.
     * @return true if bookable by educational institutions, false otherwise
     */
    public boolean isBookableByEducationalInstitution() {
        return bookableByEducationalInstitution;
    }

    /**
     * Sets whether the fairground area is bookable by educational institutions.
     * @param bookableByEducationalInstitution true if bookable, false otherwise
     */
    public void setBookableByEducationalInstitution(boolean bookableByEducationalInstitution) {
        this.bookableByEducationalInstitution = bookableByEducationalInstitution;
    }

    /**
     * Checks if the fairground area is booked.
     * @return true if booked, false otherwise
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * Sets whether the fairground area is booked.
     * @param booked true if booked, false otherwise
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}