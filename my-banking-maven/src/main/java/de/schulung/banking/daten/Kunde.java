package de.schulung.banking.daten;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

// Ein Kästchen aus dem Klassendiagramm, eins zu eins übersetzt.
//
// Noch OHNE private, ohne Konstruktor, ohne Getter und Setter – das ist
// Absicht: Die Übung hält die Sprache klein, bis das Prinzip sitzt. Die
// Kapselung kommt im nächsten Modul, und dann wird genau diese Datei umgebaut.
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Kunde {

    // Die Eigenschaften aus dem Kästchen werden zu Instanzvariablen.
    @EqualsAndHashCode.Include
    private final int nummer;
    private final LocalDate birthdate;
    private String name;
    private String wohnort;

  // Die Fähigkeit aus dem Kästchen wird zur Methode. Der Anforderungstext
    // sagt: "zieht jemand um, wird der Wohnort geändert".
    public void ziehtUm(String neuerWohnort) {
        setWohnort(neuerWohnort);
    }

}
