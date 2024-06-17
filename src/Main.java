import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hauptklasse für die Verwaltung der Messeflächen.
 */
public class Main {

    public static void main(String[] args) {
        Verwaltungssoftware verwaltungssoftware = new Verwaltungssoftware();
        Scanner scanner = new Scanner(System.in);

        // Beispiel Partner-Typen hinzufügen
        verwaltungssoftware.addPartnerType("Normal", 0);
        verwaltungssoftware.addPartnerType("Premium", 10);
        verwaltungssoftware.addPartnerType("Bildungseinrichtung", 100);

        while (true) {
            System.out.println("\n--- Messeverwaltungssystem ---");
            System.out.println("1. Messefläche hinzufügen");
            System.out.println("2. Partner hinzufügen");
            System.out.println("3. Preis berechnen");
            System.out.println("4. Buchung erstellen");
            System.out.println("5. Freie Flächen anzeigen");
            System.out.println("6. Messeflächen zählen");
            System.out.println("7. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Konsumiert den Zeilenumbruch

            switch (option) {
                case 1:
                    System.out.print("Größe der Messefläche (in m²): ");
                    int size = scanner.nextInt();
                    System.out.print("Preis der Messefläche: ");
                    double price = scanner.nextDouble();
                    System.out.print("Buchbar durch Bildungseinrichtung (true/false): ");
                    boolean bookableByEducationalInstitution = scanner.nextBoolean();
                    verwaltungssoftware.addMesseflaeche(new Messeflaeche(size, price, bookableByEducationalInstitution));
                    System.out.println("Messefläche hinzugefügt.");
                    break;
                case 2:
                    System.out.print("Name des Partners: ");
                    String name = scanner.next();
                    System.out.print("Anschrift des Partners: ");
                    String address = scanner.next();
                    scanner.nextLine(); // Konsumiert den Zeilenumbruch
                    List<String> specialties = new ArrayList<>();
                    System.out.print("Anzahl der Schwerpunkte: ");
                    int numSpecialties = scanner.nextInt();
                    scanner.nextLine(); // Konsumiert den Zeilenumbruch
                    for (int i = 0; i < numSpecialties; i++) {
                        System.out.print("Schwerpunkt " + (i + 1) + ": ");
                        specialties.add(scanner.nextLine());
                    }
                    System.out.print("Partner-Typ (Normal/Premium/Bildungseinrichtung): ");
                    String partnerTypeName = scanner.next();
                    PartnerType partnerType = verwaltungssoftware.getPartnerTypes().get(partnerTypeName);
                    verwaltungssoftware.addPartner(new Partner(name, address, specialties, partnerType));
                    System.out.println("Partner hinzugefügt.");
                    break;
                case 3:
                    System.out.println("Messeflächen:");
                    List<Messeflaeche> messeflaechen = verwaltungssoftware.getMesseflaechen();
                    for (int i = 0; i < messeflaechen.size(); i++) {
                        Messeflaeche messeflaeche = messeflaechen.get(i);
                        System.out.println("Index " + i + ": Größe " + messeflaeche.getSize() + "m², Preis " + messeflaeche.getPrice() + " EUR");
                    }
                    System.out.print("Index der Messefläche: ");
                    int fairgroundIndex = scanner.nextInt();
                    System.out.println("Partner:");
                    List<Partner> partners = verwaltungssoftware.getPartnerList();
                    for (int i = 0; i < partners.size(); i++) {
                        Partner partner = partners.get(i);
                        System.out.println("Index " + i + ": " + partner.getName());
                    }
                    System.out.print("Index des Partners: ");
                    int partnerIndex = scanner.nextInt();
                    Messeflaeche messeflaeche = messeflaechen.get(fairgroundIndex);
                    Partner partner = partners.get(partnerIndex);
                    double calculatedPrice = verwaltungssoftware.calculatePrice(messeflaeche, partner);
                    System.out.println("Berechneter Preis: " + calculatedPrice + " EUR");
                    break;
                case 4:
                    System.out.println("Messeflächen:");
                    List<Messeflaeche> availableAreas = verwaltungssoftware.getAvailableAreas(false);
                    for (int i = 0; i < availableAreas.size(); i++) {
                        Messeflaeche availableArea = availableAreas.get(i);
                        System.out.println("Index " + i + ": Größe " + availableArea.getSize() + "m², Preis " + availableArea.getPrice() + " EUR");
                    }
                    System.out.print("Index der Messefläche für die Buchung: ");
                    int indexToBook = scanner.nextInt();
                    System.out.println("Partner:");
                    List<Partner> partnerList = verwaltungssoftware.getPartnerList();
                    for (int i = 0; i < partnerList.size(); i++) {
                        Partner availablePartner = partnerList.get(i);
                        System.out.println("Index " + i + ": " + availablePartner.getName());
                    }
                    System.out.print("Index des Partners für die Buchung: ");
                    int partnerToBookIndex = scanner.nextInt();
                    Messeflaeche areaToBook = availableAreas.get(indexToBook);
                    Partner partnerToBook = partnerList.get(partnerToBookIndex);
                    verwaltungssoftware.createBooking(areaToBook, partnerToBook);
                    break;
                case 5:
                    System.out.println("Verfügbare Flächen für Bildungseinrichtungen:");
                    List<Messeflaeche> availableAreasForEdu = verwaltungssoftware.getAvailableAreas(true);
                    for (int i = 0; i < availableAreasForEdu.size(); i++) {
                        Messeflaeche availableArea = availableAreasForEdu.get(i);
                        System.out.println("Index " + i + ": Größe " + availableArea.getSize() + "m², Preis " + availableArea.getPrice() + " EUR");
                    }
                    System.out.println("Verfügbare Flächen für Partner:");
                    List<Messeflaeche> availableAreasNotForEdu = verwaltungssoftware.getAvailableAreas(false);
                    for (int i = 0; i < availableAreasNotForEdu.size(); i++) {
                        Messeflaeche availableArea = availableAreasNotForEdu.get(i);
                        System.out.println("Index " + i + ": Größe " + availableArea.getSize() + "m², Preis " + availableArea.getPrice() + " EUR");
                    }
                    break;
                case 6:
                    System.out.println("Anzahl der gebuchten Messeflächen: " + verwaltungssoftware.countFairgroundAreas(true));
                    System.out.println("Gesamtanzahl der Messeflächen: " + verwaltungssoftware.countFairgroundAreas(false));
                    break;
                case 7:
                    System.out.println("Programm wird beendet.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
                    break;
            }
        }
    }
}