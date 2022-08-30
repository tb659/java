package demo10RedPacket;

import java.util.ArrayList;

public class Manager extends User {
  public Manager() {
  }

  public Manager(String name, int money) {
    super(name, money);
  }

  public ArrayList<Integer> send(int money, int count) {

    ArrayList<Integer> redList = new ArrayList<>();

    int leftMoney = super.getMoney();
    if (leftMoney < money) {
      System.out.println("余额不足");
      return redList;
    }

    super.setMoney(leftMoney - money);

    int avg = money / count;
    int mod = money % count;
    for (int i = 0; i < count - 1; i++) {
      redList.add(avg);
    }
    redList.add(avg + mod);
    return redList;
  }
}
