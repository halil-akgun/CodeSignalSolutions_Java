package arcade.thecore;

import java.util.Arrays;

/*
Given a string consisting of lowercase English letters, find the largest square
number which can be obtained by reordering the string's characters and replacing
them with any digits you need (leading zeros are not allowed) where same characters
always map to the same digits and different characters always map to different digits.

If there is no solution, return -1.

Example
For s = "ab", the output should be
solution(s) = 81.
The largest 2-digit square number with different digits is 81.
For s = "zzz", the output should be
solution(s) = -1.
There are no 3-digit square numbers with identical digits.
For s = "aba", the output should be
solution(s) = 900.
It can be obtained after reordering the initial string into "baa" and replacing "a" with 0 and "b" with 9.
 */
public class CS062_ConstructSquare {
    public static void main(String[] args) {
        System.out.println(solution("ab"));
    }

    static int solution(String s) {
        int lengthMin = Integer.parseInt("1" + "0".repeat(s.length() - 1));
        int lengthMax = Integer.parseInt("9".repeat(s.length()));
        for (int i = lengthMax; i >= lengthMin; i--) {
            double sqr = Math.sqrt(i);
            if (sqr - Math.floor(sqr) == 0 && Arrays.equals(countLetters(String.valueOf(i)), countLetters(s))) {
                return i;
            }
        }
        return -1;
    }

    static int[] countLetters(String str) {
        int[] arr = new int[str.length()];
        int idx = 0;
        while (!str.isEmpty()) {
            int size = str.length();
            str = str.replaceAll(str.substring(0, 1), "");
            arr[idx++] = size - str.length();
        }
        Arrays.sort(arr);
        return arr;
    }
}
