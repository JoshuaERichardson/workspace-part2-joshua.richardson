/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.entertainment.ChannelDisallowedException;
import com.entertainment.InvalidChannelException;
import com.entertainment.Television;

public class TelevisionTestSort {
  
  public static void main(String[] args) {
    // dataset for testing
    List<Television> tvList = null;
    try {
      tvList = createTelevisionList();
    }
    catch (InvalidChannelException | ChannelDisallowedException e) {
      e.printStackTrace();
    }
    
    // sort by natural order and print
    tvList.sort(null);
    
    System.out.println("Sorted by brand (natural order)");
    for (Television tv : tvList) {
      System.out.println(tv);
    }
    System.out.println();
    
    // sort by supplied Comparator and print
    tvList.sort(new Television.ChannelComparator());
    
    System.out.println("Sorted by channel");
    for (Television tv : tvList) {
      System.out.println(tv);
    }
    System.out.println();
    
    // optional - sort by brand, then channel
    tvList.sort(new Television.BrandChannelComparator());
    
    System.out.println("Sorted by brand, then channel");
    for (Television tv : tvList) {
      System.out.println(tv);
    }
  }
  
  
  private static List<Television> createTelevisionList()
  throws InvalidChannelException, ChannelDisallowedException {
    Television tv1 = new Television("Zenith", 30);
    tv1.changeChannel(44);
    
    Television tv2 = new Television("Hitachi", 10);
    tv2.changeChannel(9);
    
    Television tv3 = new Television("Sony", 50);
    tv3.changeChannel(13);
    
    Television tv4 = new Television("RCA", 25);
    
    Television tv5 = new Television("Hitachi", 5);
    
    Television tv6 = new Television("Sony", 40);
    
    return Arrays.asList(tv1, tv2, tv3, tv4, tv5, tv6);
  }
}