package arcade.thecore;

import java.util.regex.Pattern;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
Given a string s, determine if it is a subsequence of a given string t.

Example
For t = "CodeSignal" and s = "CoSi", the output should be
solution(t, s) = true;

For t = "CodeSignal" and s = "cosi", the output should be
the output should be
solution(t, s) = false.
 */
public class CS142_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(solution("CodeSignal", "CoSi"));
    }

    static boolean solution(String t, String s) {
        String pattern = "";
        for (int i = 0; i < s.length(); i++) {
            pattern += "[" + s.charAt(i) + "]" + ".*"; // Solution by bandorthild (codesignal)
        }
        Pattern regex = Pattern.compile(pattern);
        return regex.matcher(t).find();
    }

}
