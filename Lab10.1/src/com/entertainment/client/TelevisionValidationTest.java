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

public class TelevisionValidationTest {

  public static void main(String[] args) {
    try {
      // Television tv1 = new Television("RCA", -10);  // invalid volume, exception thrown
      Television tv1 = new Television("RCA", 10);
      System.out.println(tv1);
      
      // NOTE: to test exhaustively, check all "boundary values" (not doing that here):
      //  -1,   0 ,  1 on the lower bound
      //  99, 100, 101 on the upper bound
      // we should also use a testing tool like JUnit (coming soon!)
      tv1.setVolume(50);        // valid volume, should be accepted
      System.out.println(tv1);
      // tv1.setVolume(101);       // invalid volume, exception thrown
      
      // tv1.changeChannel(0);     // invalid channel, exception thrown
      tv1.changeChannel(9);     // valid channel, should be accepted
      System.out.println(tv1);
    }
    /* multicatch
    catch (IllegalArgumentException | InvalidChannelException e) {
      e.printStackTrace();
    }
    */
    catch (IllegalArgumentException e) {
      e.printStackTrace();
      // System.out.println(e);
      // System.out.println(e.getMessage());
    }
    catch (InvalidChannelException e) {
      e.printStackTrace();
      // System.out.println(e);
      // System.out.println(e.getMessage());
    }
    catch (ChannelDisallowedException e) {
      System.out.println(e);
    }
    /* catch-all handler
    catch (Exception e) {
      e.printStackTrace();
    }
    */
  }
}