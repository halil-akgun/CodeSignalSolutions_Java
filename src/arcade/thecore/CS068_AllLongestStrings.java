package arcade.thecore;

import java.util.Arrays;

/*
Given an array of strings, return another array containing all of its longest strings.

Example
For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
solution(inputArray) = ["aba", "vcd", "aba"].
 */
public class CS068_AllLongestStrings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"aba", "aa", "ad", "vcd", "aba"})));
    }

    static String[] solution(String[] inputArray) {
        int maxLength = Arrays.stream(inputArray).map(String::length).max(Integer::compareTo).orElse(0);
        return Arrays.stream(inputArray).filter(t -> t.length() == maxLength).toArray(String[]::new);
    }
}
