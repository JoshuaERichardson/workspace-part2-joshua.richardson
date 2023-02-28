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

public class Employee
implements Comparable<Employee> {
  private Long id;
  private String name;
  private Date hireDate;
  private Double salary;
  private Department dept;
  
  public Employee(Long id) {
    this.id = id;
  }
  
  public Employee(Long id, String name, String hireDate, Double salary, Department dept) {
    this(id, name, Date.valueOf(hireDate), salary, dept);
  }
  
  public Employee(Long id, String name, Date hireDate, Double salary, Department dept) {
    this.id = id;
    this.name = name;
    this.hireDate = hireDate;
    this.salary = salary;
    this.dept = dept;
  }
  
  public void work() {
    System.out.println(getName() + " working since " + getHireDate());
  }
  
  public void pay() {
    System.out.println(getName() + " is paid " + getSalary());
  }
  
  public Long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public Date getHireDate() {
    return hireDate;
  }
  
  public Double getSalary() {
    return salary;
  }
  public void setSalary(Double salary) {
    this.salary = salary;
  }
  
  public Department getDepartment() {
    return dept;
  }
  
  @Override
  public boolean equals(Object compare) {
    boolean result = false;
    if (compare instanceof Employee) {
      Employee other = (Employee) compare;
      result = this.id.equals(other.id);
    }
    return result;
  }
  
  @Override
  public int hashCode() {
    return id.hashCode();
  }
  
  @Override
  public int compareTo(Employee other) {
    return this.getId().compareTo(other.getId());
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " (id=" + getId() + ", name=" + getName() + ", hireDate=" + getHireDate() + ", salary=" + getSalary() + ")";
  }
}