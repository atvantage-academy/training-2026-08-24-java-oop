package de.schulung.fahrradverleih.daten;

public class Kunde {

  private String name;
  private String telefonnummer;

  @Override
  public String toString() {
    return getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelefonnummer() {
    return telefonnummer;
  }

  public void setTelefonnummer(String telefonnummer) {
    this.telefonnummer = telefonnummer;
  }
}
