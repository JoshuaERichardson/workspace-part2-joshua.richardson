package com.javatunes.accounting;

import com.javatunes.personnel.Employee;
import com.javatunes.personnel.SalariedEmployee;

public class SalariedVisaPayCalculator
implements PayCalculator {
  private static final double visaFee = 0.05;
  private SalariedEmployee emp;  // back-reference to Employee
  
  public SalariedVisaPayCalculator(SalariedEmployee emp) {
    this.emp = emp;
  }

  @Override
  public double amount() {
    double salary = emp.getSalary();
    return (1.0 - visaFee) * salary;
  }
}