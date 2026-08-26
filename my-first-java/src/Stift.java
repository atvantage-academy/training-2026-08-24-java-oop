public class Stift {

  String farbe;
  int länge;
  int gewicht;
  Tisch position;

  void schreiben() {
    schreiben("Krickelkrakl");
  }

  void schreiben(String text) {
    System.out.println(text + " in " + farbe);
  }

}
