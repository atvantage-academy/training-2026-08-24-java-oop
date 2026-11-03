package de.schulung.banking.daten;

public class KontoNichtGedecktException extends Exception {

  private final Konto konto;
  private final long betragInCent;

  public KontoNichtGedecktException(Konto konto, long betragInCent) {
    super("Konto nicht gedeckt");
    this.konto = konto;
    this.betragInCent = betragInCent;
  }

  public Konto getKonto() {
    return konto;
  }

  public long getBetragInCent() {
    return betragInCent;
  }

}
