/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.util;

import static org.junit.Assert.*;
import org.junit.Test;
import com.entertainment.Television;

public class TelevisionDisplayAdvisorTest {

  @Test
  public void testCheck() {
    String result = TelevisionDisplayAdvisor.check(new Television("RCA", Television.DisplayType.CRT));
    assertEquals("Television with display type CRT should be upgraded", result);
    
    result = TelevisionDisplayAdvisor.check(
      new Television("RCA", Television.DisplayType.LCD),
      new Television("RCA", Television.DisplayType.PLASMA));
    assertEquals("No televisions need to be upgraded", result);
  }
}