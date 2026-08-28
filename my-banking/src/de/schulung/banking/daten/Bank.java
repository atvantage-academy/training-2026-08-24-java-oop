package de.schulung.banking.daten;

public class Bank {

  private final Konto[] konten;
  private final Kunde[] kunden;

  private int anzahlKonten = 0;
  private int anzahlKunden = 0;

  public Bank() {
    this(100, 50);
  }

  public Bank(int maximumAnzahlKonten, int maximumAnzahlKunden) {
    konten = new Konto[maximumAnzahlKonten];
    kunden = new Kunde[maximumAnzahlKunden];
  }

  public Konto[] getKonten() {
    return konten;
  }

  public void addKonto(Konto konto) {
    // TODO: Konto nur hinzufügen, wenn Inhaber bereits Kunde der Bank ist
    konten[anzahlKonten] = konto;
    anzahlKonten = anzahlKonten + 1;
    // TODO: for-Schleife, erste Stelle suchen, die null ist
  }

  public Kunde[] getKunden() {
    return kunden;
  }

  public void addKunde(Kunde kunde) {
    kunden[anzahlKunden] = kunde;
    anzahlKunden = anzahlKunden + 1;
    // TODO: for-Schleife, erste Stelle suchen, die null ist
  }

  // TODO: Schreibe eine Methode, um die Konten eines Kunden zu ermitteln

}
