/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class Television {
  private String brand;
  private int volume;
  private Tuner tuner = new Tuner();  // set up internally and used for channel management
  
  public Television() {
  }
  
  public Television(String brand, int volume) {
    setBrand(brand);
    setVolume(volume);
  }
  
  public String getBrand() {
    return this.brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }
  
  public int getVolume() {
    return this.volume;
  }
  public void setVolume(int volume) {
    this.volume = volume;
  }
  
  public int getCurrentChannel() {
    return tuner.getChannel();  // delegate to contained Tuner object
  }
  
  public void changeChannel(int channel) {
    tuner.setChannel(channel);  // delegate to contained Tuner object
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() + ", currentChannel=" + getCurrentChannel() + "]";
  }
}