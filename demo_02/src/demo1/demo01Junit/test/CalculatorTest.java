package demo1.demo01Junit.test;

import demo1.demo01Junit.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {

  @Before
  public void init() {
    System.out.println("init...");
  }

  @Test
  public void testAdd() {
    Calculator c = new Calculator();
    int result = c.add(1, 2);
    System.out.println(result);
  }

  @Test
  public void testMinus() {
    Calculator c = new Calculator();
    int result = c.minus(2, 1);
    Assert.assertEquals(1, result);
  }

  @After
  public void finished() {
    System.out.println("finished...");
  }
}
