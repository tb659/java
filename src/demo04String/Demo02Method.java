package demo04String;

public class Demo02Method {
  public static void main(String[] args) {
    String str1 = "abc";
    String str2 = "abc";
    char charArray[] = {'a', 'b', 'c'};
    String str3 = new String(charArray);
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);
    System.out.println(str2 == str3);

    System.out.println("***********************");

    System.out.println(str1.equals(str3));
    System.out.println(str1.equals("abc"));
    System.out.println("abc".equals(str1));

    System.out.println("***********************");

    System.out.println("Abc".equals(str1));
    System.out.println("Abc".equalsIgnoreCase(str1));

    System.out.println("***********************");

    String str4 = "successfully";

    System.out.println("***********************");
    String str6 = "World";
    String str5 = "Hello";
    String str7 = "中华人民共和国";
    String str8 = "12345611111";
    String str9 = "  q1234561111  1v   ";

    System.out.println("***********************");
    System.out.println(str9.length());
    System.out.println(str5.concat(str6)); // 将指定字符串连接到此字符串的结尾。
    System.out.println(str4.charAt(4)); // 返回指定索引处的 char 值。
    System.out.println(str8.indexOf('2')); // 返回指定字符在此字符串中第一次出现处的索引。
    System.out.println(str8.indexOf('1', 4)); // 返回指定字符在此字符串中第一次出现处的索引。
    System.out.println(str8.lastIndexOf('2')); // 返回指定字符在此字符串中最后一次出现处的索引。
    System.out.println(str8.lastIndexOf('1', 4)); // 返回指定字符在此字符串中最后一次出现处的索引。
    System.out.println(str8.lastIndexOf("e")); // 返回指定字符在此字符串中最后一次出现处的索引。
    System.out.println(str8.lastIndexOf("l", 4)); // 返回指定字符在此字符串中最后一次出现处的索引。
    System.out.println("***********************");

    System.out.println(str8.substring(3)); // 返回一个新的字符序列，它是此序列的一个子序列。
    System.out.println(str8.substring(3, 7)); // 返回一个新的字符序列，它是此序列的一个子序列。
    System.out.println(str8.subSequence(3, 7)); // 返回一个新的字符序列，它是此序列的一个子序列。
    System.out.println("***********************");

    System.out.println(str8.toCharArray()); // 将此字符串转换为一个新的字符数组。
    System.out.println(str8.replace("l", "4")); // 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
    System.out.println(str8.replaceAll("1", "2")); // 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
    // 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
    for (byte aByte : str8.getBytes()) {
      System.out.println(aByte);
    }
    System.out.println("***********************");

    // 根据给定正则表达式的匹配拆分此字符串。
    for (String s : str7.split("")) {
      System.out.println(s);
    }
    String str10 = "123.456.789";
    for (String s : str10.split("\\.")) {
      System.out.println(s);
    }
    System.out.println("***********************");

    System.out.println(str4.codePointAt(4)); // 返回指定索引处的字符（Unicode 代码点）。
    System.out.println(str7.codePointAt(4)); // 返回指定索引处的字符（Unicode 代码点）。
    System.out.println(str4.codePointBefore(4)); // 返回指定索引之前的字符（Unicode 代码点）。
//    System.out.println(str4.codePointCount(3, 2)); // IndexOutOfBoundsException 索引越界异常
    System.out.println(str4.codePointCount(1, 4)); // 返回此 String 的指定文本范围中的 Unicode 代码点数。
    System.out.println(str4.compareTo("error")); // 按字典顺序比较两个字符串。
    System.out.println(str4.compareTo("successfully"));
    System.out.println(str4.compareToIgnoreCase("successfully")); // 按字典顺序比较两个字符串，不考虑大小写。
    System.out.println(str5.contains("He")); // 当且仅当此字符串包含指定的 char 值序列时，返回 true。
    System.out.println(str5.contains("Hello")); // 当且仅当此字符串包含指定的 char 值序列时，返回 true。
    System.out.println(str5.endsWith("o")); //  测试此字符串是否以指定的后缀结束。
    System.out.println(str5.equals("Hello")); // 将此字符串与指定的对象比较。
    System.out.println(str5.equalsIgnoreCase("hello")); // 将此 String 与另一个 String 比较，不考虑大小写。
    System.out.println(str8.isEmpty()); // 当且仅当 length() 为 0 时返回 true。
    System.out.println(str8.startsWith("1")); // 测试此字符串是否以指定的前缀开始。
    System.out.println(str8.startsWith("1", 7)); // 测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
    System.out.println(str5.toLowerCase()); // 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
    System.out.println(str5.toUpperCase()); // 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
    System.out.println(str9.trim()); // 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
    System.out.println(str5.valueOf(true)); // 返回 boolean 参数的字符串表示形式。
    System.out.println(str5.valueOf('e')); // 返回 char 参数的字符串表示形式。
    System.out.println(str5.valueOf(new char[]{'e'})); // 返回 char 数组参数的字符串表示形式。
//    System.out.println(str5.valueOf(new char[]{'e'}, 3, 4)); // 返回 char 数组参数的特定子数组的字符串表示形式。
    System.out.println(str5.valueOf(3.14)); // 返回 double 参数的字符串表示形式。
    System.out.println(str5.valueOf(2.2F)); // 返回 float 参数的字符串表示形式。
    System.out.println(str5.valueOf(23)); // 返回 int 参数的字符串表示形式。
    System.out.println(str5.valueOf(12L)); // 返回 long 参数的字符串表示形式。
    System.out.println(str5.valueOf(new Object())); // 返回 Object 参数的字符串表示形式。
  }
}
