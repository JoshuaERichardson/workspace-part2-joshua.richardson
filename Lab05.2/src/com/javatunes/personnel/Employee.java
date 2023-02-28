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

public abstract class Employee {
  private String name;
  private Date hireDate;
  
  public Employee() {
  }
  
  public Employee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  /**
   * All employees get paid, but they implement this differently.
   * Method in base class but NO implementation.
   */
  public abstract void pay();
  
  /**
   * All employees work, and they all implement this the same way.
   * Method in base class WITH implementation.
   */
  public void work() {
    System.out.println(getName() + " working hard since " + getHireDate());
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
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
  }
}