package arcade.intro;

import java.util.Arrays;

/* All Longest Strings
Given an array of strings, return another array containing all of its longest strings.
Example
For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
solution(inputArray) = ["aba", "vcd", "aba"].
 */
public class CS09_AllLongestStrings {
    public static void main(String[] args) {
        String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
        System.out.println(Arrays.toString(solution(inputArray)));
    }

    public static String[] solution(String[] inputArray) {
        Arrays.sort(inputArray);
        int maxLength = inputArray[inputArray.length - 1].length();
        int counter = 0;

        for (String w : inputArray) {
            if (w.length() == maxLength) counter++;
        }

        String[] result = new String[counter];
        int idx = 0;
        for (String w : inputArray) {
            if (w.length() == maxLength) {
                result[idx] = w;
                idx++;
            }
        }
        return result;
    }
}