/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
  private String name;
  private String location;
  private Collection<Employee> employees = new ArrayList<Employee>();
  
  public Department() {
  }
  
  public Department(String name, String location) {
    setName(name);
    setLocation(location);
  }
  
  public void listEmployees() {
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }
  
  public void workEmployees() {
    for (Employee emp : employees) {
      emp.work();
    }
  }
  
  /**
   * DONE: implement payEmployees() method by calling pay() on each Employee
   * it will look similar to the workEmployees() method above
   */
  public void payEmployees() {
    // DONE
    for (Employee emp : employees) {
      emp.pay();
    }
  }
  
  // helper method to add an Employee to the collection
  public void addEmployee(Employee emp) {
    employees.add(emp);
  }
  
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getLocation() {
    return this.location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", location=" + getLocation();
  }
}