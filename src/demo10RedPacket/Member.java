package demo10RedPacket;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
  public Member() {
  }

  public Member(String name, int money) {
    super(name, money);
  }

  public void receive(ArrayList<Integer> list) {
    if (list.size() == 0) {
      System.out.println("余额不足，不能发红包");
      return;
    }
    int index = new Random().nextInt(list.size());

    int money = list.remove(index);
    super.setMoney(super.getMoney() + money);
  }
}
