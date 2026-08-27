// Das zweite Kästchen. Die Linie zum Kunden ist hier unten als Referenz
// umgesetzt: Ein Konto HAT einen Inhaber, und "hat" heisst im Code, dass eine
// Instanzvariable auf das andere Objekt zeigt.
public class Konto {

    String iban;

    // Der Stand steht als GANZE CENT in einem long. double rundet ungenau –
    // für Geld ist das untauglich. Weil die Einheit nicht aus dem Typ
    // hervorgeht, gehört sie in den Namen.
    long standInCent;

    // Aus der Linie im Diagramm wird eine Referenz. Die Multiplizität
    // "1 Konto gehört genau einem Kunden" steckt darin, dass es EIN Feld ist
    // und keine Liste.
    Kunde inhaber;

    void einzahlen(long betragInCent) {
        standInCent = standInCent + betragInCent;
    }

    // "Abheben nur, solange genug Guthaben vorhanden ist" – die Regel aus dem
    // Anforderungstext, an der Stelle geprüft, an der sie hingehört: im Konto.
    // Dass der Aufrufer nicht erfährt, wenn nichts passiert ist, ist
    // unbefriedigend. Das saubere Werkzeug dafür sind Ausnahmen, Tag 4.
    void abheben(long betragInCent) {
        if (betragInCent <= standInCent) {
            standInCent = standInCent - betragInCent;
        }
    }

    @Override
    public String toString() {
        return "Konto " + iban + " – " + standInCent + " Cent, Inhaber: " + inhaber.name;
    }
}
