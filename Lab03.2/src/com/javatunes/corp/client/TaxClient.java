/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.corp.client;

import java.sql.Date;
import com.javatunes.corp.Corporation;
import com.javatunes.personnel.HourlyEmployee;
import com.javatunes.personnel.SalariedEmployee;
import gov.irs.IRS;

public class TaxClient {

  public static void main(String[] args) {
    // create the IRS
    IRS irs = new IRS();
        
    // create the Corporation and register it with the IRS
    Corporation corp = new Corporation("JavaTunes");
    irs.register(corp);
    
    // create employees and register them with the IRS
    irs.register(new HourlyEmployee("Lonnie",   Date.valueOf("2015-03-31"), 35.0, 40.0));
    irs.register(new HourlyEmployee("Martin",   Date.valueOf("2011-02-17"), 25.0, 20.0));
    irs.register(new SalariedEmployee("Lauren", Date.valueOf("1997-04-08"), 50000.0));
    irs.register(new SalariedEmployee("Jason",  Date.valueOf("1990-08-24"), 34000.0));
    
    // IRS collects taxes
    System.out.println("IRS collects taxes");
    irs.collectTaxes();
  }
}