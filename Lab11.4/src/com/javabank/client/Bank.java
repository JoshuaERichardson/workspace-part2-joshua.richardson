/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank.client;

import com.javabank.Account;
import com.javabank.Auditor;
import com.javabank.Teller;

public class Bank {

  public static void main(String[] args) {
    Account a1 = new Account("Account-1", 1000);
    Account a2 = new Account("Account-2", 1000);
    
    // create two Teller threads
    Teller t1 = new Teller(a1, a2);
    t1.setName("Teller-1");
    
    Teller t2 = new Teller(a2, a1);
    t2.setName("Teller-2");
    
    // create the Auditor thread
    Auditor auditor = new Auditor(a1, a2);
    auditor.setName("Auditor");
    
    // start everybody up
    auditor.start();
    t1.start();
    t2.start();
  }
}