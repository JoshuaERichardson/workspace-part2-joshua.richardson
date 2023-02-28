/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

class Rand {
  
  static int getRandHundred(int min, int range) {
    int i = getRand(100, range + 100);
    int ret = ((int) (i / 100)) * 100;
    return (ret == (min + range + 100)) ? ret - 100 : ret;
  }
  
  static void sleepRand(int min, int range) {
    int r = getRand(min, range);
    try {
      Thread.sleep(r);
    }
    catch (InterruptedException ignored) {
    }
  }

  private static int getRand(int min, int range) {
    double r = Math.random();
    int inc = (int) (range * (1 - r));
    return min + inc;
  }

  // test code for Rand
  public static void main(String[] args) {
    System.out.println("Randoms");
    for (int i = 0; i < 10; i++) {
      System.out.println(getRand(100, 200));
    }
    System.out.println("Hundreds");
    for (int i = 0; i < 10; i++) {
      System.out.println(getRandHundred(100, 200));
    }
  }
}