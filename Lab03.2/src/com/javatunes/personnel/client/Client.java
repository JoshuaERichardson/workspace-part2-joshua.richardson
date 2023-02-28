/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel.client;

import java.sql.Date;
import com.javatunes.personnel.Department;
import com.javatunes.personnel.Employee;
import com.javatunes.personnel.HourlyEmployee;
import com.javatunes.personnel.SalariedEmployee;

public class Client {

  public static void main(String[] args) {
    // create Department
    Department dept = new Department("Sales", "Seattle");
    System.out.println(dept);
    
    // Employee is abstract, can't be instantiated directly
    // dept.addEmployee(new Employee("Jacob", Date.valueOf("1988-06-01")));
    // dept.addEmployee(new Employee("Amy",   Date.valueOf("2002-02-20")));
    
    // add HourlyEmployees and SalariedEmployees to it
    dept.addEmployee(new HourlyEmployee("Lonnie",   Date.valueOf("2015-03-31"), 35.0, 40.0));
    dept.addEmployee(new HourlyEmployee("Martin",   Date.valueOf("2011-02-17"), 25.0, 20.0));
    dept.addEmployee(new SalariedEmployee("Lauren", Date.valueOf("1997-04-08"), 50000.0));
    dept.addEmployee(new SalariedEmployee("Jason",  Date.valueOf("1990-08-24"), 34000.0));
    
    // list its Employees
    System.out.println("\nList employees:");
    dept.listEmployees();
    
    // make its Employees work
    System.out.println("\nMake employees work:");
    dept.workEmployees();
    
    // DONE: uncomment this after you've implemented payEmployees() in Department
    System.out.println("\nPay employees:");
    dept.payEmployees();
  }
}