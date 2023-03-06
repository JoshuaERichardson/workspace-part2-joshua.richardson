/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

import static org.junit.Assert.*;

import org.junit.Test;

public class USATaxTest {

    @Test
    public void testTaxAmountUnder20() {
        TaxCalculator taxCalc = new USATax();
        assertEquals(0.0, taxCalc.taxAmount(20.0), .001);  //  0% of amount under 20
    }

    @Test
    public void testTaxAmountOver20() {
        TaxCalculator taxCalc = new USATax();
        assertEquals(1.0, taxCalc.taxAmount(30.0), .001);  // 10% of amount over 20
    }
}