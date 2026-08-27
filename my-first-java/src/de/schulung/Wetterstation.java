package de.schulung;

public class Wetterstation {

  public static void main(String[] args) {
    int[] woche = {17, 24, 19, 22, 25, 18, 21};
    int[] keineMessung = {};

    System.out.println("Durchschnitt: " + durchschnitt(woche));
    System.out.println("Durchschnitt: " + durchschnitt(keineMessung));

    if (Double.isNaN(durchschnitt(keineMessung))) {

    }

  }

  static double durchschnitt(int[] messwerte) {
    return durchschnitt(messwerte, 0);
  }

  // Gleicher Name, andere Parameterliste – das ist Überladen.
  // Die Berechnung wird nicht kopiert, sondern aufgerufen.
  static double durchschnitt(int[] messwerte, double standardwert) {
    if (messwerte.length == 0) {
      return standardwert;
    }

    int summe = 0;
    for (int wert : messwerte) {
      summe += wert;
    }

    return (double) summe / messwerte.length;
  }
}

// Ausgabe: Durchschnitt: 20.857142857142858
//          Durchschnitt: 0.0