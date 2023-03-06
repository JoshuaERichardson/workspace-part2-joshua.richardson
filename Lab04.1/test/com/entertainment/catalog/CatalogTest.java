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
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {



    /*
     *
     * FIND BY BRAND --- collection
     *
     */
    @Test
    public void findByBrand_shouldReturnCollectionWithThatBrand_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assert tvs != null;
        assertEquals(7,tvs.size());
        tvs.forEach(a -> assertEquals("Sony",a.getBrand()));
    }

    @Test
    public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }

    /*
     *
     * FIND BY BRAND -- MAP
     *
     */

    @Test
    public void findByBrands_shouldReturnEmptyMap_whenBrandNotFound() {
        var tvs = Catalog.findByBrands("WRONG");
        System.out.println(tvs);
        assertTrue(tvs.isEmpty());
    }

    @Test
    public void findByBrands_shouldReturnMap1_whenOneBrandFound() {
        Map<String, Collection<Television>> tvs = Catalog.findByBrands("Sony");
        assert tvs != null;
        assertEquals(7,tvs.get("Sony").size());

    }

    @Test
    public void findByBrands_shouldReturnMap2_whenBrandsFound() {
        Map<String, Collection<Television>> tvs = Catalog.findByBrands("Sony", "Zenith", "RCA");
        assert tvs != null;
        assertEquals(3, tvs.size());
//        Sony 7, Zenith 9, RCA 9
        assertEquals(7,tvs.get("Sony").size());
        assertEquals(9,tvs.get("Zenith").size());
        assertEquals(9,tvs.get("RCA").size());


    }

    @Test
    public void findByBrands_shouldReturnMap1_whenOnePassOneFail() {
        Map<String, Collection<Television>> tvs = Catalog.findByBrands("Sony", "WRONG");
        assert tvs != null;
        assertEquals(1,tvs.size());
    }

    /*
     *
     * GET INVENTORY --- READ ONLY
     *
     */

    @Test
    public void getInventory_checkSize() {
        var tvs = Catalog.getInventory();
        assertEquals(30, tvs.size());
    }
    @Test(expected=UnsupportedOperationException.class)
    public void getInventory_shouldFail_addTv() throws Exception{
        var tvs = Catalog.getInventory();
        tvs.add(new Television("WRONG",50));
    }

//    @Test
//    public void getInventory_shouldFail_whenChangeBrand() {
//        var tvs = Catalog.getInventory();
//        try{
//            tvs.get(0).setBrand("Wrong");
//        } catch (Exception e) {
//            assertEquals(0,0);
//        }
//    }

//    @Test
//    public void getInventory_shouldFail_whenChangeVol() {
//        Collection<Television> tvs = Catalog.getInventory();
//    }
//
//    @Test
//    public void getInventory_shouldFail_whenDeleteTv() {
//        Collection<Television> tvs = Catalog.getInventory();
//    }
//
//    @Test(expected = UnsupportedOperationException.class)
//    public void getInventory_shouldFail_whenClear() {
//        Collection<Television> tvs = Catalog.getInventory();
//        tvs.clear();

}