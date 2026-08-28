package de.schulung.banking.daten;

public class Sparkonto extends Konto {

  private final double habenZins;

  public Sparkonto(String iban, double habenZins) {
    super(iban);
    this.habenZins = habenZins;
  }

  public double getHabenZins() {
    return habenZins;
  }
}
