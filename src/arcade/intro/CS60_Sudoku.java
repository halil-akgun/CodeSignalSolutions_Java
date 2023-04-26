package arcade.intro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column, each row,
and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.
This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

Example
For
grid = [[1, 3, 2, 5, 4, 6, 9, 8, 7],
        [4, 6, 5, 8, 7, 9, 3, 2, 1],
        [7, 9, 8, 2, 1, 3, 6, 5, 4],
        [9, 2, 1, 4, 3, 5, 8, 7, 6],
        [3, 5, 4, 7, 6, 8, 2, 1, 9],
        [6, 8, 7, 1, 9, 2, 5, 4, 3],
        [5, 7, 6, 9, 8, 1, 4, 3, 2],
        [2, 4, 3, 6, 5, 7, 1, 9, 8],
        [8, 1, 9, 3, 2, 4, 7, 6, 5]]
the output should be
solution(grid) = true;

For
grid = [[8, 3, 6, 5, 3, 6, 7, 2, 9],
        [4, 2, 5, 8, 7, 9, 3, 8, 1],
        [7, 9, 1, 2, 1, 4, 6, 5, 4],
        [9, 2, 1, 4, 3, 5, 8, 7, 6],
        [3, 5, 4, 7, 6, 8, 2, 1, 9],
        [6, 8, 7, 1, 9, 2, 5, 4, 3],
        [5, 7, 6, 9, 8, 1, 4, 3, 2],
        [2, 4, 3, 6, 5, 7, 1, 9, 8],
        [8, 1, 9, 3, 2, 4, 7, 6, 5]]
the output should be
solution(grid) = false.

The output should be false: each of the nine 3 × 3 sub-grids should contain all of the digits from 1 to 9.
These examples are represented in this image. https://codesignal.s3.amazonaws.com/uploads/1667239894092/example.png?raw=true
 */
public class CS60_Sudoku {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 2, 5, 4, 6, 9, 8, 7},
                {4, 6, 5, 8, 7, 9, 3, 2, 1},
                {7, 9, 8, 2, 1, 3, 6, 5, 4},
                {9, 2, 1, 4, 3, 5, 8, 7, 6},
                {3, 5, 4, 7, 6, 8, 2, 1, 9},
                {6, 8, 7, 1, 9, 2, 5, 4, 3},
                {5, 7, 6, 9, 8, 1, 4, 3, 2},
                {2, 4, 3, 6, 5, 7, 1, 9, 8},
                {8, 1, 9, 3, 2, 4, 7, 6, 5}};
        System.out.println(solution(grid));
    }

    static boolean solution(int[][] grid) {
        Set<Integer> box = new HashSet<>();
        for (int i = 0; i < grid.length; i += 3) {
            for (int j = 1; j <= grid[i].length; j++) {
                if (grid[i][j - 1] >= 0 && grid[i][j - 1] <= 9) box.add(grid[i][j - 1]);
                if (grid[i + 1][j - 1] >= 0 && grid[i + 1][j - 1] <= 9) box.add(grid[i + 1][j - 1]);
                if (grid[i + 2][j - 1] >= 0 && grid[i + 2][j - 1] <= 9) box.add(grid[i + 2][j - 1]);
                if (j % 3 == 0) {
                    if (box.size() != 9) return false;
                    box.clear();
                }
            }
        }
        return columnControl(grid) && rowControl(grid); // rowControl must be last because of Arrays.sort
    }

    static boolean rowControl(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
            for (int i = 1; i <= 9; i++) {
                if (row[i - 1] != i) return false;
            }
        }
        return true;
    }

    static boolean columnControl(int[][] grid) {
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int[] w : grid) {
                if (w[i] >= 0 && w[i] <= 9) column.add(w[i]);
            }
            if (column.size() != 9) return false;
            column.clear();
        }
        return true;
    }
}
