/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import static org.junit.Assert.*;
import org.junit.Test;

public class TelevisionChannelComparatorTest {

  @Test
  public void testCompare()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv1 = new Television();
    tv1.changeChannel(5);
    Television tv2 = new Television();
    tv2.changeChannel(6);
    
    Television.ChannelComparator comparator = new Television.ChannelComparator();
    assertTrue(comparator.compare(tv1, tv2) < 0);  // 5 < 6
    
    tv2.changeChannel(5);
    assertTrue(comparator.compare(tv1, tv2) == 0); // 5 = 5
  }
}