
/**
 * Represents the type of a partner.
 */
class PartnerType {
    private String name;
    private int discount; // in percent

    /**
     * Constructor for PartnerType.
     * @param name the name of the partner type
     * @param discount the discount percentage for this partner type
     */
    public PartnerType(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    /**
     * Retrieves the name of the partner type.
     * @return the name of the partner type
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the partner type.
     * @param name the name of the partner type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the discount percentage for this partner type.
     * @return the discount percentage
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets the discount percentage for this partner type.
     * @param discount the discount percentage
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}