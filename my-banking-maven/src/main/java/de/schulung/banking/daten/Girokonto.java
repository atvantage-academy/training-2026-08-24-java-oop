package de.schulung.banking.daten;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Girokonto extends Konto {

  private long dispoLimitInCent;

  public Girokonto(String iban) {
    super(iban);
  }

  public boolean isAbhebenMöglich(long betragInCent) {
    return getStandInCent() - betragInCent >= -dispoLimitInCent;
  }

}
