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
    Television tv1 = new Television("Sony", 50);  // channel defaults to 3
    System.out.println(tv1);
    
    Television tv2 = new Television("RCA", 10);
    tv2.changeChannel(9);
    System.out.println(tv2);
    
    // is tv1 affected by changes to the tv2 instance?
    System.out.println(tv1);
  }
}