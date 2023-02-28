/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class Radio
implements Volume {
  // INSTANCE VARIABLES
  private int volume;
  // for muting behavior
  private int oldVolume;
  private boolean isMuted;

  // CONSTRUCTORS
  public Radio() {
  }

  public Radio(int volume) {
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

  // ACCESSOR METHODS
  @Override  // interface Volume
  public void setVolume(int volume) {
    this.volume = volume;
  }

  @Override  // interface Volume
  public int getVolume() {
    return volume;
  }

  @Override  // interface Volume
  public boolean isMuted() {
    return isMuted;
  }
  
  @Override
  public String toString() {
    return "Radio: volume=" + (!isMuted() ? String.valueOf(volume) : "<muted>");
  }
}