/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.enumtype;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.javatunes.corp.Corporation;
import gov.irs.holder.IRS;

public class IRSEnumTest {
  
  @Test
  public void testNormalClientUsage() {
    IRSEnum irs = IRSEnum.getInstance();
    irs.register(new Corporation("JavaTunes"));
    irs.collectTaxes();
  }

  /**
   * TODO: verify that two calls to IRSEnum.getInstance() return the same instance.
   */
  @Test
  public void testSingleton() {
    
  }
  
  @Test
  public void testClassLoading() {
    // TODO: call IRSEnum.touch() and note the output - the call to IRSEnum.getInstance() should be commented out for this
    
    // TODO: call IRSEnum.getInstance() and note the output - the call to IRSEnum.touch() should be commented out for this
    
  }
}