/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.fastjava.annotation;

/**
 * Declares a class or method to be "fast."
 * If declared at the type level, all methods will execute faster by the <b>"boost factor"</b> <code>value</code>.
 * If declared at the individual method level, that particular method will be faster.
 * If declared at both levels, any method-level declaration will override the type-level declaration.
 */
public @interface Fast {
  /**
   * Performance boost, expressed as a decimal, ranging from 0.0 (no boost) to 1.0 (100% faster).
   * Required attribute.
   */

  
  /**
   * Whether or not to log extra information about the performance boost (optional).
   * Includes real-time performance metrics data, in nanoseconds.
   */

  
  /**
   * Description (optional).
   */
  
}