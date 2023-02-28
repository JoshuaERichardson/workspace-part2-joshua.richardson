/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

  @Test
  public void testFindByBrand() {
    Collection<Television> tvs = Catalog.findByBrand("RCA");
    assertEquals(9, tvs.size());
    for (Television tv : tvs) {
      assertEquals("RCA", tv.getBrand());
    }
  }
  
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }
  
  @Test
  public void testFindByBrands() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("RCA", "Hitachi", "Sony", "Zenith", "NO-MATCHES");
    assertEquals(9, tvMap.get("RCA").size());
    assertEquals(5, tvMap.get("Hitachi").size());
    assertEquals(7, tvMap.get("Sony").size());
    assertEquals(9, tvMap.get("Zenith").size());
    assertEquals(0, tvMap.get("NO-MATCHES").size());
  }
  
  @Test
  public void testFindByBrandsNoneSpecified() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands();
    assertNotNull(tvMap);
    assertTrue(tvMap.isEmpty());
  }

  @Test(expected=UnsupportedOperationException.class)
  public void testGetInventory() {
    Collection<Television> inventory = Catalog.getInventory();
    inventory.clear();
  }
  
  /*
   * OPTIONAL PART: find loudest Television
   */
  @Test
  public void testLoudest() {
    Collection<Television> inventory = Catalog.getInventory();
    int maxVolume = 0;
    Television loudest = null;
    
    for (Television tv : inventory) {
      int tvVolume = tv.getVolume();
      if (tvVolume > maxVolume) {
        maxVolume = tvVolume;
        loudest = tv;
      }
    }
    assertEquals("Sony", loudest.getBrand());
    assertEquals(94, loudest.getVolume());
  }
  
  /*
   * OPTIONAL BONUS: find loudest Television via Collections.max() method
   */
  @Test
  public void testLoudestComparator() {
    Television loudest = Collections.max(Catalog.getInventory(), new Comparator<Television>() {
      public int compare(Television tv1, Television tv2) {
        return Integer.compare(tv1.getVolume(), tv2.getVolume());
      }
    });
    assertEquals("Sony", loudest.getBrand());
    assertEquals(94, loudest.getVolume());
  }
}