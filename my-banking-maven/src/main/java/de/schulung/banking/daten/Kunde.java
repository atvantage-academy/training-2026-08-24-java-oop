package de.schulung.banking.daten;

import java.time.LocalDate;
import java.util.Objects;

// Ein Kästchen aus dem Klassendiagramm, eins zu eins übersetzt.
//
// Noch OHNE private, ohne Konstruktor, ohne Getter und Setter – das ist
// Absicht: Die Übung hält die Sprache klein, bis das Prinzip sitzt. Die
// Kapselung kommt im nächsten Modul, und dann wird genau diese Datei umgebaut.
public class Kunde {

    // Die Eigenschaften aus dem Kästchen werden zu Instanzvariablen.
    private final int nummer;
    private final LocalDate birthdate;
    private String name;
    private String wohnort;

    public Kunde(int nummer, LocalDate birthdate) {
      this.nummer = nummer;
      this.birthdate = birthdate;
    }


  // Die Fähigkeit aus dem Kästchen wird zur Methode. Der Anforderungstext
    // sagt: "zieht jemand um, wird der Wohnort geändert".
    public void ziehtUm(String neuerWohnort) {
        setWohnort(neuerWohnort);
    }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Kunde kunde = (Kunde) o;
    return nummer == kunde.nummer;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nummer);
  }

  @Override
    public String toString() {
        return "de.schulung.banking.daten.Kunde " + getNummer() + " – " + getName() + " aus " + getWohnort();
    }

  public int getNummer() {
    return nummer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWohnort() {
    return wohnort;
  }

  public void setWohnort(String wohnort) {
    this.wohnort = wohnort;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

}
