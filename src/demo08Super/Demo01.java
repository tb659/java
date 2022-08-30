package demo08Super;
/*
*   super 父类调用 必须子类构造方法的第一句 且只能调用一次
*   子类必须调用父类构造方法
*     不写默认赠送 super();
*     写了则用写的指定的super();
*     super(); 只能有一个 且是第一个
* */
public class Demo01 {
  public static void main(String[] args) {
    Student student = new Student();
  }
}
