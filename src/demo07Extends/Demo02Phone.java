package demo07Extends;

public class Demo02Phone {
  public static void main(String[] args) {
    PhoneOld phoneold = new PhoneOld();
    phoneold.call();
    phoneold.send();
    phoneold.show();

    System.out.println("========================");

    PhoneNew phone = new PhoneNew();
    phone.call();
    phone.send();
    phone.show();
  }
}
