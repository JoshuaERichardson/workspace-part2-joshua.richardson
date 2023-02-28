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
import java.util.HashMap;
import java.util.Map;

public class HourlyEmployee
extends Employee {
  private Double rate;
  private Double hours;
  
  protected HourlyEmployee() {
  }
  
  protected HourlyEmployee(String name, Date hireDate) {
    super(name, hireDate);
  }
  
  protected HourlyEmployee(String name, Date hireDate, Double rate, Double hours) {
    this(name, hireDate);
    setRate(rate);
    setHours(hours);
  }
  
  public Double getRate() {
    return this.rate;
  }
  public void setRate(Double rate) {
    this.rate = rate;
  }
  
  public Double getHours() {
    return this.hours;
  }
  public void setHours(Double hours) {
    this.hours = hours;
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() + 
      ", rate=" + getRate() + ", hours=" + getHours();
  }
}