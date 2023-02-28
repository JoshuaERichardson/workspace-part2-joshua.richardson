/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.person;

import java.util.Objects;

public class Person {
  private String name;
  private int age;
  
  public Person(String name, int age) {
    setName(name);
    setAge(age);
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + " [name=" + getName() + ", age=" + getAge() + "]";
  }
  
  @Override
  public boolean equals(Object obj) {
    // System.out.println("Person.equals");
    boolean result = false;
    if (obj instanceof Person) {
      Person other = (Person) obj;
      result = this.getName().equals(other.getName()) && this.getAge() == other.getAge();
    }
    return result;
  }
  
  /*
  public int hashCode() {
    // System.out.println("Person.hashCode");
    // this implementation is prone to hash collisions
    // Rob-33 and Ron-21 are "different" Person objects, but have the same hashcode value (dumb luck)
    return getName().hashCode() + age;
    
    // this implementation is better at reducing hash collisions
    // return Objects.hash(getName(), getAge());
  }
  */
}