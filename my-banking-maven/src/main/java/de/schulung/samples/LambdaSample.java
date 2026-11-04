package de.schulung.samples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

  static double add4(Supplier<Double> numberGenerator) {
    double result = 0.0;
    while(result <= 10) {
      result = result + numberGenerator.get();
    }
    return result;
  }

  static double add5(DoubleSupplier numberGenerator) {
    double result = 0.0;
    while(result <= 10) {
      result = result + numberGenerator.getAsDouble();
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
    // Verzögerte Ausführung im Vergleich:
    System.out.println(add(Math.random(), Math.random())); // 2x random(), add, println
    System.out.println(add3(Math::random)); // add, ?-mal random(), println

    // WELCHE FUNKTIONALEN INTERFACES GIBT ES IN JAVA?
    Supplier<String> stringSupplier = new Supplier<String>() {
      @Override
      public String get() {
        return "Hallo Welt";
      }
    };
    stringSupplier = () -> "Hallo Welt";
    System.out.println(stringSupplier.get());
    System.out.println(add4(Math::random)); // Supplier<Double>
    System.out.println(add5(Math::random)); // DoubleSupplier
    Supplier<Date> dateSupplier = new Supplier<Date>() {
      @Override
      public Date get() {
        return new Date();
      }
    };
    dateSupplier = () -> new Date();
    dateSupplier = Date::new;

    Consumer<String> stringConsumer = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };
    stringConsumer = text -> System.out.println(text);
    stringConsumer = System.out::println;
    stringConsumer.accept("Hello World");

    Function<String, Integer> stringToIntegerFunction = new Function<String, Integer>() {
      @Override
      public Integer apply(String s) {
        return Integer.parseInt(s);
      }
    };
    stringToIntegerFunction = text -> Integer.parseInt(text);
    stringToIntegerFunction = Integer::parseInt;
    System.out.println(stringToIntegerFunction.apply("123"));

    Predicate<String> stringPredicate = new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return s.length() > 5;
      }
    };
    stringPredicate = text -> text.length() > 5;
    System.out.println(stringPredicate.test("Hallo Welt"));

    // UND WO BRAUCHE ICH DAS?
    // Antwort: Stream, Optional

    List<String> namen = List.of("Andreas", "Astrid", "Benjamin", "Catia", "Nico", "Katrin", "Martin", "Ralf");
    // Aufgabe: Liste aller kurzen Namen (<=5) in Großbuchstaben
    {
      List<String> kurznamen = new ArrayList<>();
      for(String name : namen) {
        if(name.length() <= 5) {
          kurznamen.add(name.toUpperCase());
        }
      }
      System.out.println(kurznamen);
    }
    {
      List<String> kurznamen = namen
        .stream()
        .filter(s -> s.length() <= 5)
        .map(String::toUpperCase)
        .toList();
      System.out.println(kurznamen);
    }
    Optional<String> ersterNameMitZ = namen
      .stream()
      .filter(name -> name.startsWith("Z"))
      .findFirst();
    String name = ersterNameMitZ
      .map(String::toUpperCase)
      .orElse(null);


  }

}
