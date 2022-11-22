package demo1.demo15Exception;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo02RegisterException {
  public static void main(String[] args)/* throws RegisterException*/ {
    ArrayList<String> users = new ArrayList<>();
    users.add("张三");
    users.add("李四");

    Scanner sc = new Scanner(System.in);
    System.out.println("请输入新的用户名");
    createUser(users, sc);
//    String uname = sc.next();
//    for (String user : users) {
//      if (user.equals(uname)) {
//        System.out.println("用户名已存在，请重新输入");
//
//      }
//    }
  }

  public static void createUser(ArrayList users, Scanner sc)/* throws RegisterException*/ {
//    String username = sc.next();
//    Boolean flag = false;
//    for (Object user : users) {
//      if (user.equals(username)) {
//        flag = true;
//        break;
//      }
//    }
//    if (flag) {
//      System.out.println("用户名已存在，请重新输入");
//      createUser(users, sc);
//    } else {
//      System.out.println("用户名创建成功");
//    }
    String username = sc.next();
    for (Object user : users) {
      if (user.equals(username)) {
        try {
          throw new RegisterException("用户名已存在");
        } catch (RegisterException e) {
          e.printStackTrace();
          return;
        }
      }
    }
    System.out.println("用户名创建成功");
  }
}
