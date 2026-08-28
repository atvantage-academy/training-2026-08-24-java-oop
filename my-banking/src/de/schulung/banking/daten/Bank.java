package de.schulung.banking.daten;

public class Bank {

  private final Konto[] konten;
  private final Kunde[] kunden;

  // private int anzahlKonten = 0;
  // private int anzahlKunden = 0;

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
    boolean isKundeDerBank = findKundeByKundennummer(konto.getInhaber().getNummer()) != null;
    // Konto nur hinzufügen, wenn Inhaber bereits Kunde der Bank ist
    if(isKundeDerBank) {
      // konten[anzahlKonten] = konto;
      // anzahlKonten = anzahlKonten + 1;
      // for-Schleife, erste Stelle suchen, die null ist
      for(int i=0; i< konten.length; i++) {
        if(konten[i] == null) {
          konten[i] = konto;
          break;
        }
      }
      System.out.println("Die Bank ist leider schon voll. Kein weiteres Konto möglich.");
    } else {
      System.out.println("Inhaber des Kontos ist NICHT Kunde der Bank");
    }
  }

  public Kunde[] getKunden() {
    return kunden;
  }

  public void addKunde(Kunde kunde) {
    // kunden[anzahlKunden] = kunde;
    // anzahlKunden = anzahlKunden + 1;
    // for-Schleife, erste Stelle suchen, die null ist
    for(int i=0; i< kunden.length; i++) {
      if(kunden[i] == null) {
        kunden[i] = kunde;
        break;
      }
    }
    System.out.println("Die Bank ist leider schon voll. Kein weiterer Kunde möglich.");
  }

  public Kunde findKundeByKundennummer(int kundenNummer) {
    for(Kunde kunde : kunden) {
      // && - logisches UND
      // wenn erster Ausdruck falsch -> zweiter Ausdruck wird NICHT ausgewertet
      // || - logisches OR
      // ! - NOT
      // z.B. !x && y || z
      if(kunde != null && kunde.getNummer() == kundenNummer) {
          return kunde;
      }
    }
    return null;
  }

  public Konto[] findKontenByKunde(int kundenNummer) {
    Kunde kunde = findKundeByKundennummer(kundenNummer);
    if(kunde != null) {
      return findKontenByKunde(kunde);
    } else {
      return new Konto[0];
    }
  }

  public Konto[] findKontenByKunde(Kunde kunde) {
    // Logik

    Konto[] result = new Konto[konten.length];
    int index = 0;
    for(Konto konto: konten) {
      // if(konto.getInhaber().getNummer() == kunde.getNummer()) {
      if(konto != null && konto.getInhaber().equals(kunde)) {
        result[index] = konto;
        index = index +1;
      }
    }

    // Array ist so groß wie die gesamte Anzahl an Konten
    // Rückgabewert ist das Array mit Konten UND leeren Feldern
    // z.B. { konto1, konto2, null, null, null, ....}
    //return result;

    Konto[] besseresResult = new Konto[index];
    // gefundene Einträge kopieren
    // for(int i=0; i < index; i++) {
    //   besseresResult[i] = result[i];
    // }
    if(index > 0) {
      System.arraycopy(result, 0, besseresResult, 0, index);
    }

    return besseresResult;

  }

}
