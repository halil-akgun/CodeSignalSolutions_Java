package arcade;

import java.util.Arrays;

/*
In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number
in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we
want to create a Minesweeper game setup.

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
https://codesignal.s3.amazonaws.com/uploads/1667239798707/example.png
 */
public class CS24_Minesweeper {
    public static void main(String[] args) {
        boolean[][] matrix = {{true, false, false}, {false, true, false}, {false, false, false}};
        System.out.println(Arrays.deepToString(solution(matrix)));
    }

    static int[][] solution(boolean[][] matrix) {
        int[][] solution = new int[matrix.length][matrix[0].length];
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        if (matrix[i][j + 1]) counter++;
                        if (matrix[i + 1][j]) counter++;
                        if (matrix[i + 1][j + 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    } else if (j == matrix[i].length - 1) {
                        if (matrix[i][j - 1]) counter++;
                        if (matrix[i + 1][j]) counter++;
                        if (matrix[i + 1][j - 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    } else {
                        if (matrix[i][j - 1]) counter++;
                        if (matrix[i][j + 1]) counter++;
                        if (matrix[i + 1][j]) counter++;
                        if (matrix[i + 1][j + 1]) counter++;
                        if (matrix[i + 1][j - 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    }
                } else if (i == matrix.length - 1) {
                    if (j == 0) {
                        if (matrix[i][j + 1]) counter++;
                        if (matrix[i - 1][j]) counter++;
                        if (matrix[i - 1][j + 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    } else if (j == matrix[i].length - 1) {
                        if (matrix[i][j - 1]) counter++;
                        if (matrix[i - 1][j]) counter++;
                        if (matrix[i - 1][j - 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    } else {
                        if (matrix[i][j - 1]) counter++;
                        if (matrix[i][j + 1]) counter++;
                        if (matrix[i - 1][j]) counter++;
                        if (matrix[i - 1][j + 1]) counter++;
                        if (matrix[i - 1][j - 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    }
                } else {
                    if (j == 0) {
                        if (matrix[i][j + 1]) counter++;
                        if (matrix[i - 1][j]) counter++;
                        if (matrix[i - 1][j + 1]) counter++;
                        if (matrix[i + 1][j]) counter++;
                        if (matrix[i + 1][j + 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    } else if (j == matrix[i].length - 1) {
                        if (matrix[i][j - 1]) counter++;
                        if (matrix[i - 1][j]) counter++;
                        if (matrix[i - 1][j - 1]) counter++;
                        if (matrix[i + 1][j]) counter++;
                        if (matrix[i + 1][j - 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    } else {
                        if (matrix[i][j - 1]) counter++;
                        if (matrix[i][j + 1]) counter++;
                        if (matrix[i - 1][j]) counter++;
                        if (matrix[i - 1][j + 1]) counter++;
                        if (matrix[i - 1][j - 1]) counter++;
                        if (matrix[i + 1][j]) counter++;
                        if (matrix[i + 1][j + 1]) counter++;
                        if (matrix[i + 1][j - 1]) counter++;
                        solution[i][j] = counter;
                        counter = 0;
                    }
                }
            }
        }
        return solution;
    }
}
