/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package demo.wildcards;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class WildcardTest {

  @Test
  public void testSumNumber() {
    Collection<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(7));    // not autoboxing here just for emphasis
    numbers.add(Double.valueOf(3.14));  // numbers has subtypes in it
    numbers.add(Long.valueOf(12));      // inheritance 101 (IS-A)
    
    // sum() expects a Collection<Number> and that's what I'm passing
    // my Collection<Number> can *of course* contain Integers, Doubles, Longs (IS-A)
    double result = sum(numbers);
    assertEquals(22.14, result, .001);
  }
  
  @Test
  public void testSumDouble() {
    Collection<Double> doubles = new ArrayList<>();
    doubles.add(3.14);
    doubles.add(2.78);
    
    // sum() expects a Collection<Number> but I'm passing a Collection<Double>
    // that should be okay, right?
    
    // double result = sum(doubles);
    // assertEquals(5.92, result, .001);
  }
  
  /*
   * Anywhere a Collection<Number> is expected, a Collection<Double> will do,
   * that's the Principle of Substitutability and IS-A.
   * BUT WAIT: is Collection<Double> a subclass of Collection<Number> ???
   */
  private double sum(Collection<Number> values) {
    double sum = 0.0;
    for (Number number : values) {
      sum = sum + number.doubleValue();
    }
    return sum;
  }
}