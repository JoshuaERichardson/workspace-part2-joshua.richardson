/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import com.entertainment.Television;

public class TelevisionClient {

  public static void main(String[] args) {
    // try to use a non-public class from outside its package
    // Tuner t = new Tuner();  // compiler error: "Tuner cannot be resolved to a type"
    
    // try out some Televisions, using the new display property
    Television tv1 = new Television();
    System.out.println(tv1);
    System.out.println();
    
    Television tv2 = new Television("RCA", 10);
    System.out.println(tv2);
    tv2.setDisplay(Television.DisplayType.CRT);
    System.out.println(tv2);
    System.out.println();
    
    Television tv3 = new Television("Sony", 50, Television.DisplayType.LED);  // LED: static import of DisplayType constants
    System.out.println(tv3);
    System.out.println();
    
    // try out "equal" Television instances - display now included in comparison
    Television tvA = new Television("Sony", 50, Television.DisplayType.PLASMA);
    Television tvB = new Television("Sony", 50, Television.DisplayType.PLASMA);
    Television tvC = new Television("Sony", 50, Television.DisplayType.LCD);
    System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));
    System.out.println("tvA.equals(tvC): " + tvA.equals(tvC));
  }
}