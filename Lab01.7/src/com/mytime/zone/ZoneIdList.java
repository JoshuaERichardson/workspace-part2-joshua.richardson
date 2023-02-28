/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime.zone;

import java.time.ZoneId;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ZoneIdList {
  
  public static void main(String[] args) {
    listAvailableZoneIds();
  }
  
  public static void listAvailableZoneIds() {
    Set<String> rawZoneIds = ZoneId.getAvailableZoneIds();  // unsorted, arbitrary order
    SortedSet<String> zoneIds = new TreeSet<>(rawZoneIds);  // sorted by String natural order
    
    for (String zoneId : zoneIds) {
      System.out.println(zoneId);
    }
  }
}