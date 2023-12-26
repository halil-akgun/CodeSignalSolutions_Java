package arcade.thecore;

import java.util.Arrays;

/*
The longest diagonals of a square matrix are defined as follows:

the first longest diagonal goes from the top left corner to the bottom right one;
the second longest diagonal goes from the top right corner to the bottom left one.
Given a square matrix, your task is to swap its longest diagonals by exchanging their elements at the corresponding positions.

Example
For
matrix = [[1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]]
the output should be
solution(matrix) = [[3, 2, 1],
                    [4, 5, 6],
                    [9, 8, 7]]
 */
public class CS101_SwapDiagonals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    static int[][] solution(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int temp1 = matrix[i][i];
            int temp2 = matrix[matrix.length - 1 - i][i];
            matrix[i][i] = matrix[i][matrix.length - 1 - i];
            matrix[matrix.length - 1 - i][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - i];
            matrix[i][matrix.length - 1 - i] = temp1;
            matrix[matrix.length - 1 - i][matrix.length - 1 - i] = temp2;
        }
        return matrix;
    }
}
