/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import static org.junit.Assert.*;
import org.junit.Test;

public class ShoppingCartTest {
  
  /**
   * Product-based shopping cart, allows all types of Products.
   */
  @Test
  public void testProductCart() {
    ShoppingCart<Product> cart = new ShoppingCart<>();
    cart.addItem(new MusicItem("CD-501"));
    cart.addItem(new MediaPlayer("MP3-LP150"));
    // sanity check, this qualifies as "too simple to fail"
    // assertEquals(2, cart.size());
  }
  
  /**
   * MusicItem-only shopping cart.
   * May be needed if we need to invoke MusicItem-specific functionality.
   * NOTE: we would of course do some OO analysis and try to avoid working
   * with MusicItem directly (see testProductCart above).
   * However, our ShoppingCart should be able to handle such a case. 
   */
  @Test
  public void testMusicItemCart() {
    ShoppingCart<MusicItem> cart = new ShoppingCart<>();
    cart.addItem(new MusicItem("CD-521"));
    cart.addItem(new MusicItem("CD-514"));
    // sanity check, this qualifies as "too simple to fail"
    // assertEquals(2, cart.size());
  }
  
  /**
   * MediaPlayer-only shopping cart.
   * See comments above for MusicItem cart.
   */
  @Test
  public void testMediaPlayerCart() {
    ShoppingCart<MediaPlayer> cart = new ShoppingCart<>();
    cart.addItem(new MediaPlayer("AAC-PL233"));
    // sanity check, this qualifies as "too simple to fail"
    // assertEquals(1, cart.size());
  }
}