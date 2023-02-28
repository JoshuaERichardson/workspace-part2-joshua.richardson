/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class ChannelDisallowedException
extends Exception {
  
  public ChannelDisallowedException() {
  }

  public ChannelDisallowedException(String message) {
    super(message);
  }

  public ChannelDisallowedException(Throwable cause) {
    super(cause);
  }

  public ChannelDisallowedException(String message, Throwable cause) {
    super(message, cause);
  }
}