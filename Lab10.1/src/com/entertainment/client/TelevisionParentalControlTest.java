/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import com.entertainment.ChannelDisallowedException;
import com.entertainment.InvalidChannelException;
import com.entertainment.Television;

public class TelevisionParentalControlTest {
  
  public static void main(String[] args) {
    try {
      Television tv1 = new Television("Sony", 50);  // parental control disabled by default
      // leave on default channel (3)
      System.out.println(tv1);  // channel 3 -> OK
      tv1.enableParentalControl();
      System.out.println(tv1);  // still on channel 3
      System.out.println();
      
      Television tv2 = new Television("RCA", 10);  // parental control disabled by default
      tv2.changeChannel(500);
      System.out.println(tv2);  // channel 500 -> OK
      tv2.enableParentalControl();
      System.out.println(tv2);  // reset to channel 1 (should NOT still be 500)
      System.out.println();
      
      tv2.changeChannel(500);   // ChannelDisallowedException
    }
    catch (IllegalArgumentException | InvalidChannelException e) {
      e.printStackTrace();
    }
    catch (ChannelDisallowedException e) {
      System.out.println("Sorry junior, parental controls are enabled.");
    }
  }
}