package de.schulung.banking.daten;

public record Waehrung(
  String code,
  String name
) {

  public Waehrung {
    if (code == null || code.trim().isEmpty()) {
      throw new IllegalArgumentException("Code cannot be null or empty");
    }
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
  }

}
