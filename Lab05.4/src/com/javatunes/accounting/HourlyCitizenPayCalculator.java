package com.javatunes.accounting;

import java.util.Map;
import com.javatunes.personnel.Employee;
import com.javatunes.personnel.HourlyEmployee;

public class HourlyCitizenPayCalculator
implements PayCalculator {
  private static final double overtimeFactor = 1.5;
  private HourlyEmployee emp;  // back-reference to Employee
  
  public HourlyCitizenPayCalculator(HourlyEmployee emp) {
    this.emp = emp;
  }
  
  @Override
  public double amount() {
    double result = 0.0;
    
    double hours = emp.getHours();
    double rate = emp.getRate();
    
    double regularHours = hours;
    double overtimeHours = 0.0;
    
    if (regularHours >= 40.0) {
      regularHours = 40.0;
      overtimeHours = (hours - 40.0); 
    }
    result = rate * (regularHours + (1.5 * overtimeHours));
    return result;
  }
}