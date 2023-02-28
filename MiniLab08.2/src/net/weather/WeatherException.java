/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package net.weather;

public class WeatherException
extends Exception {

  public WeatherException() {
  }

  public WeatherException(String message) {
    super(message);
  }

  public WeatherException(Throwable cause) {
    super(cause);
  }

  public WeatherException(String message, Throwable cause) {
    super(message, cause);
  }

  public WeatherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}