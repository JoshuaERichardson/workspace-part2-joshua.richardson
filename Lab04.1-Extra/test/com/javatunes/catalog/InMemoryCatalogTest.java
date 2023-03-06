package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;
    @Before
    public void setUp(){
        catalog = new InMemoryCatalog();

    }

    /*
     *
     * FIND BY ID
     *
     */
    @Test
    public void findById_shouldReturnMusicItem_whenFound() {
        assertEquals(catalog.findById(12L).getId().longValue(), (12L));
    }

    @Test
    public void findById_shouldReturnNull_whenNotFound() {
        assertNull(catalog.findById(1000L));
    }


    /*
     *
     * FIND BY KEYWORD
     *
     */
    @Test
    public void findByKeyword() {
    }

    @Test
    public void findByCategory() {
    }

    @Test
    public void size() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void findSelfTitled() {
    }

    @Test
    public void findRockBottom() {
    }

    @Test
    public void countByGenre() {
    }

    @Test
    public void averageCost() {
    }

    @Test
    public void cheapestByGenre() {
    }

    @Test
    public void findGenreAverage() {
    }

    @Test
    public void isAtLeastCost() {
    }

    @Test
    public void sellGenre() {
    }

    @Test
    public void findTitleToGenre() {
    }

    @Test
    public void cheap80s() {
    }

    @Test
    public void testToString() {
    }
}