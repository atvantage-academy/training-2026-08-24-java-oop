package de.schulung.banking.daten;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

// Das zweite Kästchen. Die Linie zum Kunden ist hier unten als Referenz
// umgesetzt: Ein de.schulung.banking.daten.Konto HAT einen Inhaber, und "hat" heisst im Code, dass eine
// Instanzvariable auf das andere Objekt zeigt.
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public abstract class Konto implements Comparable<Konto> {

    @NonNull
    @EqualsAndHashCode.Include
    private final String iban;

    // Der Stand steht als GANZE CENT in einem long. double rundet ungenau –
    // für Geld ist das untauglich. Weil die Einheit nicht aus dem Typ
    // hervorgeht, gehört sie in den Namen.
    @Setter(AccessLevel.PRIVATE)
    private long standInCent;

    // Aus der Linie im Diagramm wird eine Referenz. Die Multiplizität
    // "1 de.schulung.banking.daten.Konto gehört genau einem Kunden" steckt darin, dass es EIN Feld ist
    // und keine Liste.
    private Kunde inhaber;

    // erlaubte Werte: aktiv, gesperrt, geschlossen
    @NonNull
    private KontoStatus status = KontoStatus.AKTIV;

    public void einzahlen(long betragInCent) {
      if(betragInCent <= 0) {
        throw new IllegalArgumentException("Einzahlungsbetrag muss positiv sein");
      }
        setStandInCent(getStandInCent() + betragInCent);
    }

    public boolean isAbhebenMöglich(long betragInCent) {
      if(betragInCent <= 0) {
        throw new IllegalArgumentException("Abhebungsbetrag muss positiv sein");
      }
      return betragInCent <= getStandInCent();
    }

    // "Abheben nur, solange genug Guthaben vorhanden ist" – die Regel aus dem
    // Anforderungstext, an der Stelle geprüft, an der sie hingehört: im de.schulung.banking.daten.Konto.
    // Dass der Aufrufer nicht erfährt, wenn nichts passiert ist, ist
    // unbefriedigend. Das saubere Werkzeug dafür sind Ausnahmen, Tag 4.
    public void abheben(long betragInCent) throws KontoNichtGedecktException {
        if(betragInCent <= 0) {
          throw new IllegalArgumentException("Abhebungsbetrag muss positiv sein");
        }
        // if(status != KontoStatus.AKTIV) {
        if(!status.isKontoBewegungErlaubt()) {
          throw new IllegalStateException("Abheben nur möglich, wenn Konto aktiv ist");
        }
        // switch (status) {
        //  case GESCHLOSSEN: case GESPERRT:
        //    throw new IllegalStateException("Abheben nicht möglich");
        // }
        if (isAbhebenMöglich(betragInCent)) {
            setStandInCent(getStandInCent() - betragInCent);
        } else {
          throw new KontoNichtGedecktException(this, betragInCent);
        }
    }

  @Override
  public int compareTo(Konto o) {
    return iban.compareTo(o.iban);
  }


}
