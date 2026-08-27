package de.schulung.fahrradverleih.daten;

public class Fahrrad {

  private final String rahmennummer;
  private final String typ;
  private int tagespreis;

  public Fahrrad(String rahmennummer, String typ) {
    this.rahmennummer = rahmennummer;
    this.typ = typ;
  }

  @Override
  public String toString() {
    return "de.schulung.fahrradverleih.daten.Fahrrad{" +
      "rahmennummer='" + getRahmennummer() + '\'' +
      ", typ='" + getTyp() + '\'' +
      '}';
  }

  public String getRahmennummer() {
    return rahmennummer;
  }

  public String getTyp() {
    return typ;
  }

  public int getTagespreis() {
    return tagespreis;
  }

  public void setTagespreis(int tagespreis) {
    this.tagespreis = tagespreis;
  }
}
