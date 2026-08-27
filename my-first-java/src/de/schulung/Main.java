package de.schulung;

public class Main {


  static void main() {

    int temperatur = ermittleTemperatur();
    temperaturAnsage(temperatur);

    temperaturAnsage(ermittleTemperatur());

    String wort = temperaturAlsWort(20);
    System.out.println(wort);

    System.out.println(temperaturAlsWort(20));

    int tag = 3;

    String tagAlsWort = tagesAnzeige(tag);
    System.out.println(tagAlsWort);


    int[] beträge = {1, 5, 7, 2, 8};

    for (int i = 0; i < beträge.length; i++) {
      System.out.println(beträge[i]);
    }


    for (int i = 1; i <= 5; i++) {
      System.out.println(i);
    }

    for (int i = 0; i < beträge.length; i++) {
      beträge[i] = 1;
    }
    beträge = new int[]{1, 1, 1};

    for (int betrag : beträge) {
      betrag = 1;
    }


    int summe = 0;

    for (int i = 1; i <= 10; i++) {
      summe = summe + i;
    }

    System.out.println("Summe 1 bis 10: " + summe);

  }

  private static String tagesAnzeige(int tag) {
    return switch (tag) {
      case 1 -> "Montag";
      case 6, 7 -> "Wochenende";
      default -> "ein anderer Wochentag";
    };
  }

  private static int ermittleTemperatur() {
    return 30;
  }

  private static void temperaturAnsage(int temperatur) {
    if (temperatur < 0) {
      System.out.println("frostig");
    } else if (temperatur < 15) {
      System.out.println("kühl");
    } else if (temperatur < 25) {
      System.out.println("mild");
    } else {
      System.out.println("heiß");
    }
  }

  private static String temperaturAlsWort(int temperatur) {
    if (temperatur < 0) {
      return "frostig";
    }
    if (temperatur < 15) {
      return "kühl";
    }
    if (temperatur < 25) {
      return "mild";
    }
    return "heiß";

  }

}
