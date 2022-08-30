package demo10RedPacket;

import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Manager manager = new Manager("群主", 100);

    Member memberA = new Member("成员A", 0);
    Member memberB = new Member("成员B", 0);
    Member memberC = new Member("成员C", 0);

    manager.show();
    memberA.show();
    memberB.show();
    memberC.show();

    ArrayList<Integer> redMoney = manager.send(120, 3);
    memberA.receive(redMoney);
    memberB.receive(redMoney);
    memberC.receive(redMoney);

    System.out.println("=====================");

    manager.show();
    memberA.show();
    memberB.show();
    memberC.show();
  }
}
