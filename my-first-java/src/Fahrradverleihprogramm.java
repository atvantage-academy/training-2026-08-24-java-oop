public class Fahrradverleihprogramm {

  static void main() {
    Fahrrad eBike = new Fahrrad();
    eBike.rahmennummer = "12345";
    eBike.typ = "E-Bike";
    eBike.tagespreis = 20;

    Fahrrad mountainBike = new Fahrrad();
    mountainBike.rahmennummer = "22222";
    mountainBike.typ = "Mountain Bike";
    mountainBike.tagespreis = 15;

    Kunde olaf = new Kunde();
    olaf.name = "Olaf";
    olaf.telefonnummer = "+49-172-555-8963";

    Kunde heidi = new Kunde();
    heidi.name = "Heidi";
    heidi.telefonnummer = "+49-170-1234-567";

    Ausleihe olafMitEbike = new Ausleihe();
    olafMitEbike.kunde = olaf;
    olafMitEbike.fahrrad = eBike;

    Ausleihe heidiMitMountainBike = new Ausleihe();
    heidiMitMountainBike.kunde = heidi;
    heidiMitMountainBike.fahrrad = mountainBike;

    olafMitEbike.beginnen();
    heidiMitMountainBike.beginnen();

    heidiMitMountainBike.beenden();

    System.out.println(heidiMitMountainBike);
    System.out.println(olafMitEbike);

    System.out.println(heidiMitMountainBike.fahrrad);
    System.out.println(mountainBike);

  }

}
