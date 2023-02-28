/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.time.LocalDate;

public class SalariedEmployee
extends Employee
implements Runnable {
  private Double salary;
  
  public SalariedEmployee(String name, LocalDate hireDate) {
    super(name, hireDate);
  }
  
  public SalariedEmployee(String name, LocalDate hireDate, Double salary) {
    this(name, hireDate);
    setSalary(salary);
  }
  
  public void takeVacation() {
    takeVacation(false);
  }
  
  public void takeVacation(boolean fork) {
    System.out.println(getName() + " taking vacation...");
    
    if (fork) {
      Thread vacationThread = new Thread(this);  // this object is Runnable
      vacationThread.setName("vacation-thread");
      vacationThread.start();  // starts new thread, run() executes on this new thread
    }
    else {
      run();  // normally don't call run() directly, just here for the demo
    }
  }
  
  /*
   * Actual "take vacation" behavior here.
   * Vacation (in seconds) is defined as the length of their name(!)
   */
  @Override
  public void run() {
    try {
      Thread.sleep(getName().length() * 1000);
    }
    catch (InterruptedException ignored) {
    }
    System.out.println(getName() + " has returned");
  }
  
  public Double getSalary() {
    return this.salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }
  
  @Override
  public String toString() {
    return super.toString() + ", salary=" + getSalary();
  }
}