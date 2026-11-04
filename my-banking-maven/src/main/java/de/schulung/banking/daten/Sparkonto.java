package de.schulung.banking.daten;

import lombok.Getter;

@Getter
public class Sparkonto extends Konto {

  private final double habenZins;

  public Sparkonto(String iban, double habenZins) {
    super(iban);
    this.habenZins = habenZins;
  }

}
