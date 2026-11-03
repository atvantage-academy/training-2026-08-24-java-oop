package de.schulung.samples;

import de.schulung.banking.daten.Bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionsSample {

  public static void main(String[] args) {

    Collection<String> myCol = new TreeSet<>();

    myCol.add("Hello");
    myCol.add("test");
    myCol.add("helloworld");
    myCol.add("Hello");
    //myCol.add(new Bank());

    System.out.println(myCol);

    for(String o : myCol) {
      System.out.println(o.toUpperCase());
    }


  }

}
