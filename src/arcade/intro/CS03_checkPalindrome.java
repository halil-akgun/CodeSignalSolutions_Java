package arcade.intro;

/*
Given the string, check if it is a palindrome.

Example
For inputString = "aabaa", the output should be
solution(inputString) = true;
For inputString = "abac", the output should be
solution(inputString) = false;
For inputString = "a", the output should be
solution(inputString) = true.
 */
public class CS03_checkPalindrome {
    public static void main(String[] args) {
        System.out.println(solution("aabaa"));
    }

    static boolean solution(String inputString) {

        for (int i = 0; i < inputString.length(); i++) {
            if (!(inputString.charAt(i) == inputString.charAt(inputString.length() - 1 - i))) {
                return false;
            }
        }
        return true;

    }
}
