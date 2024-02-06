package arcade.thecore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
You are given a string s of characters that contains at least n numbers (here, a number is
defined as a consecutive series of digits, where any character immediately to the left and
right of the series are not digits). The numbers may contain leading zeros, but it is
guaranteed that each number has at least one non-zero digit in it.

Your task is to find the nth number and return it as a string without leading zeros.

Example
For s = "8one 003number 201numbers li-000233le number444" and n = 4,
the output should be
solution(s, n) = "233".
 */
public class CS141_NthNumber {
    public static void main(String[] args) {
        System.out.println(solution("8one 003number 201numbers li-000233le number444", 4));
    }

    static String solution(String s, int n) {
        Pattern pattern = Pattern.compile(
                "(?:[^0-9]*[0-9]+){" + (n - 1) + "}[^1-9]+([0-9]+).*" // Solution by bandorthild (codesignal)
        );

        Matcher matcher = pattern.matcher(s);
        matcher.matches();
        return matcher.group(1);
    }
}
