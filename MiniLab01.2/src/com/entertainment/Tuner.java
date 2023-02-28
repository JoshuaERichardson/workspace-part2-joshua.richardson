/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class Tuner {
  private int channel = 3;  // default channel for cable and satellite customers
  
  public int getChannel() {
    return this.channel;
  }
  public void setChannel(int channel) {
    this.channel = channel;
  } 
}