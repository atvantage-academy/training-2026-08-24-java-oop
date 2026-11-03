package de.schulung.banking.daten;

public enum KontoStatus {

  AKTIV(true),
  GESPERRT(false),
  GESCHLOSSEN(false);

  private final boolean kontoBewegungErlaubt;

  KontoStatus(boolean kontoBewegungErlaubt) {
    this.kontoBewegungErlaubt = kontoBewegungErlaubt;
  }

  public boolean isKontoBewegungErlaubt() {
    return kontoBewegungErlaubt;
  }
}
