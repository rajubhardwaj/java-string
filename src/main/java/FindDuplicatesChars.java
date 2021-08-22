import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesChars {
  static final int NO_OF_CHARS = 256;
  public static void main(String[] args) {
    printDuplicatesSol1("test string");
    printDuplicatesSol2("test string");
    printDuplicatesSol3("test string");
  }

  private static void printDuplicatesSol3(String str) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < str.length()-1; i++) {
      if (map.containsKey(str.charAt(i))){
        map.put(str.charAt(i), map.get(str.charAt(i)) +1);
      }else{
        map.put(str.charAt(i),1);
      }
    }
    map.entrySet().stream().filter(entry -> entry.getValue() > 1 && entry.getValue() != ' ').forEach((entry) ->  System.out.println("Char: " + entry.getKey() + ", Count: " + entry.getValue() + " times."));

  }

  private static void printDuplicatesSol2(String str) {
    int[] count = new int[NO_OF_CHARS];
    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i)]++;
    }

    for (int i = 0; i < NO_OF_CHARS; i++)
      if (count[i] > 1 && count[i] != ' ')
        System.out.println("Char: " + (char)i + ", Count: " + count[i] + " times.");
  }

  public static void printDuplicatesSol1(String inputString) {
    int count = 0;
    List<Character> charList = new ArrayList<>();
    for (int i = 0; i < inputString.length(); i++) {
      char ch = inputString.charAt(i);
      for (int j = 0; j < inputString.length(); j++) {
        if (inputString.charAt(j) == ch) {
          count++;
        }
      }

      if (!charList.contains(ch)) {
        if (count > 1 && ch != ' ') {
          System.out.println("Char: " + ch + ", Count: " + count + " times.");
          charList.add(ch);
        }
      }
      count = 0;
    }
  }
}
