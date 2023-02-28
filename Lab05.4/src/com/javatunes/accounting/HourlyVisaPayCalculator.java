package com.javatunes.accounting;

import java.util.Map;
import com.javatunes.personnel.Employee;
import com.javatunes.personnel.HourlyEmployee;

public class HourlyVisaPayCalculator
implements PayCalculator {
  private static final double visaFee = 0.1;
  private HourlyEmployee emp;  // back-reference to Employee
  
  public HourlyVisaPayCalculator(HourlyEmployee emp) {
    this.emp = emp;
  }
  
  @Override
  public double amount() {
    double hours = emp.getHours();
    double rate = emp.getRate();
    
    return (1.0 - visaFee) * (rate * hours);
  }
}