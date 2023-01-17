import java.util.Arrays;

/* All Longest Strings
Given an array of strings, return another array containing all of its longest strings.
Example
For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
solution(inputArray) = ["aba", "vcd", "aba"].
 */
public class CS09_AllLongestStrings {
    public static void main(String[] args) {
        String inputArray[] = {"aba", "aa", "ad", "vcd", "aba"};
        System.out.println(Arrays.toString(solution(inputArray)));
    }

    public static String[] solution(String[] inputArray) {
        int max = 0;
        for (String w : inputArray) {
            if (w.length() > max) max = w.length();
        }
        int counter = 0;
        for (String w : inputArray) {
            if (w.length() == max) counter++;
        }
        String result[] = new String[counter];
        int idx = 0;
        for (String w : inputArray) {
            if (w.length() == max) {
                result[idx] = w;
                idx++;
            }
        }
        return result;
    }
}