/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
  private String name;
  private int balance;
  private Lock lock = new ReentrantLock();
  
  public Account(String name, int balance) {
    this.name = name;
    setBalance(balance);
  }
  
  /*
   * deposit() and withdraw() are purposely implemented to show us 
   * some of the problems that can arise in multithreading.
   */
  public synchronized void deposit(int amount) {
    int balance = getBalance();   // get balance and save it locally
    Rand.sleepRand(100, 200);
    setBalance(balance + amount); // make the deposit
  }

  public synchronized void withdraw(int amount) {
    int balance = getBalance();   // get balance and save it locally
    Rand.sleepRand(100, 200);
    setBalance(balance - amount); // make the withdrawal
  }

  /*
   * transfer amount from "this" account to "dest" account.
   * acquires each account's Lock object via tryLock(), to prevent deadlock.
   */
  public void transferTo(Account dest, int amount) {
    LockManager.getLocks(this.getLock(), dest.getLock());

    try {
      // withdraw from "this", transfer to "dest"
      this.withdraw(amount);  // "this." is implicit, but added for clarity
      dest.deposit(amount);
    }
    finally {
      this.getLock().unlock();
      dest.getLock().unlock();
    }
  }

  public String getName() {
    return name;
  }
  
  public synchronized int getBalance() {
    return balance;
  }
  public synchronized void setBalance(int balance) {
    this.balance = balance;
  }
  
  Lock getLock() {
    return lock;
  }
}