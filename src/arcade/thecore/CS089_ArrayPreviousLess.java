package arcade.thecore;

import java.util.Arrays;

/*
Given array of integers, for each position i, search among the previous positions
for the last(from the left) position that contains a smaller value. Store this value
at position i in the answer. If no such value can be found, store -1 instead.

Example
For items = [3, 5, 2, 4, 5], the output should be
solution(items) = [-1, 3, -1, 2, 4].
 */
public class CS089_ArrayPreviousLess {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 5, 2, 4, 5})));
    }

    static int[] solution(int[] items) {
        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            int min = -1;
            for (int j = 0; j < i; j++) {
                if (items[j] < items[i]) min = items[j];
            }
            result[i] = min;
        }
        return result;
    }
}
