package de.schulung.buero.daten;

public class Stift {

  private String farbe;
  private int länge;
  private int gewicht;
  private Tisch position;

  public void schreiben() {
    schreiben("Krickelkrakl");
  }

  void schreiben(String text) {
    System.out.println(text + " in " + getFarbe());
  }

  public String getFarbe() {
    return farbe;
  }

  public void setFarbe(String farbe) {
    this.farbe = farbe;
  }

  public int getLänge() {
    return länge;
  }

  public void setLänge(int länge) {
    this.länge = länge;
  }

  public int getGewicht() {
    return gewicht;
  }

  public void setGewicht(int gewicht) {
    this.gewicht = gewicht;
  }

  public Tisch getPosition() {
    return position;
  }

  public void setPosition(Tisch position) {
    this.position = position;
  }
}
