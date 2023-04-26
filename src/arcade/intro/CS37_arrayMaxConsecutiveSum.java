package arcade.intro;

/*
Given array of integers, find the maximal possible sum of some of its k consecutive elements.

Example
For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
solution(inputArray, k) = 8.
All possible sums of 2 consecutive elements are:
2 + 3 = 5;
3 + 5 = 8;
5 + 1 = 6;
1 + 6 = 7.
Thus, the answer is 8.
 */
public class CS37_arrayMaxConsecutiveSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 6};
        System.out.println(solution(arr, 2));
    }

    static int solution(int[] inputArray, int k) {
        int max = inputArray[0];
        int temp = 0;
        for (int i = k - 1; i < inputArray.length; i++) {
            for (int j = 0; j < k; j++) {
                temp += inputArray[i - j];
            }
            max = Math.max(temp, max);
            temp = 0;
        }
        return max;
    }
}
