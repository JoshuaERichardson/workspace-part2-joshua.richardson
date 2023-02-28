/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

public class Auditor
extends Thread {
  private Account acct1;
  private Account acct2;

  public Auditor(Account acct1, Account acct2) {
    this.acct1 = acct1;
    this.acct2 = acct2;
  }
  
  @Override
  public void run() {
    while (true) {
      displayBalances();
      try {
        Thread.sleep(2000);
      }
      catch (InterruptedException ignored) {
      }
    }
  }
  
  /*
   * Calculate and display the total of the two accounts.
   * Since we're always transferring between the same two accounts, 
   * the total balance in the two should be constant.
   * If it's not, there's something wrong, so we show "****" to indicate that.
   */
  private void displayBalances() {
    int balance1;
    int balance2;
    
    // acquires each account's Lock object via tryLock(), to prevent deadlock
    LockManager.getLocks(acct1.getLock(), acct2.getLock());
    
    try {
      balance1 = acct1.getBalance();
      balance2 = acct2.getBalance();
    }
    finally {
      acct1.getLock().unlock();
      acct2.getLock().unlock();
    }
    
    StringBuffer msg = new StringBuffer("\n");
    if ((balance1 + balance2) != 2000) {  // balance total incorrect?
      msg.append("**** Total = ");
    }
    else {
      msg.append("     Total = ");
    }
    msg.append(balance1 + balance2);
    msg.append(" = (" + acct1.getName() + ") " + balance1);
    msg.append(" + (" + acct2.getName() + ") " + balance2);
    msg.append("\n");
    System.out.println(msg);
  }
}