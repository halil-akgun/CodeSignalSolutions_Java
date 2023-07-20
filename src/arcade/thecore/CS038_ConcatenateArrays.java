package arcade.thecore;

import java.util.Arrays;

/*
Given two arrays of integers a and b, obtain the array formed by the elements of a followed by the elements of b.

Example
For a = [2, 2, 1] and b = [10, 11], the output should be
solution(a, b) = [2, 2, 1, 10, 11].
 */
public class CS038_ConcatenateArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 4, 5};
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }

    static int[] solution(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        System.arraycopy(a, 0, ans, 0, a.length);
        System.arraycopy(b, 0, ans, a.length, b.length);
        return ans;
    }
}
