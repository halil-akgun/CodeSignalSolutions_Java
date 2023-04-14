package arcade;

import java.util.Arrays;

/*
Given array of integers, remove each kth element from it.

Example
For inputArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and k = 3, the output should be
solution(inputArray, k) = [1, 2, 4, 5, 7, 8, 10].
 */
public class CS34_extractEachKth {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(solution(arr, 3)));
    }

    static int[] solution(int[] inputArray, int k) {
        int[] result = new int[inputArray.length - inputArray.length / k];
        int idx = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if ((i + 1) % k == 0) continue;
            result[idx] = inputArray[i];
            idx++;
        }
        return result;
    }
}
