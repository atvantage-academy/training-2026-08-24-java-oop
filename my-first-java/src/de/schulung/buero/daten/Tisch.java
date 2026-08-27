package de.schulung.buero.daten;

public class Tisch {

  private String farbe;
  private int höhe;
  private boolean höhenVerstellbar;

  void abräumen() {
    System.out.println("Räume ab");
  }

  public String getFarbe() {
    return farbe;
  }

  public void setFarbe(String farbe) {
    this.farbe = farbe;
  }

  public int getHöhe() {
    return höhe;
  }

  public void setHöhe(int höhe) {
    this.höhe = höhe;
  }

  public boolean isHöhenVerstellbar() {
    return höhenVerstellbar;
  }

  public void setHöhenVerstellbar(boolean höhenVerstellbar) {
    this.höhenVerstellbar = höhenVerstellbar;
  }
}
