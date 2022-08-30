package demo07Extends;

public class PhoneNew extends PhoneOld {

  @Override
  public void show() {
    super.show();
    System.out.println("显示头像");
    System.out.println("显示姓名");
  }
}
