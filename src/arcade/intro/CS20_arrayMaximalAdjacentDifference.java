package arcade.intro;

/*
Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.

Example
For inputArray = [2, 4, 1, 0], the output should be
solution(inputArray) = 3.
 */
public class CS20_arrayMaximalAdjacentDifference {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 0};
        System.out.println(solution(arr));
    }

    static int solution(int[] inputArray) {
        int maximalAbsolute = inputArray[0] - inputArray[1];
        for (int i = 1; i < inputArray.length; i++) {
            maximalAbsolute = Math.max(maximalAbsolute, Math.abs(inputArray[i] - inputArray[i - 1]));
        }
        return maximalAbsolute;
    }
}
