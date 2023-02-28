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

public class TelevisionBrandChannelComparatorTest {

  @Test
  public void testCompare()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv1 = new Television("RCA");
    Television tv2 = new Television("Sony");
    
    Television.BrandChannelComparator comparator = new Television.BrandChannelComparator();
    assertTrue(comparator.compare(tv1, tv2) < 0);  // RCA < Sony
    
    // if same brand, then compare channel
    tv2.setBrand("RCA");
    tv1.changeChannel(50);
    tv2.changeChannel(60);
    assertTrue(comparator.compare(tv1, tv2) < 0);  // RCA = RCA, 50 < 60
    tv2.changeChannel(50);
    assertTrue(comparator.compare(tv1, tv2) == 0); // RCA = RCA, 50 = 50
  }
}