/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * This class is really just a holder of Employee objects.
 * It has no public constructor and hardcodes its properties (name, location),
 * as well as its Employee collection.
 * It contains getter methods for name, location, employees.
 * It has a few "business" methods to list, work, and pay its employees.
 */
public class Department {
  private String name = "Sales";
  private String location = "Seattle";
  private Collection<Employee> employees = Arrays.asList(
              /* id    name         hireDate     salary   department */
    new Employee(1L,  "Jane",      "2005-07-01", 50000.0, this),
    new Employee(2L,  "Morgan",    "2009-12-05", 34000.0, this),
    new Employee(3L,  "Bob",       "2015-01-14", 95000.0, this),
    new Employee(4L,  "Raoul",     "2014-05-31", 75500.0, this),
    new Employee(5L,  "Jacob",     "2010-10-30", 52450.0, this),
    new Employee(6L,  "Edwin",     "2014-11-19", 44950.0, this),
    new Employee(7L,  "Zachary",   "2012-05-15", 66250.0, this),
    new Employee(8L,  "Annette",   "2000-09-12", 87500.0, this),
    new Employee(9L,  "Polly",     "1995-03-04", 64500.0, this),
    new Employee(10L, "Frank",     "2002-06-29", 78000.0, this),
    new Employee(11L, "John",      "2007-11-28", 58950.0, this),
    new Employee(12L, "Richard",   "2011-12-09", 77000.0, this),
    new Employee(13L, "Amy",       "1999-11-12", 99000.0, this),
    new Employee(14L, "Gerard",    "1998-08-17", 65375.0, this),
    new Employee(15L, "Hal",       "2010-08-21", 34000.0, this),
    new Employee(16L, "Christina", "2009-02-25", 55000.0, this)
  );
  
  public static Department getDepartment() {
    return new Department();
  }
  
  private Department() {
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
  
  public void payEmployees() {
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
  
  public String getLocation() {
    return this.location;
  }
  
  public Collection<Employee> getEmployees() {
    return Collections.unmodifiableCollection(employees);
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + " (name=" + getName() + ", location=" + getLocation() + ")";
  }
}