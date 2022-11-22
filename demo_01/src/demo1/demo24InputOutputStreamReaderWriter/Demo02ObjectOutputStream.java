package demo1.demo24InputOutputStreamReaderWriter;

import java.io.*;

public class Demo02ObjectOutputStream {
  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Employee e = new Employee("mt", "家", 12);
//    e.name = "mt";
//    e.address = "家";
//    e.age = 12;

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("g.txt"));
    oos.writeObject(e);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("g.txt"));
    Object o = ois.readObject();
    ois.close();
    System.out.println(o); // age 0  Employee{name='mt', address='家', age=0}
    System.out.println(((Employee) o).getAddress());
  }
}
