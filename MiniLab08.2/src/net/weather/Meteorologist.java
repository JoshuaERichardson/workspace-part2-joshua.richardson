/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package net.weather;

@FunctionalInterface
public interface Meteorologist {
  
  public String forecast(String city) throws WeatherException;
  
  default public String getName() {
    return "Jane Doe";
  }
}