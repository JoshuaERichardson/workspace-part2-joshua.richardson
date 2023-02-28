/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.person.client;

import java.util.LinkedHashSet;
import java.util.Set;
import com.person.Person;

public class PersonTestSet {
  public static void main(String[] args) {
    Person p1 = new Person("Rob", 33);
    Person p2 = new Person("Rob", 33);
    Person p3 = new Person("Ron", 21);;    
    
    // contract: Sets reject "duplicates"
    // p1 and p2 should be treated as duplicates (they are equals())
    // p2 should be rejected by the Set
    Set<Person> set = new LinkedHashSet<Person>();
    set.add(p1);              // 1st element being added, goes in Set no questions asked
    set.add(p2);              // should be treated as a "duplicate" of p1, and thus rejected
    set.add(p3);              // should be added
    System.out.println("Set size: " + set.size());
    System.out.println("Set contents: " + set);
  }
}