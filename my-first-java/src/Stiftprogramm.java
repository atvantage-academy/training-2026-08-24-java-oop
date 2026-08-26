public class Stiftprogramm {

  static void main() {

    Stift kuli = new Stift();
    kuli.farbe = "blau";
    kuli.länge = 13;
    kuli.gewicht = 20;

    Stift textmarker = new Stift();
    textmarker.farbe = "grün";
    textmarker.länge = 10;
    textmarker.gewicht = 40;

    System.out.println(textmarker.farbe);
    System.out.println(kuli.gewicht);

    kuli.schreiben();
    textmarker.schreiben();

    Tisch schreibtisch = new Tisch();
    schreibtisch.farbe = "braun";
    schreibtisch.höhe = 80;
    schreibtisch.höhenVerstellbar = false;

    Tisch esstisch = new Tisch();
    esstisch.farbe = "fichte";
    esstisch.höhe = 70;
    esstisch.höhenVerstellbar = true;

    System.out.println(esstisch.farbe);
    System.out.println(schreibtisch.höhe);

    kuli.position = schreibtisch;
    //kuli.position = esstisch;

    textmarker.position = esstisch;

    kuli.position.höhe = 60;
    //esstisch.höhe = 60;
    System.out.println(textmarker.position.höhe);

  }

}
