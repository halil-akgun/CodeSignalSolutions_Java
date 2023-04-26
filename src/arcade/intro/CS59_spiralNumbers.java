package arcade.intro;

import java.util.Arrays;

/*
Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order,
starting from top-left and in clockwise direction.

Example
For n = 3, the output should be
solution(n) = [[1, 2, 3],
               [8, 9, 4],
               [7, 6, 5]]
 */
public class CS59_spiralNumbers {
    public static void main(String[] args) {
        int length = 3;
        System.out.println(Arrays.deepToString(solution(length)));
    }

    static int[][] solution(int n) {
        int[][] result = new int[n][n];
        int a = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left < n / 2 + 1) {
            for (int i = left; i <= right; i++) {
                result[top][i] = a++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = a++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = a++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = a++;
            }
            left++;
        }
        return result;
    }
}
