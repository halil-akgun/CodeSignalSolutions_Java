package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

Example
For
matrix = [[1, 2, 1],
          [2, 2, 2],
          [2, 2, 2],
          [1, 2, 3],
          [2, 2, 1]]
the output should be
solution(matrix) = 6.

Here are all 6 different 2 × 2 squares:
- 1 2
  2 2
- 2 1
  2 2
- 2 2
  2 2
- 2 2
  1 2
- 2 2
  2 3
- 2 3
  2 1
 */
public class CS064_DifferentSquares {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 2, 1},
                {2, 2, 2},
                {2, 2, 2},
                {1, 2, 3},
                {2, 2, 1}
        }));
    }

    static int solution(int[][] matrix) {
        int result = 0;
        int left = 0, top = 0;
        List<int[][]> arrList = new ArrayList<>();
        while (top + 1 < matrix.length) {
            while (left + 1 < matrix[0].length) {
                int[][] arr = new int[2][2];
                arr[0][0] = matrix[top][left];
                arr[0][1] = matrix[top][left + 1];
                arr[1][0] = matrix[top + 1][left];
                arr[1][1] = matrix[top + 1][left + 1];
                if (arrList.stream().noneMatch(t -> Arrays.deepEquals(t, arr))) {
                    arrList.add(arr);
                    result++;
                }
                left++;
            }
            top++;
            left = 0;
        }
        return result;
    }
}
