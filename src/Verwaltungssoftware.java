import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages the fairground areas, partners, and bookings.
 */
public class Verwaltungssoftware {
    private List<Messeflaeche> messeflaechen;
    private List<Partner> partnerList;
    private Map<String, PartnerType> partnerTypes;

    /**
     * Constructor for Verwaltungssoftware.
     */
    public Verwaltungssoftware() {
        this.messeflaechen = new ArrayList<>();
        this.partnerList = new ArrayList<>();
        this.partnerTypes = new HashMap<>();
    }

    /**
     * Retrieves the list of fairground areas.
     * @return the list of fairground areas
     */
    public List<Messeflaeche> getMesseflaechen() {
        return messeflaechen;
    }

    /**
     * Retrieves the list of partners.
     * @return the list of partners
     */
    public List<Partner> getPartnerList() {
        return partnerList;
    }

    /**
     * Retrieves the map of partner types.
     * @return the map of partner types
     */
    public Map<String, PartnerType> getPartnerTypes() {
        return partnerTypes;
    }

    /**
     * Adds a fairground area.
     * @param messeflaeche the fairground area to add
     */
    public void addMesseflaeche(Messeflaeche messeflaeche) {
        this.messeflaechen.add(messeflaeche);
    }

    /**
     * Adds a partner.
     * @param partner the partner to add
     */
    public void addPartner(Partner partner) {
        this.partnerList.add(partner);
    }

    /**
     * Adds a partner type.
     * @param name the name of the partner type
     * @param discount the discount percentage for this partner type
     */
    public void addPartnerType(String name, int discount) {
        this.partnerTypes.put(name, new PartnerType(name, discount));
    }

    /**
     * Calculates the price for a given fairground area and partner.
     * @param messeflaeche the fairground area
     * @param partner the partner
     * @return the calculated price
     */
    public double calculatePrice(Messeflaeche messeflaeche, Partner partner) {
        if (partner.getPartnerType().getName().equals("Bildungseinrichtung")) {
            return 0;
        }
        return messeflaeche.getPrice() * (1 - partner.getPartnerType().getDiscount() / 100.0);
    }

    /**
     * Creates a booking for a given fairground area and partner.
     * @param messeflaeche the fairground area
     * @param partner the partner
     */
    public void createBooking(Messeflaeche messeflaeche, Partner partner) {
        if (!messeflaeche.isBooked()) {
            System.out.println("Buchung für Messefläche " + messeflaeche.getSize() + "m² für Partner " + partner.getName() + " erstellt.");
            messeflaeche.setBooked(true);
        } else {
            System.out.println("Messefläche ist bereits gebucht.");
        }
    }

    /**
     * Retrieves all available fairground areas.
     * @param forEducationalInstitution true if only areas bookable by educational institutions are needed, false otherwise
     * @return list of available fairground areas
     */
   /* public List<Messeflaeche> getAvailableAreas(boolean forEducationalInstitution) {
        return messeflaechen.stream()
                .filter(area -> !area.isBooked() && (!forEducationalInstitution || area.isBookableByEducationalInstitution()))
                .collect(Collectors.toList());
    }*/

    /**
     * Retrieves all available fairground areas.
     * @param forEducationalInstitution true if only areas bookable by educational institutions are needed, false otherwise
     * @return list of available fairground areas
     */
    public List<Messeflaeche> getAvailableAreas(boolean forEducationalInstitution) {
        List<Messeflaeche> availableAreas = messeflaechen.stream()
                .filter(area -> !area.isBooked())
                .collect(Collectors.toList());

        if (forEducationalInstitution) {
            availableAreas = availableAreas.stream()
                    .filter(Messeflaeche::isBookableByEducationalInstitution)
                    .collect(Collectors.toList());

            if (availableAreas.isEmpty()) {
                System.out.println("Keine freien Flächen für Bildungseinrichtungen verfügbar.");
            } else {
                System.out.println("Verfügbare Flächen für Bildungseinrichtungen:");
                for (int i = 0; i < availableAreas.size(); i++) {
                    Messeflaeche area = availableAreas.get(i);
                    System.out.println("Index " + i + ": Größe " + area.getSize() + "m², Preis " + area.getPrice() + " EUR");
                }
            }
        } else {
            System.out.println("");
            System.out.println("Alle verfügbaren Flächen:");
            for (int i = 0; i < availableAreas.size(); i++) {
                Messeflaeche area = availableAreas.get(i);
                String info = area.isBookableByEducationalInstitution() ? " (kann auch von Bildungseinrichtungen gebucht werden)" : "";
                System.out.println("Index " + i + ": Größe " + area.getSize() + "m², Preis " + area.getPrice() + " EUR" + info);
            }
        }

        return availableAreas;
    }

    /**
     * Counts the number of fairground areas.
     * @param booked true to count booked areas, false to count all areas
     * @return the number of fairground areas
     */
    public int countFairgroundAreas(boolean booked) {
        if (booked) {
            return (int) messeflaechen.stream().filter(Messeflaeche::isBooked).count();
        } else {
            return messeflaechen.size();
        }
    }
}