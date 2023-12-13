package arcade.thecore;

/*
Given an array of 2k integers (for some integer k), perform the following
operations until the array contains only one element:

On the 1st, 3rd, 5th, etc. iterations (1-based) replace each pair of consecutive elements with their sum;
On the 2nd, 4th, 6th, etc. iterations replace each pair of consecutive elements with their product.
After the algorithm has finished, there will be a single element left in the array. Return that element.

Example
For inputArray = [1, 2, 3, 4, 5, 6, 7, 8], the output should be
solution(inputArray) = 186.
We have [1, 2, 3, 4, 5, 6, 7, 8] -> [3, 7, 11, 15] -> [21, 165] -> [186], so the answer is 186.
 */
public class CS088_ArrayConversion {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    static int solution(int[] inputArray) {
        boolean isSum = true;
        while (inputArray.length > 1) {
            inputArray = calculate(inputArray, isSum);
            isSum = !isSum;
        }
        return inputArray[0];
    }

    static int[] calculate(int[] arr, boolean isSum) {
        int[] result = new int[arr.length / 2];
        for (int i = 1; i < arr.length; i += 2) {
            if (isSum) {
                result[i / 2] += arr[i - 1] + arr[i];
            } else {
                result[i / 2] += arr[i - 1] * arr[i];
            }
        }
        return result;
    }
}
