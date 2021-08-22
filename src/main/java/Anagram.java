import java.util.Arrays;

public class Anagram {
  public static void main(String[] args) {
    System.out.println(isAnagramSol1("SILENT", "LISTEN"));
    System.out.println(isAnagramSol1("ABC", "XYZ"));

    System.out.println(isAnagramSol2("KEEP", "PEEK"));
    System.out.println(isAnagramSol2("ABC", "XYZ"));

    System.out.println(isAnagramSol3("KEEP", "PEEK"));
    System.out.println(isAnagramSol3("ABC", "XYZ"));
  }

  private static boolean isAnagramSol1(String str1, String str2) {
    char[] arr1 = str1.toLowerCase().toCharArray();
    char[] arr2 = str2.toLowerCase().toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    int i = 0;
    int j = arr1.length - 1;
    while (i < j) {
      if (arr1[i] != arr2[i] || arr1[j] != arr2[j]) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  private static boolean isAnagramSol2(String str1, String str2) {
    String s1 = str1.replaceAll("\\s", "");
    String s2 = str2.replaceAll("\\s", "");
    if (s1.length() != s2.length()) {
      return false;
    } else {
      char[] ArrayS1 = s1.toLowerCase().toCharArray();
      char[] ArrayS2 = s2.toLowerCase().toCharArray();
      Arrays.sort(ArrayS1);
      Arrays.sort(ArrayS2);
      return Arrays.equals(ArrayS1, ArrayS2);
    }
  }

  static boolean isAnagramSol3(String str1, String str2) {
    int NO_OF_CHARS = 256;
    char[] arr1 = str1.toLowerCase().toCharArray();
    char[] arr2 = str2.toLowerCase().toCharArray();

    int[] count = new int[NO_OF_CHARS];

    if (arr1.length != arr2.length) {
      return false;
    } else {
      for (int i = 0; i < arr1.length; i++) {
        count[arr1[i] - 'a']++;
        count[arr2[i] - 'a']--;
      }
      for (int i = 0; i < NO_OF_CHARS; i++) {
        if (count[i] != 0) {
          return false;
        }
      }
      return true;
    }
  }
}
