/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.compare;

import java.util.Comparator;

public class StringLengthComparator
implements Comparator<String> {

  /*
   * The contract for Comparator is as follows:
   * Return a negative value if 1st arg is "less than" 2nd arg.
   * Return a positive value if 1st arg is "greater than" 2nd arg.
   * Return 0 if args are "equal."
   * 
   * YOU decide what it means for one String to be "less than" another String.
   * Here, we've decided that str1 is "less than" str2 if its length is less than str2's.
   * 
   * For example, "hello".length() - "goodbye".length() = 5 - 8 = -3.
   * Therefore, "hello" is 'less than' "goodbye".
   */
  @Override
  public int compare(String str1, String str2) {
    return str1.length() - str2.length();
  }
}