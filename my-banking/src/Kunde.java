// Ein Kästchen aus dem Klassendiagramm, eins zu eins übersetzt.
//
// Noch OHNE private, ohne Konstruktor, ohne Getter und Setter – das ist
// Absicht: Die Übung hält die Sprache klein, bis das Prinzip sitzt. Die
// Kapselung kommt im nächsten Modul, und dann wird genau diese Datei umgebaut.
public class Kunde {

    // Die Eigenschaften aus dem Kästchen werden zu Instanzvariablen.
    int nummer;
    String name;
    String wohnort;

    // Die Fähigkeit aus dem Kästchen wird zur Methode. Der Anforderungstext
    // sagt: "zieht jemand um, wird der Wohnort geändert".
    void ziehtUm(String neuerWohnort) {
        wohnort = neuerWohnort;
    }

    @Override
    public String toString() {
        return "Kunde " + nummer + " – " + name + " aus " + wohnort;
    }
}
