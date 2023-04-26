package arcade.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string, find out if its characters can be rearranged to form a palindrome.

Example
For inputString = "aabb", the output should be
solution(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.
 */
public class CS18_PalindromeRearranging {
    public static void main(String[] args) {
        System.out.println(solution("aabb"));
    }

    static boolean solution(String inputString) {
        String[] arr = inputString.toLowerCase().split("");
        Arrays.sort(arr);
        List<Integer> amountOfChars = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    counter++;
                    if (j == arr.length - 1) i = arr.length - 1;
                } else {
                    i = j - 1;
                    break;
                }
            }
            amountOfChars.add(counter);
            counter = 0;
        }
        int counter2 = 0;
        for (Integer w : amountOfChars) {
            if (w % 2 == 1) counter2++;
        }
        if (inputString.length() % 2 == 0 && counter2 == 0) {
            return true;
        } else if (inputString.length() % 2 == 1 && counter2 == 1) {
            return true;
        }
        return false;
    }
}
