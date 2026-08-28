package de.schulung.banking.daten;

// Das zweite Kästchen. Die Linie zum Kunden ist hier unten als Referenz
// umgesetzt: Ein de.schulung.banking.daten.Konto HAT einen Inhaber, und "hat" heisst im Code, dass eine
// Instanzvariable auf das andere Objekt zeigt.
public abstract class Konto {

    private final String iban;

    // Der Stand steht als GANZE CENT in einem long. double rundet ungenau –
    // für Geld ist das untauglich. Weil die Einheit nicht aus dem Typ
    // hervorgeht, gehört sie in den Namen.
    private long standInCent;

    // Aus der Linie im Diagramm wird eine Referenz. Die Multiplizität
    // "1 de.schulung.banking.daten.Konto gehört genau einem Kunden" steckt darin, dass es EIN Feld ist
    // und keine Liste.
    private Kunde inhaber;

    public Konto(String iban) {
      this.iban = iban;
    }

    public void einzahlen(long betragInCent) {
        setStandInCent(getStandInCent() + betragInCent);
    }

    private void setStandInCent(long neuerStand) {
        this.standInCent = neuerStand;
    }

    public boolean isAbhebenMöglich(long betragInCent) {
      return betragInCent <= getStandInCent();
    }

    // "Abheben nur, solange genug Guthaben vorhanden ist" – die Regel aus dem
    // Anforderungstext, an der Stelle geprüft, an der sie hingehört: im de.schulung.banking.daten.Konto.
    // Dass der Aufrufer nicht erfährt, wenn nichts passiert ist, ist
    // unbefriedigend. Das saubere Werkzeug dafür sind Ausnahmen, Tag 4.
    public void abheben(long betragInCent) {
        if (isAbhebenMöglich(betragInCent)) {
            setStandInCent(getStandInCent() - betragInCent);
        } else {
          System.out.println("Abheben nicht möglich");
        }
    }

    @Override
    public String toString() {
        return "de.schulung.banking.daten.Konto " + getIban() + " – " + getStandInCent() + " Cent, Inhaber: " + getInhaber().getName();
    }

    public String getIban() {
      return iban;
    }

    public long getStandInCent() {
      return standInCent;
    }

    public Kunde getInhaber() {
      return inhaber;
    }

    public void setInhaber(Kunde inhaber) {
      this.inhaber = inhaber;
    }
}
