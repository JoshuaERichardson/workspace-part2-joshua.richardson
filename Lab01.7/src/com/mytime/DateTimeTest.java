/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;

import java.time.LocalDate;

public class DateTimeTest {
  /**
   * main() calls each of the test methods in turn (currently commented out).
   * To run one test method at a time, uncomment the call to the one you want to execute.
   */
  public static void main(String[] args) {
    // testNow();
    // testCreate();
    // testParse();
    // testFormat();
  }

  /**
   * TASK: create current date, time, and date-time via now() and then print them.
   */
  public static void testNow() {
    // TODO
  }
  
  /**
   * TASK: implement the TODOs and print your results.
   */
  public void testCreate() {
    // TODO: create your birthday via of(). What day of the week were you born on?
        
    // TODO: use of() to create a value representing the 1st lunar landing - it happened on 7/20/69 at 3:18pm Eastern Time.
    // Note: ignore time-zone, just assume Eastern Time is the local time.
  }

  /**
   * TASK: implement the TODOs and print your results.
   */
  public static void testParse() {
    // TODO: create your birthday by parsing a text representation in standard format.
    
    // OPTIONAL: now create it by parsing text in the form "2/6/2014" (this is Feb 6, not Jun 2).
  }
  
  /**
   * TASK: create formatted display strings for the date below, in the specified formats.
   */
  public static void testFormat() {
    LocalDate hastings = LocalDate.of(1066, 10, 14);
    
    // TODO: 10/14/1066
    
    // TODO: 14-10-1066
    
    // OPTIONAL: October 14, 1066
  }
}