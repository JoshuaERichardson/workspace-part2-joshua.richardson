/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

// TODO: you can uncomment these static imports if you want them
// import static java.util.Comparator.*;
// import static java.util.stream.Collectors.*;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.OptionalDouble;
import org.junit.Before;
import org.junit.Test;

public class AdvancedCatalogStreamTest {
  
  private Collection<MusicItem> allMusicItems;

  @Before
  public void setUp() {
    Catalog catalog = new InMemoryCatalog();
    allMusicItems = catalog.getAll();
  }
  
  /**
   * TASK: determine average price of our low-cost, extensive catalog of music.
   * 
   * RESULT: 15.309 (via calculator)
   */
  @Test
  public void testAveragePrice() {
    OptionalDouble avgPriceOptional = allMusicItems.stream()
      .mapToDouble(MusicItem::getPrice)  // item -> item.getPrice()
      .average();
    double avgPrice = avgPriceOptional.getAsDouble();
    
    assertEquals(15.309, avgPrice, .001);
  }
  
  /**
   * TASK: determine the titles of all "pop" items, sorted by natural order.
   * 
   * RESULT: 
   */
  @Test
  public void testTitlesPopSortNaturalOrder() {
    // TODO
  }
  
  /**
   * TASK: are all items priced at least $10?
   * 
   * RESULT: 
   */
  @Test
  public void testAllPriceGreaterThanEqual() {
    // TODO
  }
  
  /**
   * TASK: do we sell any "jazz" items?
   * 
   * RESULT: 
   */
  @Test
  public void testAnyMusicCategory() {
    // TODO
  }
  
  /**
   * TASK: how many "blues" items do we sell?
   * 
   * RESULT: 
   */
  @Test
  public void testCountMusicCategory() {
    // TODO
  }
  
  /**
   * TASK: print to stdout any 3 "rock" items.
   * 
   * RESULT: 
   */
  @Test
  public void testPrintAny3MusicCategory() {
    // TODO
  }
  
  /**
   * TASK: determine the average price of the 3 most recent items we sell.
   * Hint: If you sort by release date, you'll get oldest items first.
   * 
   * RESULT: 
   */
  @Test
  public void testAvgPrice3Newest() {
    // TODO
  }
  
  /**
   * TASK: determine the 2 highest-priced MusicItems, sorted by title.
   * HINT: you will need to sort twice in the pipeline.
   * 
   * RESULT: 
   */
  @Test
  public void testPrice2HighestSortTitle() {
    // TODO
  }
  
  /**
   * TASK: what is the price of our cheapest "pop" item?
   * 
   * RESULT: 
   */
  @Test
  public void testMinPriceMusicCategory() {
    // TODO
  }
}