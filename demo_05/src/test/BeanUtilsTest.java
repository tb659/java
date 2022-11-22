package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @Classname BeanUtilsTest
 * @Description TODO
 * @Date 2022-11-18 18:14
 * @Created by @tb659
 */
public class BeanUtilsTest {

  @Test
  public void test() {

    User user = new User();
    try {

      BeanUtils.setProperty(user, "hehe", "male");
      System.out.println(user);

      String gender = BeanUtils.getProperty(user, "hehe");
      System.out.println(gender);

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }



  }
}
