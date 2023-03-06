/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class InvalidChannelException
        extends Exception {

    public InvalidChannelException() {
    }

    public InvalidChannelException(String message) {
        super(message);
    }

    public InvalidChannelException(Throwable cause) {
        super(cause);
    }

    public InvalidChannelException(String message, Throwable cause) {
        super(message, cause);
    }
}