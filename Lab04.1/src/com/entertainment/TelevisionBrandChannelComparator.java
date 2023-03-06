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

public class TelevisionBrandChannelComparator
        implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        int result = tv1.getBrand().compareTo(tv2.getBrand());

        if (result == 0) {
            result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return result;
    }
}