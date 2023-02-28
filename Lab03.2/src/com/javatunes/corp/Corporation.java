/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.corp;

import gov.irs.NamedEntity;
import gov.irs.TaxPayer;

public class Corporation
implements TaxPayer, NamedEntity {
  private String name;
  
  public Corporation() {
  }
  
  public Corporation(String name) {
    setName(name);
  }
  
  @Override  // interface TaxPayer
  public double payTaxes() {
    double taxes = 0;
    System.out.println(getName() + " paid no taxes - we lobbied hard and it worked");
    return taxes;
  }
  
  @Override  // interface NamedEntity
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
}