package de.schulung.banking.daten;

public class Girokonto extends Konto {

  private long dispoLimitInCent;

  public Girokonto(String iban) {
    super(iban);
  }

  public boolean isAbhebenMöglich(long betragInCent) {
    return getStandInCent() - betragInCent >= -dispoLimitInCent;
  }

  public long getDispoLimitInCent() {
    return dispoLimitInCent;
  }

  public void setDispoLimitInCent(long dispoLimitInCent) {
    this.dispoLimitInCent = dispoLimitInCent;
  }
}
