package com.javatunes.personnel;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class EmployeePayCalculatorTest {
  private Map<String,String> seMap;
  private Map<String,String> heMap;
  
  /**
   * client input request is a Map<String,String>, here's a sample
   * key        value
   * ---        -----
   * type       HE or SE
   * name       Jackie
   * hireDate   1990-08-24
   * citizen    true
   * 
   * salary     50000.00
   *        OR
   * rate       50.0
   * hours      50.0
   * 
   * NOTES:
   * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
   * 2. this is representative of how UIs send user input data to an application:
   *    - Java Swing UI components all return their input data as strings
   *    - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
   */
  @Before
  public void init() {
    seMap = new HashMap<>();
    seMap.put("type",     "SE");
    seMap.put("name",     "Jackie");
    seMap.put("hireDate", "1990-08-24");
    seMap.put("citizen",  "true");
    seMap.put("salary",   "50000.0");
    
    heMap = new HashMap<>();
    heMap.put("type",     "HE");
    heMap.put("name",     "Jackie");
    heMap.put("hireDate", "1990-08-24");
    heMap.put("citizen",  "true");
    heMap.put("rate",     "50.0");
    heMap.put("hours",    "50.0");
  }
 
  
  @Test
  public void testSalariedCitizenPay() {
    Employee emp = EmployeeFactory.createEmployee(seMap);
    assertEquals(55000.0, emp.pay(), .001);
    
    // change her salary and see if the calculation is re-done (should be)
    SalariedEmployee se = (SalariedEmployee) emp;
    se.setSalary(60000.0);
    assertEquals(66000.0, se.pay(), .001);
    
    // no bonus -> after 2010
    se.setHireDate(Date.valueOf("2015-12-12"));
    assertEquals(60000.0, se.pay(), .001);
  }
  
  @Test
  public void testSalariedVisaPay() {
    // make them not a citizen
    seMap.put("citizen", "false");
    Employee emp = EmployeeFactory.createEmployee(seMap);
    assertEquals(47500.0, emp.pay(), .001);
  }
  
  @Test
  public void testHourlyCitizenPay() {
    Employee emp = EmployeeFactory.createEmployee(heMap);
    assertEquals(2750.0, emp.pay(), .001);  // overtime
    
    // change salary to non-overtime
    HourlyEmployee he = (HourlyEmployee) emp;
    he.setHours(30.0);
    assertEquals(1500.0, he.pay(), .001);
  }
  
  @Test
  public void testHourlyVisaPay() {
    // make them not a citizen
    heMap.put("citizen", "false");
    Employee emp = EmployeeFactory.createEmployee(heMap);
    assertEquals(2250.0, emp.pay(), .001);
  }
}