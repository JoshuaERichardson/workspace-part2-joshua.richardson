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

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
    ShoppingCart<Product> cart;
    @Before
    public void setUp() throws Exception {
        cart = new ShoppingCart<>();
    }

    /**
     * Product-based shopping cart, allows all types of Products.
     */
    @Test
    public void testProductCart() {
        cart.addItem(new MusicItem("CD-501"));
        cart.addItem(new MediaPlayer("MP3-LP150"));
        // sanity check, this qualifies as "too simple to fail"
        assertEquals(2, cart.size());
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
        cart.addItem(new MusicItem("CD-521"));
        cart.addItem(new MusicItem("CD-514"));
        // sanity check, this qualifies as "too simple to fail"
        assertEquals(2, cart.size());
    }

    /**
     * MediaPlayer-only shopping cart.
     * See comments above for MusicItem cart.
     */
    @Test
    public void testMediaPlayerCart() {
        cart.addItem(new MediaPlayer("AAC-PL233"));
        // sanity check, this qualifies as "too simple to fail"
        assertEquals(1, cart.size());
    }

    /**
     *
     * Test total() with 0 and all
     *
     */
    @Test
    public void total_shouldBe0_whenCartEmpty() {
        assertEquals(0,cart.total(), .001);
    }

    @Test
    public void total_shouldBeTotal_whenAdd2() {
        cart.addItem(new MusicItem("CD-501"));
        cart.addItem(new MediaPlayer("MP3-LP150"));
        // Each one should be worth 50.0
        assertEquals(100.0,cart.total(),.001);
    }
}