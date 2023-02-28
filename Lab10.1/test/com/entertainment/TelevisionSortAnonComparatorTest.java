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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Before;
import org.junit.Test;
import com.entertainment.catalog.Catalog;

public class TelevisionSortAnonComparatorTest {
  private List<Television> tvList;
  
  @Before
  public void init() {
    tvList = new ArrayList<>(Catalog.getInventory());
  }
  
  @Test
  public void testSortVolume() {
    tvList.sort(new Comparator<Television> () {
      public int compare(Television tv1, Television tv2) {
        return Integer.compare(tv1.getVolume(), tv2.getVolume());
      }
    });
    assertEquals(0, tvList.get(0).getVolume());
    assertEquals(4, tvList.get(1).getVolume());
    assertEquals(4, tvList.get(2).getVolume());
    assertEquals(87, tvList.get(tvList.size() - 2).getVolume());
    assertEquals(94, tvList.get(tvList.size() - 1).getVolume());
  }
}