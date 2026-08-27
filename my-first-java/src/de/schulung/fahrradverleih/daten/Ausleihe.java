package de.schulung.fahrradverleih.daten;

import java.time.LocalDate;

public class Ausleihe {

  private final Kunde kunde;
  private final Fahrrad fahrrad;
  private LocalDate start;
  private LocalDate geplantesEnde;
  private LocalDate ende;

  public Ausleihe(Kunde kunde, Fahrrad fahrrad) {
    this.kunde = kunde;
    this.fahrrad = fahrrad;
  }

  public void beginnen() {
    setStart(LocalDate.now());
    setGeplantesEnde(getStart().plusDays(14));
    System.out.println("de.schulung.fahrradverleih.daten.Ausleihe begonnen: " + getFahrrad().getTyp() + " - " + getKunde().getName() + " - bis vorr." + getGeplantesEnde());
  }

  public void beenden() {
    setEnde(LocalDate.now());
    System.out.println("de.schulung.fahrradverleih.daten.Ausleihe beendet: " + getFahrrad().getTyp() + " - " + getKunde().getName() + " - bis " + getEnde());
  }

  @Override
  public String toString() {
    return "de.schulung.fahrradverleih.daten.Ausleihe{" +
      "kunde=" + getKunde() +
      ", fahrrad=" + getFahrrad() +
      ", start=" + getStart() +
      '}';
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getGeplantesEnde() {
    return geplantesEnde;
  }

  public void setGeplantesEnde(LocalDate geplantesEnde) {
    this.geplantesEnde = geplantesEnde;
  }

  public LocalDate getEnde() {
    return ende;
  }

  public void setEnde(LocalDate ende) {
    this.ende = ende;
  }

  public Kunde getKunde() {
    return kunde;
  }

  public Fahrrad getFahrrad() {
    return fahrrad;
  }

}
