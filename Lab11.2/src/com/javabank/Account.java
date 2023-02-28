/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

public class Account {
  private String name;
  private int balance;
  
  public Account(String name, int balance) {
    this.name = name;
    setBalance(balance);
  }
  
  /*
   * deposit() and withdraw() are purposely implemented to show us 
   * some of the problems that can arise in multithreading.
   */
  public void deposit(int amount) {
    int balance = getBalance();   // get balance and save it locally
    Rand.sleepRand(100, 200);
    setBalance(balance + amount); // make the deposit
  }

  public void withdraw(int amount) {
    int balance = getBalance();   // get balance and save it locally
    Rand.sleepRand(100, 200);
    setBalance(balance - amount); // make the withdrawal
  }

  public String getName() {
    return name;
  }
  
  public int getBalance() {
    return balance;
  }
  public void setBalance(int balance) {
    this.balance = balance;
  }
}