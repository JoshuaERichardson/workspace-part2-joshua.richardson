/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import java.util.Comparator;
import java.util.Objects;

public class Television
implements Comparable<Television> {
  public enum DisplayType { LCD, LED, OLED, PLASMA, CRT }
  
  public static final int MIN_VOLUME = 0;
  public static final int MAX_VOLUME = 100;
  public static final int MIN_CHANNEL = 1;
  public static final int MAX_CHANNEL = 999;
  private static final int MIN_DISALLOWED_CHANNEL = 500;  // for parental controls
  private static final int MAX_DISALLOWED_CHANNEL = 599;  // for parental controls
  
  private String brand;
  private int volume;
  private DisplayType display;
  private boolean parentalControlEnabled;
  private Tuner tuner = new Tuner();  // set up internally and used for channel management
  
  public Television() {
  }
  
  public Television(String brand) {
    setBrand(brand);
  }
  
  public Television(String brand, int volume)
  throws IllegalArgumentException {
    setBrand(brand);
    setVolume(volume);
  }
  
  public Television(String brand, DisplayType display) {
    setBrand(brand);
    setDisplay(display);
  }
  
  public Television(String brand, int volume, DisplayType display)
  throws IllegalArgumentException {
    this(brand, volume);
    setDisplay(display);
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
  public void setVolume(int volume)
  throws IllegalArgumentException {
    if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
      this.volume = volume;
    }
    else {
      throw new IllegalArgumentException("Invalid volume: " + volume + ". " + 
        "Allowed range: [" + MIN_VOLUME + "," + MAX_VOLUME + "].");
    }
  }
  
  public int getCurrentChannel() {
    return tuner.getChannel();  // delegate to contained Tuner object
  }
  
  public void changeChannel(int channel)
  throws InvalidChannelException, ChannelDisallowedException {
    if (channel < MIN_CHANNEL || channel > MAX_CHANNEL) {
      throw new InvalidChannelException("Invalid channel: " + channel + ". " +
        "Allowed range: [" + MIN_CHANNEL + "," + MAX_CHANNEL + "].");
    }
    if (isParentalControlEnabled() && (channel >= MIN_DISALLOWED_CHANNEL && channel <= MAX_DISALLOWED_CHANNEL)) {
      throw new ChannelDisallowedException("Disallowed channel, parental controls enabled.");
    }
    tuner.setChannel(channel);
  }
  
  public DisplayType getDisplay() {
    return this.display;
  }
  public void setDisplay(DisplayType display) {
    this.display = display;
  }
  
  // parental control methods - JavaBeans-style accessor methods and "control" methods are both provided
  public boolean isParentalControlEnabled() {
    return this.parentalControlEnabled;
  }
  public void setParentalControlEnabled(boolean parentalControl) {
    this.parentalControlEnabled = parentalControl;
    
    if (isParentalControlEnabled()) {
      // reset channel if necessary (we might be on an "adult" channel prior to enabling parental control)
      int currentChannel = getCurrentChannel();
      if (currentChannel >= MIN_DISALLOWED_CHANNEL && currentChannel <= MAX_DISALLOWED_CHANNEL) {
        tuner.setChannel(1);
      }
    }
  }
  public void enableParentalControl() {
    setParentalControlEnabled(true);
  }
  public void disableParentalControl() {
    setParentalControlEnabled(false);
  }

  public String toString() { 
    return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() + 
      ", currentChannel=" + getCurrentChannel() + ", display=" + getDisplay() + "]";
  }
  
  public int compareTo(Television other) {
    // System.out.println("Television.compareTo");
    // return this.getBrand().compareTo(other.getBrand());
    
    int result = this.getBrand().compareTo(other.getBrand());  // brand first
    if (result == 0) {  // tied on brand, check volume next
      result = Integer.compare(this.getVolume(), other.getVolume());
    }
    return result;
  }

  public int hashCode() {
    // System.out.println("Television.hashCode");
    return Objects.hash(getBrand(), getVolume(), getDisplay());
    
//    final int prime = 31;
//    int result = 1;
//    result = prime * result + ((this.brand == null) ? 0 : this.brand.hashCode());
//    result = prime * result + this.volume;
//    return result;
  }

  public boolean equals(Object obj) {
    // System.out.println("Television.equals");
    boolean result = false;
    if (obj instanceof Television) {
      Television other = (Television) obj;
      result = Objects.equals(this.getBrand(),   other.getBrand()) &&
               Objects.equals(this.getVolume(),  other.getVolume()) &&
               Objects.equals(this.getDisplay(), other.getDisplay());
    }
    return result;
    
//    if (this == obj)
//      return true;
//    if (obj == null)
//      return false;
//    if (getClass() != obj.getClass())
//      return false;
//    Television other = (Television) obj;
//    if (this.brand == null) {
//      if (other.brand != null)
//        return false;
//    }
//    else if (!this.brand.equals(other.brand))
//      return false;
//    if (this.volume != other.volume)
//      return false;
//    return true;
  }
  
  private class Tuner {
    private int channel = 3;  // default channel for cable and satellite customers
    
    public int getChannel() {
      return this.channel;
    }
    public void setChannel(int channel) {
      this.channel = channel;
    } 
  }
  
  public static class ChannelComparator
  implements Comparator<Television> {

    public int compare(Television tv1, Television tv2) {
      return Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
    }
  }
  
  public static class BrandChannelComparator
  implements Comparator<Television> {

    public int compare(Television tv1, Television tv2) {
      int result = tv1.getBrand().compareTo(tv2.getBrand());
      
      if (result == 0) {
        result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
      }
      return result;
    }
  }
}