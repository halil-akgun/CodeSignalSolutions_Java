package arcade.thecore;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of strings, sort them in the order of increasing lengths. If two strings
have the same length, their relative order must be the same as in the initial array.

Example
For
inputArray = ["abc",
              "",
              "aaa",
              "a",
              "zz"]
the output should be
solution(inputArray) = ["",
                        "a",
                        "zz",
                        "abc",
                        "aaa"]
 */
public class CS116_SortByLength {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"abc", "", "aaa", "a", "zz"})));
    }

    static String[] solution(String[] inputArray) {
        return Arrays.stream(inputArray).sorted(Comparator.comparing(String::length)).toArray(String[]::new);
    }
}
