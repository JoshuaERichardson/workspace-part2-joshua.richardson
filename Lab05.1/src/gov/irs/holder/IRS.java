/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.holder;

import java.util.ArrayList;
import java.util.Collection;
import gov.irs.TaxPayer;

public class IRS {
  // BUSINESS CODE
  private Collection<TaxPayer> payers = new ArrayList<>();
  
  public void collectTaxes() {
    for (TaxPayer payer : payers) {
      payer.payTaxes();
    }
  }
  
  public void register(TaxPayer payer) {
    payers.add(payer);
  }
  

  // SINGLETON CODE
  // so we can see when IRS class is loaded
  static {
    System.out.println("--IRS class loaded");
  }
  
  // so we can see when the instance is created
  private IRS() {
    System.out.println("--IRS ctor: the instance has been created");
  }
  
  // only access to the instance - truly lazy, and thread-safe
  public static IRS getInstance() {
    return IRSHolder.instance;
  }
  
  /*
   * superfluous static method that shouldn't be here
   * if you call it, class is loaded but nested class IRS.IRSHolder is NOT
   * even with superfluous static methods, this solution is lazy (still, best to not have them)
   */
  public static void touch() {
    // no-op
  }
  
  private static class IRSHolder {
    private static IRS instance = new IRS();
    
    // so we can see when IRS.IRSHolder class is loaded
    static {
      System.out.println("--IRS.IRSHolder class loaded");
    }
  }
}