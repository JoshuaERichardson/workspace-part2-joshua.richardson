/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessagePrinterExecutor {
  private static Runnable printer1 = new MessagePrinter("Roses are red");
  private static Runnable printer2 = new MessagePrinter("Violets are blue");
  private static Runnable printer3 = new MessagePrinter("Sugar is sweet");
  private static Runnable printer4 = new MessagePrinter("And so are you");
  private static Runnable printer5 = new MessagePrinter("Actually, sugar is bad");

  
  public static void main(String[] args)
  throws Exception {
    /**
     * TASK: uncomment these one at a time to see their execution behavior.
     * 
     * Have questions about fixed-thread-pools or cached-thread-pools?
     * See the Javadoc!
     * 
     * What does shutdown() do?  Same answer: see the Javadoc!
     */
    // runWithFixedThreadPool();
    // runWithCachedThreadPool();
  }

  
  private static void runWithFixedThreadPool() {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    
    executor.execute(printer1);
    executor.execute(printer2);
    executor.execute(printer3);
    executor.execute(printer4);
    executor.execute(printer5);
    
    executor.shutdown();
  }

  private static void runWithCachedThreadPool()
  throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    
    executor.execute(printer1);
    executor.execute(printer2);
    executor.execute(printer3);
    executor.execute(printer4);
    executor.execute(printer5);
    
    Thread.sleep(2500);
    executor.execute(new MessagePrinter("this should reuse an existing pooled thread"));
    
    executor.shutdown();
  }
}