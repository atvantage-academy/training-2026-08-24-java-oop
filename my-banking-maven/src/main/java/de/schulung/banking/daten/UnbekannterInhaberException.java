package de.schulung.banking.daten;

public class UnbekannterInhaberException extends Exception {

  private final Kunde kunde;

  public UnbekannterInhaberException(Kunde kunde) {
    this("Inhaber des Kontos ist NICHT Kunde der Bank", kunde);
  }

  public UnbekannterInhaberException(String message, Kunde kunde) {
    super(message);
    this.kunde = kunde;
  }

  public Kunde getKunde() {
    return kunde;
  }

}
