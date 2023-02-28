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
import java.util.Map;
import com.javatunes.accounting.HourlyCitizenPayCalculator;
import com.javatunes.accounting.HourlyVisaPayCalculator;
import com.javatunes.accounting.PayCalculator;
import com.javatunes.accounting.SalariedCitizenPayCalculator;
import com.javatunes.accounting.SalariedVisaPayCalculator;

public class EmployeeFactory {
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  public static Employee createEmployee(Map<String,String> inputMap) {
    // return value
    Employee emp = null;
    PayCalculator payCalc = null;  // Strategy delegate (to be injected)
    
    // read map and create correct Employee type accordingly (via "type" entry)
    String type = inputMap.get("type");
    
    if ("SE".equals(type)) {
      SalariedEmployee salariedEmp = new SalariedEmployee();
      salariedEmp.setName(inputMap.get("name"));
      salariedEmp.setHireDate(Date.valueOf(inputMap.get("hireDate")));
      salariedEmp.setCitizen(Boolean.parseBoolean(inputMap.get("citizen")));
      salariedEmp.setSalary(Double.parseDouble(inputMap.get("salary")));
      
      if (salariedEmp.isCitizen()) {
        payCalc = new SalariedCitizenPayCalculator(salariedEmp);
      }
      else {
        payCalc = new SalariedVisaPayCalculator(salariedEmp);
      }
      salariedEmp.setPayCalculator(payCalc);
      emp = salariedEmp;
    }
    if ("HE".equals(type)) {
      HourlyEmployee hourlyEmp = new HourlyEmployee();
      hourlyEmp.setName(inputMap.get("name"));
      hourlyEmp.setHireDate(Date.valueOf(inputMap.get("hireDate")));
      hourlyEmp.setCitizen(Boolean.parseBoolean(inputMap.get("citizen")));
      hourlyEmp.setRate(Double.parseDouble(inputMap.get("rate")));
      hourlyEmp.setHours(Double.parseDouble(inputMap.get("hours")));
      
      if (hourlyEmp.isCitizen()) {
        payCalc = new HourlyCitizenPayCalculator(hourlyEmp);
      }
      else {
        payCalc = new HourlyVisaPayCalculator(hourlyEmp);
      }
      hourlyEmp.setPayCalculator(payCalc);
      emp = hourlyEmp;
    }
    return emp;
  }
}