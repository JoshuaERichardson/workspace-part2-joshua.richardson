/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import java.util.Objects;

public class Television
        implements Comparable<Television> {
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 100;
    public static final int MIN_CHANNEL = 1;
    public static final int MAX_CHANNEL = 999;

    private String brand;
    private int volume;
    private DisplayType display;
    private Tuner tuner = new Tuner();  // set up internally and used for channel management

    public Television() {
    }

    public Television(String brand) {
        setBrand(brand);
    }

    public Television(String brand, int volume)
            throws IllegalArgumentException {
        this(brand);
        setVolume(volume);
    }

    public Television(String brand, DisplayType display) {
        this(brand);
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
        } else {
            throw new IllegalArgumentException("Invalid volume: " + volume + ". " +
                    "Allowed range: [" + MIN_VOLUME + "," + MAX_VOLUME + "].");
        }
    }

    public int getCurrentChannel() {
        return tuner.getChannel();  // delegate to contained Tuner object
    }

    public void changeChannel(int channel)
            throws InvalidChannelException {
        if (channel >= MIN_CHANNEL && channel <= MAX_CHANNEL) {
            tuner.setChannel(channel);  // delegate to contained Tuner object
        } else {
            throw new InvalidChannelException("Invalid channel: " + channel + ". " +
                    "Allowed range: [" + MIN_CHANNEL + "," + MAX_CHANNEL + "].");
        }
    }

    public DisplayType getDisplay() {
        return this.display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() +
                ", currentChannel=" + getCurrentChannel() + ", display=" + getDisplay() + "]";
    }

    @Override
    public int compareTo(Television other) {
        return this.getBrand().compareTo(other.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume(), getDisplay());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Television) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    Objects.equals(this.getVolume(), other.getVolume()) &&
                    Objects.equals(this.getDisplay(), other.getDisplay());
        }
        return result;
    }
}