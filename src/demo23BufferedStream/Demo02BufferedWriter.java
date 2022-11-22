package demo23BufferedStream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Demo02BufferedWriter {
  public static void main(String[] args) {
    try (
      BufferedWriter bw = new BufferedWriter(new FileWriter("butteredWrite.txt"));
      BufferedReader br = new BufferedReader(new FileReader("butteredWrite.txt"));
    ) {
      bw.write("2.buffer字符流1");
      bw.newLine();
      bw.write("1.buffer字符流2");
      bw.flush();
      int len;
      while ((len = br.read()) != -1) {
//        System.out.println(br.readLine());
        System.out.print((char) len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    System.out.println("==============");
    try {
      BufferedReader br2 = new BufferedReader(new FileReader("butteredWrite.txt"));
//      System.out.println(br2.readLine());
//      System.out.println(br2.readLine());
//      System.out.println(br2.readLine());
      String line;
      while ((line = br2.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    HashMap<String, String> map = new HashMap<>();

    try (
      BufferedReader br = new BufferedReader(new FileReader("butteredWrite.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("butteredWrite2.txt"));
    ) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] arr = line.split("\\.");
        map.put(arr[0], arr[1]);
      }
      for (String key : map.keySet()) {
        line = key + "." + map.get(key);
        bw.write(line);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
