package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;
    private Television tv2;
    @Before
    public void setUp()  {
        tv = new Television("Sony", 42);
        tv2 = new Television("Sony", 42);

    }


    /*
     *
     * SET VOLUME TESTS
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void setVolume_throwIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }
    @Test(expected = IllegalArgumentException.class)
    public void setVolume_throwIllegalArgumentException_whenInvalid_upperBound() {
        tv.setVolume(101);
    }

    /*
     *
     * SET CHANNEL TESTS
     *
     */
    @Test
    public void changeChannel_throwIllegalArgumentException_whenInvalid_lowerBound() {
        try {
            tv.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }
    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1,tv.getCurrentChannel());
    }
    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999,tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_throwIllegalArgumentException_whenInvalid_upperBound() throws InvalidChannelException {
        tv.changeChannel(1000);
        fail("Should fail");
    }

    /*
     *
     * COMPARE TO TESTS  ----- SHOULD COMPARE ONLY THE BRAND
     *
     */
    @Test
    public void compareTo_shouldBe0_sameArguments() {
        assertEquals(0,tv.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldBeNot0_differentBrand_sameVolume() {
        tv2.setBrand("DIFFERENT");
        assertNotEquals(0,tv.compareTo(tv2));
    }
    @Test
    public void compareTo_shouldBe0_sameBrand_differentVolume() {
        tv2.setVolume(50);
        assertEquals(0,tv.compareTo(tv2));
    }

    /*
     *
     * HASHCODE TESTS ----- SHOULD TAKE  BRAND, VOLUME AND DISPLAY
     *
     */
    @Test
    public void hashCode_shouldEqual_allSame() {
        assertEquals(tv.hashCode(),tv2.hashCode());
    }
    @Test
    public void hashCode_shouldNotEqual_diffBrand_sameVolume_sameDisplay() {
        tv2.setBrand("DIFFERENT");
        assertNotEquals(tv.hashCode(),tv2.hashCode());
    }
    @Test
    public void hashCode_shouldNotEqual_sameBrand_diffVolume_sameDisplay() {
        tv2.setVolume(50);
        assertNotEquals(tv.hashCode(),tv2.hashCode());
    }
    @Test
    public void hashCode_shouldNotEqual_sameBrand_sameVolume_diffDisplay() {
        tv2.setDisplay(DisplayType.OLED);
        assertNotEquals(tv.hashCode(),tv2.hashCode());
    }

    /*
     *
     * EQUALS TESTS
     *
     */
    @Test
    public void equals_shouldEqual_allSame() {
        assertEquals(tv, tv2);
    }
    @Test
    public void equals_shouldNotEqual_diffBrand_sameVol() {
        tv2.setBrand("DIFFERENT");
        assertNotEquals(tv,tv2);
    }
    @Test
    public void equals_shouldNotEqual_sameBrand_diffVol() {
        tv2.setVolume(50);
        assertNotEquals(tv,tv2);
    }

}