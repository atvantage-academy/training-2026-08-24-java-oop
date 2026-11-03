package de.schulung.banking.daten;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Bank {

  private final Collection<Konto> konten = new TreeSet<>();
  private final Collection<Kunde> kunden = new HashSet<>();

  public Collection<Konto> getKonten() {
    return Collections.unmodifiableCollection(konten);
  }

  public Konto findeKontoByIban(String iban) {
    if(iban == null) {
      throw new IllegalArgumentException("IBAN darf nicht null sein");
    }
    for (Konto konto : konten) {
      if (konto != null && konto.getIban().equals(iban)) {
        return konto;
      }
    }
    return null;
  }

  public void addKonto(Konto konto) throws UnbekannterInhaberException, KontoExistiertSchonException {
    if(konto == null) {
      throw new IllegalArgumentException("Konto darf nicht null sein");
    }
    if(konto.getInhaber() == null) {
      throw new IllegalArgumentException("Inhaber darf nicht null sein");
    }
    // Duplikate finden: Versuch mit add(..) -> false
    boolean isKundeDerBank = findKundeByKundennummer(konto.getInhaber().getNummer()) != null;
    // Konto nur hinzufügen, wenn Inhaber bereits Kunde der Bank ist
    if(isKundeDerBank) {
      if(!konten.add(konto)) {
        throw new KontoExistiertSchonException(konto);
      }
    } else {
      throw new UnbekannterInhaberException(konto.getInhaber());
    }
  }

  public Collection<Kunde> getKunden() {
    return Collections.unmodifiableCollection(kunden);
  }

  public void addKunde(Kunde kunde) {
    if(kunde == null) {
      System.out.println("Kunde darf nicht null sein");
      return;
    }
    kunden.add(kunde);
  }

  public Kunde findKundeByKundennummer(int kundenNummer) {
    for(Kunde kunde : kunden) {
      // && - logisches UND
      // wenn erster Ausdruck falsch -> zweiter Ausdruck wird NICHT ausgewertet
      // || - logisches OR
      // ! - NOT
      // z.B. !x && y || z
      if(kunde.getNummer() == kundenNummer) {
          return kunde;
      }
    }
    return null;
  }

  public Collection<Konto> findKontenByKunde(int kundenNummer) {
    Kunde kunde = findKundeByKundennummer(kundenNummer);
    if(kunde != null) {
      return findKontenByKunde(kunde);
    } else {
      return Collections.emptyList();
    }
  }

  public Collection<Konto> findKontenByKunde(Kunde kunde) {
    // Logik

    Collection<Konto> result = new ArrayList<>();
    for(Konto konto: konten) {
      // if(konto.getInhaber().getNummer() == kunde.getNummer()) {
      if(konto != null && konto.getInhaber().equals(kunde)) {
        result.add(konto);
      }
    }
    return result;

  }

}
