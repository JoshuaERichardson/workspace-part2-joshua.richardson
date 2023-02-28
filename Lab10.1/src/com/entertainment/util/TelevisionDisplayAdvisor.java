/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.util;

import com.entertainment.Television;

public class TelevisionDisplayAdvisor {
  /**
   * TASK: if a Television's display is CRT, print a message indicating need for upgrade
   * 
   * Steps:
   *  loop over the vararg parameter 'tvs' - for each Television:
   *   - determine if its display property is DisplayType.CRT
   *   - if a CRT Television is found, print message to stdout (keep it simple)
   *  
   * OPTIONAL: print "no upgrades needed" (once) if no CRT Televisions are found at all
   */
  public static String check(Television... tvs) {
    // DONE
    String result = null;
    boolean foundCrt = false;
    
    for (Television tv : tvs) {
      if (tv.getDisplay() == Television.DisplayType.CRT) {  // OK to use == here (why?)
        result = "Television with display type " + tv.getDisplay() + " should be upgraded";
        System.out.println(result);
        foundCrt = true;
      }
    }
    if (!foundCrt) {
      result = "No televisions need to be upgraded";
      System.out.println(result);
    }
    return result;
  }
}