/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Objects;
import com.javatunes.accounting.PayCalculator;

public abstract class Employee {
  private String name;
  private Date hireDate;
  private boolean isCitizen;
  protected PayCalculator payCalculator;  // injected by factory
  
  protected Employee() {
  }
  
  protected Employee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  protected Employee(String name, Date hireDate, boolean citizen) {
    setName(name);
    setHireDate(hireDate);
    setCitizen(citizen);
  }  
  
  /**
   * All employees get paid, but the chosen implementation varies.
   * NOTE: implementation factored out into a PayCalculator Strategy.
   */
  public Double pay() {
    return payCalculator.amount();
  }
  
  /**
   * All employees work, and they all implement this the same way.
   * Method in base class WITH implementation.
   */
  public void work() {
    System.out.println(getName() + " working hard since " + getHireDate());
  }
  
  // for injection by EmployeeFactory
  public void setPayCalculator(PayCalculator payCalc) {
    this.payCalculator = payCalc;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Date getHireDate() {
    return this.hireDate;
  }
  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }
  
  public boolean isCitizen() {
    return this.isCitizen;
  }
  public void setCitizen(boolean isCitizen) {
    this.isCitizen = isCitizen;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
  }
}