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

public class TelevisionTest {

  @Test
  public void testSetVolume() {
    Television tv = new Television();
    
    tv.setVolume(0);  // valid volume, min value
    assertEquals(0, tv.getVolume());
    
    tv.setVolume(100);  // valid volume, max value
    assertEquals(100, tv.getVolume());
  }
  
  @Test
  public void testSetVolumeIllegalArgumentException() {
    Television tv = new Television();
    
    try {
      tv.setVolume(-1);
      fail("Should have thrown IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid volume: -1. Allowed range: [0,100].", e.getMessage());
    }
    
    try {
      tv.setVolume(101);
      fail("Should have thrown IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());
    }
  }
  
  @Test
  public void testChangeChannel()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv = new Television();
    
    tv.changeChannel(1);  // valid channel, min value
    assertEquals(1, tv.getCurrentChannel());
    
    tv.changeChannel(999);  // valid channel, max value
    assertEquals(999, tv.getCurrentChannel());
    
    tv.changeChannel(500);  // OK - parental controls disabled by default
    assertEquals(500, tv.getCurrentChannel());
  }
  
  @Test
  public void testChangeChannelInvalidChannelException()
  throws ChannelDisallowedException {
    Television tv = new Television();
    
    try {
      tv.changeChannel(0);
      fail("Should have thrown InvalidChannelException");
    }
    catch (InvalidChannelException e) {
      assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
    }
    
    try {
      tv.changeChannel(1000);
      fail("Should have thrown InvalidChannelException");
    }
    catch (InvalidChannelException e) {
      assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
    }
  }
  
  @Test(expected=ChannelDisallowedException.class)
  public void testChangeChannelChannelDisallowedExceptionLowerBound()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv = new Television();
    tv.enableParentalControl();
    tv.changeChannel(500);
  }
  
  @Test(expected=ChannelDisallowedException.class)
  public void testChangeChannelChannelDisallowedExceptionUpperBound()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv = new Television();
    tv.enableParentalControl();
    tv.changeChannel(599);
  }
  
  @Test
  public void testSetParentalControlEnabled()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv = new Television();
    tv.changeChannel(500);  // parental controls disabled by default
    tv.setParentalControlEnabled(true);  // channel should be reset to 1
    assertEquals(1, tv.getCurrentChannel());
  }
  
  @Test
  public void testEqualsAndHashCode() {  // brand, volume, display
    Television tv1 = new Television("RCA", 10, Television.DisplayType.LED);
    Television tv2 = new Television("RCA", 10, Television.DisplayType.LED);
    assertEquals(tv1, tv2);
    assertEquals(tv2, tv1);
    // equals objects must have equal hashcodes
    assertEquals(tv1.hashCode(), tv2.hashCode());
    tv2.setBrand("X");
    assertFalse(tv1.equals(tv2));
  }
  
  @Test
  public void testCompareTo() {
    Television tv1 = new Television("RCA");
    Television tv2 = new Television("Sony");
    Television tv3 = new Television("Zenith");
    assertTrue(tv1.compareTo(tv2) < 1);  // RCA < Sony
    assertTrue(tv3.compareTo(tv2) > 1);  // Zenith > Sony
    tv2.setBrand("RCA");
    assertTrue(tv1.compareTo(tv2) == 0); // RCA = RCA
  }
}