package arcade.thecore;

import java.util.Arrays;

/*
In the popular Minesweeper game you have a board with some mines and those cells that don't contain
a mine have a number in it that indicates the total number of mines in the neighboring cells.
Starting off with some arrangement of mines we want to create a Minesweeper game setup.

Example
For
matrix = [[true, false, false],
          [false, true, false],
          [false, false, false]]
the output should be
solution(matrix) = [[1, 2, 1],
                    [2, 1, 1],
                    [1, 1, 1]]
Check out the image below for better understanding:
https://codesignal.s3.amazonaws.com/uploads/1667239798707/example.png?raw=true
 */
public class CS107_Minesweeper {
    public static void main(String[] args) {
        Arrays.stream(solution(new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, false, false}})).map(Arrays::toString).forEach(System.out::println);
    }

    static int[][] solution(boolean[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    updateNeighbours(result, i, j);
                }
            }
        }
        return result;
    }

    static void updateNeighbours(int[][] result, int row, int col) {
        int rows = result.length;
        int cols = result[0].length;
        for (int i = Math.max(0, row - 1); i <= Math.min(rows - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(cols - 1, col + 1); j++) {
                result[i][j]++;
            }
        }
        result[row][col]--;
    }
}
