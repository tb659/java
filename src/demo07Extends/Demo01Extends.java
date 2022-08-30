package demo07Extends;

public class Demo01Extends {
  public static void main(String[] args) {

    Teacher teacher = new Teacher();
    teacher.method();
    teacher.printNum();

    Assistant assistant = new Assistant();
    assistant.method();
    assistant.methodSameName();

    /*
    *   override 重写 方法名称相同 参数列表相同
    *   overload 重载 方法名称相同 参数列表不同
    * */
  }

}
