/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

public class MusicItem
        extends Product {

    public MusicItem(String code) {
        super(code);
    }

    @Override
    public Double getPrice() {
        return 10.0;
    }
}