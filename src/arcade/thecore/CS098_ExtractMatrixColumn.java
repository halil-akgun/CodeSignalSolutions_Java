package arcade.thecore;

import java.util.Arrays;

/*
Given a rectangular matrix and an integer column, return an array containing the elements
of the columnth column of the given matrix (the leftmost column is the 0th one).

Example
For
matrix = [[1, 1, 1, 2],
          [0, 5, 0, 4],
          [2, 1, 3, 6]]
and column = 2, the output should be
solution(matrix, column) = [1, 0, 3].
 */
public class CS098_ExtractMatrixColumn {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 1, 2}, {0, 5, 0, 4}, {2, 1, 3, 6}}, 2)));
    }

    static int[] solution(int[][] matrix, int column) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[i][column];
        }
        return result;
    }
}
