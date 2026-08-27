public class Main {

    public static void main(String[] args) {
        // Zwei Objekte DERSELBEN Klasse mit unterschiedlichen Werten – daran
        // sieht man, was eine Instanzvariable ausmacht.
        Kunde ada = new Kunde();
        ada.nummer = 1001;
        ada.name = "Ada Lovelace";
        ada.wohnort = "London";

        Kunde alan = new Kunde();
        alan.nummer = 1002;
        alan.name = "Alan Turing";
        alan.wohnort = "Wilmslow";

        // Ada hat zwei Konten, Alan eines: die Multiplizität 1 zu * aus dem
        // Diagramm, hier zum ersten Mal sichtbar.
        Konto adaGiro = new Konto();
        adaGiro.iban = "DE02 1203 0000 0000 2020 51";
        adaGiro.inhaber = ada;

        Konto adaSpar = new Konto();
        adaSpar.iban = "DE02 5001 0517 0648 4898 90";
        adaSpar.inhaber = ada;

        Konto alanGiro = new Konto();
        alanGiro.iban = "DE02 1001 0010 0000 0123 45";
        alanGiro.inhaber = alan;

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
        adaGiro.abheben(50_00);
        System.out.println("Nach Abhebung von 50,00 €: " + adaGiro);

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
        System.out.println("Inhaberin des Sparkontos wohnt jetzt in: " + adaSpar.inhaber.wohnort);
    }
}
