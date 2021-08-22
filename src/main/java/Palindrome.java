public class Palindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome("NITIN"));
    System.out.println(isPalindrome("XYZ"));
  }

  private static boolean isPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;
    while (i < j) {
      char ch1 = str.charAt(i);
      char ch2 = str.charAt(j);
      if (ch1 != ch2) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }
}
