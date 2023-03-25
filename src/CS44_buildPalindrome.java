/*
Given a string, find the shortest possible string which can be achieved by adding characters to
the end of initial string to make it a palindrome.

Example
For st = "abcdc", the output should be
solution(st) = "abcdcba".
 */
public class CS44_buildPalindrome {
    public static void main(String[] args) {
        String str = "abcdc";
        System.out.println(solution(str));
    }

    static String solution(String str) {
        StringBuilder result = new StringBuilder(str);
        if (isPalindrome(result)) return result.toString();
        for (int i = 0; i < str.length(); i++) {
            result.insert(str.length(), str.charAt(i));
            if (isPalindrome(result)) return result.toString();
        }
        return result.toString();
    }

    static boolean isPalindrome(StringBuilder stb) {
        StringBuilder temp = new StringBuilder(stb);
        String reverse = temp.reverse().toString();
        return reverse.equals(stb.toString());
    }
}