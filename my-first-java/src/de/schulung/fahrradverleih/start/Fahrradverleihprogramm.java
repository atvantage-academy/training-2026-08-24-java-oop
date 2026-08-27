package de.schulung.fahrradverleih.start;

import de.schulung.fahrradverleih.daten.Ausleihe;
import de.schulung.fahrradverleih.daten.Fahrrad;
import de.schulung.fahrradverleih.daten.Kunde;

public class Fahrradverleihprogramm {

  static void main() {
    Fahrrad eBike = new Fahrrad("12345", "E-Bike");
    eBike.setTagespreis(20);

    Fahrrad mountainBike = new Fahrrad("22222", "Mountain Bike");
    mountainBike.setTagespreis(15);

    Kunde olaf = new Kunde();
    olaf.setName("Olaf");
    olaf.setTelefonnummer("+49-172-555-8963");

    Kunde heidi = new Kunde();
    heidi.setName("Heidi");
    heidi.setTelefonnummer("+49-170-1234-567");

    Ausleihe olafMitEbike = new Ausleihe(olaf, eBike);

    Ausleihe heidiMitMountainBike = new Ausleihe(heidi, mountainBike);

    olafMitEbike.beginnen();
    heidiMitMountainBike.beginnen();

    heidiMitMountainBike.beenden();

    System.out.println(heidiMitMountainBike);
    System.out.println(olafMitEbike);

    System.out.println(heidiMitMountainBike.getFahrrad());
    System.out.println(mountainBike);

  }

}
