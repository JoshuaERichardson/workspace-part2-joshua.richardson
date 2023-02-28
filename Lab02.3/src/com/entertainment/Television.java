/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class Television
implements Volume {
  // CLASS (static) VARIABLES
  public static final int MIN_VOLUME = 0;
  public static final int MAX_VOLUME = 100;

  // INSTANCE VARIABLES
  private String brand;
  private int volume;
  // for muting behavior
  private int oldVolume;
  private boolean isMuted;

  // CONSTRUCTORS
  public Television() {
  }

  public Television(String brand) {
    setBrand(brand);
  }

  public Television(int volume)
  throws IllegalArgumentException {
    setVolume(volume);
  }

  public Television(String brand, int volume)
  throws IllegalArgumentException {
    setBrand(brand);
    setVolume(volume);
  }

  // BEHAVIORAL METHODS
  @Override  // interface Volume
  public void mute() {
    if (!isMuted()) {           // not currently muted
      oldVolume = getVolume();  // store current volume in oldVolume
      setVolume(0);             // set volume to zero
    }
    else {                      // currently muted
      setVolume(oldVolume);     // restore volume from oldVolume value
    }
    isMuted = !isMuted;         // toggle muted flag
  }

  @Override  // interface Volume
  public void setVolume(int volume)
  throws IllegalArgumentException {
    if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
      this.volume = volume;
    }
    else {
      throw new IllegalArgumentException("Invalid volume " + volume);
    }
  }

  @Override  // interface Volume
  public int getVolume() {
    return volume;
  }
  
  @Override  // interface Volume
  public boolean isMuted() {
    return isMuted;
  }

  // ACCESSOR METHODS
  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getBrand() {
    return brand;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ": brand=" + getBrand() + 
      ", volume=" + (!isMuted() ? String.valueOf(getVolume()) : "<muted>");
  }
}