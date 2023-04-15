package arcade;

import java.util.Arrays;
import java.util.Comparator;

/*
Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

Example
For text = "Ready, steady, go!", the output should be
solution(text) = "steady".
 */
public class CS52_longestWord {
    public static void main(String[] args) {
        String str = "Ready, steady, go!";
        System.out.println(solution(str));
    }

    static String solution(String text) {
        String[] strArr = text.replaceAll("\\p{Punct}", " ").split(" ");
        Arrays.sort(strArr, Comparator.comparing(String::length).reversed());
        return strArr[0];
    }
}
