package de.schulung.buero.start;

import de.schulung.buero.daten.Stift;
import de.schulung.buero.daten.Tisch;

public class Stiftprogramm {

  static void main() {

    Stift kuli = new Stift();
    kuli.setFarbe("blau");
    kuli.setLänge(13);
    kuli.setGewicht(20);

    Stift textmarker = new Stift();
    textmarker.setFarbe("grün");
    textmarker.setLänge(10);
    textmarker.setGewicht(40);

    System.out.println(textmarker.getFarbe());
    System.out.println(kuli.getGewicht());

    kuli.schreiben();
    textmarker.schreiben();

    Tisch schreibtisch = new Tisch();
    schreibtisch.setFarbe("braun");
    schreibtisch.setHöhe(80);
    schreibtisch.setHöhenVerstellbar(false);

    Tisch esstisch = new Tisch();
    esstisch.setFarbe("fichte");
    esstisch.setHöhe(70);
    esstisch.setHöhenVerstellbar(true);

    System.out.println(esstisch.getFarbe());
    System.out.println(schreibtisch.getHöhe());

    kuli.setPosition(schreibtisch);
    //kuli.position = esstisch;

    textmarker.setPosition(esstisch);

    kuli.getPosition().setHöhe(60);
    //esstisch.höhe = 60;
    System.out.println(textmarker.getPosition().getHöhe());

  }

}
