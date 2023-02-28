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

public class HourlyEmployee
extends Employee {
  private Double rate;
  private Double hours;
  
  public HourlyEmployee() {
  }
  
  public HourlyEmployee(String name, Date hireDate) {
    super(name, hireDate);
  }
  
  public HourlyEmployee(String name, Date hireDate, Double rate, Double hours) {
    this(name, hireDate);
    setRate(rate);
    setHours(hours);
  }
  
  @Override
  public void pay() {
    System.out.println(getName() + " is paid hourly " + (getRate() * getHours()));
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