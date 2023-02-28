/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.time.LocalDate;

public class Employee {
  private String name;
  private LocalDate hireDate;
  
  public Employee(String name, LocalDate hireDate) {
    this.name = name;
    this.hireDate = hireDate;
  }
  
  public void work() {
    System.out.println(getName() + " working hard since " + getHireDate());
  }
  
  public String getName() {
    return this.name;
  }
  
  public LocalDate getHireDate() {
    return this.hireDate;
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
  }
}