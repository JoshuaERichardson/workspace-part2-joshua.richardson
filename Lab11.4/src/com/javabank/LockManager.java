/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

import java.util.concurrent.locks.Lock;

class LockManager {
  /**
   * Clarification of terms, and an analogy:
   * Think of the lock on your front door - here, that's like a Lock object.
   * 
   * The lock on your front door is an object that can be locked, or unlocked.
   * Here, the Lock object can be in one of two states: locked, or unlocked.
   * 
   * Calling tryLock() locks it   [if it can].
   * Calling unlock()  unlocks it [which should only be called if it's already locked,
   * otherwise an IllegalMonitorStateException is thrown].
   * 
   * NOTE: this method *does not return* until both Locks are locked.
   */
  static void getLocks(Lock lock1, Lock lock2) {
    // attempt to lock both Locks until successful
    while (true) {
      boolean lock1IsLocked = lock1.tryLock();
      boolean lock2IsLocked = lock2.tryLock();
      
      // if you locked both locks, break and return
      if (lock1IsLocked && lock2IsLocked) {
        break;
      }
      // you didn't lock both of them, so unlock those you did and try again
      else { 
        if (lock1IsLocked) lock1.unlock();
        if (lock2IsLocked) lock2.unlock();
        try { Thread.sleep(250); }
        catch (InterruptedException ignored) { }
      }
    }
  }
}