/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

public class Calculator {
  
  public int add(int a, int b) {
    return a + b;
  }
  
  public double divide(int a, int b) {
    return 1.0 * a / b;  // convert to double, otherwise int / int -> int, e.g., 7/3 = 2
  }
  
  public boolean isEven(int x) {
    return x % 2 == 0;
  }
}