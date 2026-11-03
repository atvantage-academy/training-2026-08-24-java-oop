package de.schulung.banking.daten;

public class KontoExistiertSchonException extends Exception {

  private final Konto konto;

  public KontoExistiertSchonException(Konto konto) {
    super("Konto mit IBAN " + konto.getIban() + " existiert bereits.");
    this.konto = konto;
  }

  public Konto getKonto() {
    return konto;
  }
}
