package demo1.demo07Extends;

public class Assistant extends Employee {

  /*
        注解 重写
        1、子类返回值【小于等于】父类返回值
        2、子类权限修饰符【大于等于】父类权限修饰符
          public > protected > (default) > private
            default => 不写 留空

  * */
  @Override
  public void methodSameName() {
    System.out.println("子类方法执行！");
  }
}
