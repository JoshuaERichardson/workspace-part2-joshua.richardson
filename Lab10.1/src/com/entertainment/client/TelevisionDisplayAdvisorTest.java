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
import com.entertainment.util.TelevisionDisplayAdvisor;

public class TelevisionDisplayAdvisorTest {
  
  public static void main(String[] args) {
    // NOTE: TelevisionDisplayAdvisor.check() is a static method, so it's called via the classname
    
    // DONE: pass individual instances
    TelevisionDisplayAdvisor.check(
      new Television("RCA",   10, Television.DisplayType.OLED),
      new Television("RCA",   10, Television.DisplayType.CRT),     // should generate output message
      new Television("Sony",  50, Television.DisplayType.PLASMA),
      new Television("Zenith", 0, Television.DisplayType.CRT));    // should generate output message
    System.out.println("-----");
    
    // DONE: pass nothing
    TelevisionDisplayAdvisor.check();  // should generate "no CRTs found" message
    System.out.println("-----");
    
    // DONE: pass an array - would only do this if you already had one, otherwise just pass individual instances
    Television[] tvArray = { new Television("Sony", 50, Television.DisplayType.PLASMA), new Television("RCA", 10, Television.DisplayType.CRT) };
    TelevisionDisplayAdvisor.check(tvArray);
    System.out.println("-----");
  }
}