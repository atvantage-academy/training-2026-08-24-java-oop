package de.schulung.banking.daten;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Bank {

  private final Collection<Konto> konten = new TreeSet<>();
  private final Collection<Kunde> kunden = new HashSet<>();

  public Stream<Konto> getKonten() {
    return konten.stream();
  }

  public Optional<Konto> findeKontoByIban(String iban) {
    if(iban == null) {
      throw new IllegalArgumentException("IBAN darf nicht null sein");
    }
    return konten
      .stream()
      .filter(konto -> konto != null && konto.getIban().equals(iban))
      .findFirst();
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

  public Stream<Kunde> getKunden() {
    return kunden.stream();
  }

  public void addKunde(Kunde kunde) {
    if(kunde == null) {
      System.out.println("Kunde darf nicht null sein");
      return;
    }
    kunden.add(kunde);
  }

  public Optional<Kunde> findKundeByKundennummer(int kundenNummer) {
    return kunden
      .stream()
      .filter(kunde -> kunde != null && kunde.getNummer() == kundenNummer)
      .findFirst();
  }

  public Stream<Konto> findKontenByKunde(int kundenNummer) {
    Optional<Kunde> kunde = findKundeByKundennummer(kundenNummer);
    if(kunde.isPresent()) {
      return findKontenByKunde(kunde.get());
    } else {
      return Stream.empty();
    }
  }

  public Stream<Konto> findKontenByKunde(Kunde kunde) {
    return konten
      .stream()
      .filter(konto -> konto != null && konto.getInhaber().equals(kunde));
  }

}
