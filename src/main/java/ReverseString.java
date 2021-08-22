import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseString {
  public static void main(String[] args) {
    System.out.println(reverseStringSol1("ABC"));
    System.out.println(reverseStringSol2("DEF"));
    System.out.println(reverseStringSol3("GHI"));
    System.out.println(
        "JKL".chars().mapToObj(c -> (char) c).reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1));
    System.out.println(
        "MNO"
            .chars()
            .collect(
                StringBuilder::new, (sb, c) -> sb.insert(0, (char) c), (b1, b2) -> b1.insert(0, b2))
            .toString());
    System.out.println(
        Stream.of("PQRS")
            .map(word -> new StringBuilder(word).reverse())
            .collect(Collectors.joining("")));
    String str = "STU";
    System.out.println(
        IntStream.range(0, str.length())
            .map(i -> str.charAt(str.length() - i - 1))
            .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
            .toString());
  }

  private static String reverseStringSol1(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  private static String reverseStringSol2(String str) {
    char[] arr = str.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--) {
      sb.append(arr[i]);
    }
    return sb.toString();
  }

  private static String reverseStringSol3(String str) {
    char[] arr = str.toCharArray();
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
    return new String(arr);
  }
}
