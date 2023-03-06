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

public class EuropeTaxTest {

    @Test
    public void testTaxAmountUnder100() {
        TaxCalculator taxCalc = new EuropeTax();
        assertEquals(17.0, taxCalc.taxAmount(100.0), .001);  // 17% of 100
    }

    @Test
    public void testTaxAmountOver100() {
        TaxCalculator taxCalc = new EuropeTax();
        assertEquals(38.0, taxCalc.taxAmount(150.0), .001);  // 17% of 150 + 25% of amount over 100
    }
}