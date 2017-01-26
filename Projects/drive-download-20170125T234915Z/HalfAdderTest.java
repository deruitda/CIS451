
import static edu.gvsu.dlunit.DLUnit.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for a basic half adder
 *
 * @author Zachary Kurmas
 */
// Created  4/17/14 at 1:50 PM
// (C) Zachary Kurmas 2014

public class HalfAdderTest {

  @Test
  public void zero_zero() {
    setPin("A", false);
    setPin("B", false);
    run();
    Assert.assertEquals("Checking Sum", false, readPin("Sum"));
    Assert.assertEquals("Checking Carry", false, readPin("Carry"));
  }

  @Test
  public void zero_one() {
    setPin("A", false);
    setPin("B", true);
    run();
    Assert.assertEquals("Checking Sum", true, readPin("Sum"));
    Assert.assertEquals("Checking Carry", false, readPin("Carry"));
  }

  @Test
  public void one_zero() {
    setPin("A", true);
    setPin("B", false);
    run();
    Assert.assertEquals("Checking Sum", true, readPin("Sum"));
    Assert.assertEquals("Checking Carry", false, readPin("Carry"));
  }


  @Test
  public void one_one() {
    setPin("A", true);
    setPin("B", true);
    run();
    Assert.assertEquals("Checking Sum", false, readPin("Sum"));
    Assert.assertEquals("Checking Carry", true, readPin("Carry"));
  }
}
