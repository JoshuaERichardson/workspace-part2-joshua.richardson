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
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import com.entertainment.Television;

public class DuplicatesTest {

  @Test
  public void testRemoveDuplicates() {
    Collection<Television> inventory = Catalog.getInventory();
    assertEquals(30, inventory.size());
    
    Set<Television> inventorySet = new TreeSet<>(inventory);
    assertEquals(23, inventorySet.size());
  }
}