package arcade.thecore;

import java.util.Arrays;

/*
Given an array of integers, sort its elements by the difference of their largest and smallest digits.
In the case of a tie, that with the larger index in the array should come first.

Example
For a = [152, 23, 7, 887, 243], the output should be
solution(a) = [7, 887, 23, 243, 152].

Here are the differences of all the numbers:

152: difference = 5 - 1 = 4;
23: difference = 3 - 2 = 1;
7: difference = 7 - 7 = 0;
887: difference = 8 - 7 = 1;
243: difference = 4 - 2 = 2.
23 and 887 have the same difference, but 887 goes after 23 in a, so in the sorted array it comes first.
 */
public class CS120_DigitDifferenceSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{152, 23, 7, 887, 243})));
    }

    static int[] solution(int[] a) {
        int[] differences = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            differences[i] = getDifference(a[i]);
        }
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (differences[i] >= differences[j]) {
                    temp = differences[i];
                    differences[i] = differences[j];
                    differences[j] = temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    private static int getDifference(int num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = num; i > 0; i /= 10) {
            min = Math.min(min, i % 10);
            max = Math.max(max, i % 10);
        }
        return max - min;
    }
}
