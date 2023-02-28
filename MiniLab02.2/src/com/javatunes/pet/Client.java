/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.pet;

public class Client {
  
  public static void main(String[] args) {
    Animal a1 = new Animal();
    
    // NOTE: you shouldn't call it this way, you should say Animal.makeSound()
    // and in fact, don't even need a "new Animal" at all.
    a1.makeSound();
    
    Animal a2 = new Cat();
    // which makeSound() method runs? (again, you shouldn't be calling it this way...)
    // IF makeSound() were a regular instance method, THEN which one would run?
    a2.makeSound();
    
    // NOW which method runs? (for the 3rd time, you should not call it this way...)
    Cat c2 = (Cat) a2;
    c2.makeSound();
    
    System.out.println();
    
    // don't get confused by the code above, it's all bogus (and the compiler warnings are spot on)
    // THIS is what you should do:
    Animal.makeSound();
    Cat.makeSound();
  }
}