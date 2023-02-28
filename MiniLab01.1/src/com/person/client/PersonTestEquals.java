/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.person.client;

import java.util.HashSet;
import java.util.Set;
import com.person.Person;

public class PersonTestEquals {
  public static void main(String[] args) {
    Person p1 = new Person("Rob", 33);
    Person p2 = new Person("Rob", 33);
    Person p3 = new Person("Ron", 21);
    
    // contract: "equal" objects should return true for equals()
    System.out.println("p1.equals(p2): " + p1.equals(p2));  // should be true, and it is (good)
    System.out.println("p1.equals(p3): " + p1.equals(p3));  // should be false, and it is (good)
  }
}