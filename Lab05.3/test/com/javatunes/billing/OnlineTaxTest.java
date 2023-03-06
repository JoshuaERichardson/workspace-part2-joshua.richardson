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

public class OnlineTaxTest {

    @Test
    public void testTaxAmount() {
        TaxCalculator taxCalc = new OnlineTax();
        double taxable = 100 * Math.random();
        // System.out.println(taxable);
        assertEquals(0.0, taxCalc.taxAmount(taxable), .001);
    }
}