/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel.client;

import java.time.LocalDate;
import java.time.Month;
import com.javatunes.personnel.SalariedEmployee;

public class EmployeeClient {

  public static void main(String[] args) {
    SalariedEmployee emp = new SalariedEmployee("Leanne", LocalDate.of(1990, Month.AUGUST, 24), 34000.0);
    emp.work();
    emp.takeVacation(true);
    System.out.println("Client code continues working with other employees");
  }
}