/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs;

/**
 * An argument can be made that the tax rate constants are better defined
 * on the classes that use them, and not all lumped in here.
 * 
 * We've decided that, since these are federally mandated tax rates, they 
 * are better left here.  This bends cohesion a bit, but strengthens open-closed:
 *  If the IRS were to change tax rates, we would only need to change that here.
 */
public interface TaxPayer {
  public static final double HOURLY_TAX_RATE = 0.25;
  public static final double SALARIED_TAX_RATE = 0.30;
  
  public double payTaxes();
}