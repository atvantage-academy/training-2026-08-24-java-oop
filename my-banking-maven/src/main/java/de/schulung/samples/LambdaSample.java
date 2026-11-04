package de.schulung.samples;

public class LambdaSample {

  // Lambdas = verzögerte Ausführung (WENN ... DANN ...)

  static double add(double d1, double d2) {
    return d1 + d2;
  }

  static double add2() {
    double result = 0.0;
    while(result <= 10) {
      result = result + Math.random();
    }
    return result;
  }

  // Funktionales Interface: exakt eine abstrakte Methode
  @FunctionalInterface
  interface NumberGenerator {
    double generate();
  }

  static double add3(NumberGenerator numberGenerator) {
    double result = 0.0;
    while(result <= 10) {
      result = result + numberGenerator.generate();
    }
    return result;
  }

  public static void main(String[] args) {
    // Addiere 2 Zahlen
    System.out.println(add(1.3, 5.7));
    // Addiere 2 Zufallszahlen
    System.out.println(add(Math.random(), Math.random()));
    // Addiere Zufallszahlen so lange, bis die Summe > 10
    System.out.println(add2());
    // Math.random() soll in main() stehen (Verantwortlichkeit)
    System.out.println(add3(new NumberGenerator(){

      @Override
      public double generate() {
        return Math.random();
      }
    }));
    System.out.println(add3(new NumberGenerator(){

      @Override
      public double generate() {
        return 0.3;
      }
    }));
    // Verkürzen: Redundanzen (Compiler)
    System.out.println(add3(/*new NumberGenerator(){

      @Override
      public double generate*/() -> {
        return Math.random();
      }
    /*}*/));
    NumberGenerator myGenerator = /*new NumberGenerator(){

      @Override
      public double generate*/() -> {
      return Math.random();
    };
    /*}*/
    myGenerator.generate();

    // Redundanzen weglassen
    System.out.println(add3(() -> {
      return Math.random();
    }));
    // Sonderfall: nur 1 Anweisung
    System.out.println(add3(() -> Math.random()));
    // Sonderfall: Parameter stimmen überein
    System.out.println(add3(Math::random)); // Method Reference Operator

  }

}
