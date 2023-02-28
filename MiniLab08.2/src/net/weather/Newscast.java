/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package net.weather;

public class Newscast {
  
  public void playWeatherSegment(Meteorologist m, String city) {
    System.out.println("Hello, this is " + m.getName() + ", and here's your weather forecast:");
    
    try {
      String weather = m.forecast(city);
      System.out.println("The weather in " + city + " is going to be " + weather + ".");
    }
    catch (WeatherException e) {
      System.out.println("I'm sorry, we're having technical difficulties - I can't tell you the weather for " + city + ".");
    }
  }
}