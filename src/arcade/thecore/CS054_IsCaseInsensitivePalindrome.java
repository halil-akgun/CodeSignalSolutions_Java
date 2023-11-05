package arcade.thecore;

/*
Given a string, check if it can become a palindrome through a case change of some (possibly, none) letters.

Example
For inputString = "AaBaa", the output should be
solution(inputString) = true.
"aabaa" is a palindrome as well as "AABAA", "aaBaa", etc.

For inputString = "abac", the output should be
solution(inputString) = false.
All the strings which can be obtained via changing case of some group of letters,
i.e. "abac", "Abac", "aBAc" and 13 more, are not palindromes.
 */
public class CS054_IsCaseInsensitivePalindrome {
    public static void main(String[] args) {
        System.out.println(solution("AaBaa"));
    }

    static boolean solution(String inputString) {
        // method 1
        return new StringBuilder(inputString).reverse().toString().equalsIgnoreCase(inputString);

        // method 2
//        String strToLowerCase = inputString.toLowerCase();
//        for (int i = 0; i < strToLowerCase.length() / 2; i++) {
//            if (strToLowerCase.charAt(i) != strToLowerCase.charAt(strToLowerCase.length() - 1 - i)) return false;
//        }
//        return true;
    }
}
