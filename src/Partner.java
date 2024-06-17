import java.util.List;

/**
 * Represents a partner participating in the fair.
 */
class Partner {
    private String name;
    private String address;
    private List<String> specialties;
    private PartnerType partnerType;

    /**
     * Constructor for Partner.
     * @param name the name of the partner
     * @param address the address of the partner
     * @param specialties the list of specialties of the partner
     * @param partnerType the type of the partner
     */
    public Partner(String name, String address, List<String> specialties, PartnerType partnerType) {
        this.name = name;
        this.address = address;
        this.specialties = specialties;
        this.partnerType = partnerType;
    }

    /**
     * Retrieves the name of the partner.
     * @return the name of the partner
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the partner.
     * @param name the name of the partner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the partner.
     * @return the address of the partner
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the partner.
     * @param address the address of the partner
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the list of specialties of the partner.
     * @return the list of specialties
     */
    public List<String> getSpecialties() {
        return specialties;
    }

    /**
     * Sets the list of specialties of the partner.
     * @param specialties the list of specialties
     */
    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    /**
     * Retrieves the type of the partner.
     * @return the type of the partner
     */
    public PartnerType getPartnerType() {
        return partnerType;
    }

    /**
     * Sets the type of the partner.
     * @param partnerType the type of the partner
     */
    public void setPartnerType(PartnerType partnerType) {
        this.partnerType = partnerType;
    }
}
