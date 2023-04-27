package arcade.intro;

/*
Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.

Example
For inputArray = [3, 6, -2, -5, 7, 3], the output should be
solution(inputArray) = 21.

7 and 3 produce the largest product.
 */
public class CS04_adjacentElementsProduct {
    public static void main(String[] args) {
        int[] arr = {3, 6, -2, -5, 7, 3};
        System.out.println(solution(arr));
    }

    static int solution(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < inputArray.length; i++) {
            max = Math.max(max, inputArray[i] * inputArray[i - 1]);
        }
        return max;
    }
}
