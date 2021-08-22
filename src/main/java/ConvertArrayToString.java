import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertArrayToString {

  public static void main(String[] args) {
    String[] arr = {"ABC", "DEF", "GHI"};
    System.out.println(Arrays.toString(arr));
    System.out.println(String.join("", arr));
    System.out.println(sol1(arr));
    System.out.println(Arrays.stream(arr).collect(Collectors.joining()));
  }

  private static String sol1(String[] stringArray) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String s : stringArray) {
      stringBuilder.append(s);
    }
    return stringBuilder.toString();
  }
}
