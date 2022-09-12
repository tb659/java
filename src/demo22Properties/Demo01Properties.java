package demo22Properties;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Demo01Properties {
  public static void main(String[] args) throws IOException {
    Properties prop = new Properties();
    prop.setProperty("迪丽热巴", "168");
    prop.setProperty("古利那扎", "168");
    prop.setProperty("马儿扎哈", "168");
    prop.setProperty("name", "jack");

    Set<String> strings = prop.stringPropertyNames();
    for (String key : strings) {
      String value = prop.getProperty(key);
      System.out.println(key + " = " + value);
    }

    FileWriter write = new FileWriter("prop.txt");
    prop.store(write, "save data by string");
    write.close();

    FileOutputStream write2 = new FileOutputStream("prop2.txt");
    prop.store(write2, "save data by char");
    write2.close();

    System.out.println("==================");

    FileReader reader = new FileReader("prop.txt");
    Properties propReader = new Properties();

    propReader.load(reader);
    System.out.println(propReader);
    reader.close();

    System.out.println("==================");

    FileReader reader2 = new FileReader("prop2.txt");
    Properties propReader2 = new Properties();
    propReader2.load(reader2);
    System.out.println(propReader2);
    reader2.close();
  }
}
