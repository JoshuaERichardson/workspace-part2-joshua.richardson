/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

public class Teller
extends Thread {
  private Account acct1;
  private Account acct2;

  public Teller(Account acct1, Account acct2) {
    this.acct1 = acct1;
    this.acct2 = acct2;
  }

  // loop forever, doing transfers from one account to another
  @Override
  public void run() {
    while (true) {
      doTransfer();
      Rand.sleepRand(100, 200);
    }
  }
  
  private void doTransfer() {
    int amount = Rand.getRandHundred(100, 200);
    
    System.out.println(getName() + ": Transfer " + amount + " from " + acct1.getName() + " to " + acct2.getName());
    acct1.withdraw(amount);
    acct2.deposit(amount);
  }
}