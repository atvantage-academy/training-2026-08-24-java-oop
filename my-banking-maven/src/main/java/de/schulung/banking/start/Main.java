package de.schulung.banking.start;

import de.schulung.banking.daten.Bank;
import de.schulung.banking.daten.Girokonto;
import de.schulung.banking.daten.Konto;
import de.schulung.banking.daten.Kunde;
import de.schulung.banking.daten.Sparkonto;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
      LogManager.getLogger(Main.class);

        // Zwei Objekte DERSELBEN Klasse mit unterschiedlichen Werten – daran
        // sieht man, was eine Instanzvariable ausmacht.

        Bank myBank = new Bank(200, 100);
        Bank bank2 = new Bank();

        Kunde ada = new Kunde(
          1001,
          LocalDate.of(1970, Month.JANUARY, 1)
        );
        ada.setName("Ada Lovelace");
        ada.setWohnort("London");
        myBank.addKunde(ada);

        Kunde alan = new Kunde(
          1002,
          LocalDate.of(1995, Month.JULY, 15)
        );
        alan.setName("Alan Turing");
        alan.setWohnort("Wilmslow");
        myBank.addKunde(alan);

        // Ada hat zwei Konten, Alan eines: die Multiplizität 1 zu * aus dem
        // Diagramm, hier zum ersten Mal sichtbar.
        Girokonto adaGiro = new Girokonto("DE02 1203 0000 0000 2020 51");
        adaGiro.setInhaber(ada);
        adaGiro.setDispoLimitInCent(500_00);
        myBank.addKonto(adaGiro);

        Konto adaSpar = new Sparkonto("DE02 5001 0517 0648 4898 90", 1.5);
        adaSpar.setInhaber(ada);
        myBank.addKonto(adaSpar);

        Girokonto alanGiro = new Girokonto("DE02 1001 0010 0000 0123 45");
        alanGiro.setInhaber(alan);
        alanGiro.setDispoLimitInCent(50_00);
        myBank.addKonto(alanGiro);

        System.out.println("--- Kundschaft ---");
        System.out.println(ada);
        System.out.println(alan);

        System.out.println();
        System.out.println("--- Einzahlen und abheben ---");
        adaGiro.einzahlen(150_00);
        adaSpar.einzahlen(2_500_00);
        alanGiro.einzahlen(80_00);
        System.out.println(adaGiro);
        System.out.println(adaSpar);
        System.out.println(alanGiro);

        // Abheben bis zur Höhe des Guthabens: geht.
        adaGiro.abheben(650_00);
        System.out.println("Nach Abhebung von 650,00 €: " + adaGiro);

        // Mehr abheben, als da ist: passiert nichts, der Stand bleibt gültig.
        adaGiro.abheben(999_00);
        System.out.println("Nach Versuch über 999,00 €: " + adaGiro);

        System.out.println();
        System.out.println("--- Umzug ---");
        System.out.println("vorher:  " + ada);
        ada.ziehtUm("Paris");
        System.out.println("nachher: " + ada);

        // Die Referenz zeigt auf DASSELBE Objekt, nicht auf eine Kopie: Beide
        // Konten von Ada geben nach dem Umzug den neuen Wohnort her.
        System.out.println("Inhaberin des Sparkontos wohnt jetzt in: " + adaSpar.getInhaber().getWohnort());

        // ada.setNummer(999);
        System.out.println(adaGiro.getStandInCent());
        // adaGiro.standInCent = -2000;
        // adaGiro.setStandInCent(-2000);

    }
}
