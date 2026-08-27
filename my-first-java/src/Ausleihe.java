import java.time.LocalDate;
import java.util.Date;

public class Ausleihe {

  LocalDate start;
  LocalDate geplantesEnde;
  LocalDate ende;
  Kunde kunde;
  Fahrrad fahrrad;

  void beginnen() {
    start = LocalDate.now();
    geplantesEnde = start.plusDays(14);
    System.out.println("Ausleihe begonnen: " + fahrrad.typ + " - " + kunde.name + " - bis vorr." + geplantesEnde);
  }

  void beenden() {
    ende = LocalDate.now();
    System.out.println("Ausleihe beendet: " + fahrrad.typ + " - " + kunde.name + " - bis " + ende);
  }

  @Override
  public String toString() {
    return "Ausleihe{" +
      "kunde=" + kunde +
      ", fahrrad=" + fahrrad +
      ", start=" + start +
      '}';
  }
}
