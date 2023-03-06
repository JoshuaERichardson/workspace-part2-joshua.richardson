package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Comparator<Television> tv;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 42);
        tv2 = new Television("Sony", 42);
    }

    @Test
    public void compare_shouldReturnNegative_whenTvBrandALess() {
        tv2.setBrand("ZZZZZDIFFERENT");
        System.out.println(tv);
//        assertTrue(tv.compare(tv1,tv2) > 0);
    }
}