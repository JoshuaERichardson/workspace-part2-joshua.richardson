/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinter implements Runnable {
  private String message;
  private int interval = 500;  // default value
  
  public MessagePrinter(String message) {
    this.message = message;
  }
  
  public MessagePrinter(String message, int interval) {
    this(message);
    this.interval = interval;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println(Thread.currentThread().getName() + ": " + message);
      try {
        Thread.sleep(interval);
      }
      catch (InterruptedException ignored) {
      }
    }
  }
}