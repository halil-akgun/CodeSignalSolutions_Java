package arcade.thecore;

/*
Given a rectangular matrix of integers, check if it is possible to rearrange its rows in
such a way that all its columns become strictly increasing sequences (read from top to bottom).

Example
For
matrix = [[2, 7, 1],
          [0, 2, 0],
          [1, 3, 1]]
the output should be
solution(matrix) = false;

For
matrix = [[6, 4],
          [2, 2],
          [4, 3]]
the output should be
solution(matrix) = true.
 */
public class CS119_RowsRearranging {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(solution(new int[][]{
                {293, -294, -108, 284, -127, 133, 93},
                {-247, -45, 33, -51, 12, -85, -295},
                {-272, 275, 285, 157, 175, 261, 163},
                {74, -89, -67, 106, -207, 47, 147},
                {-5, -56, -248, 166, -55, 166, 212},
                {-50, -63, 155, -217, 230, -298, -61},
                {-66, 181, 233, -175, 64, -69, -76}
//                {0},
//                {1},
//                {2},
//                {-1}
        }));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    static boolean solution(int[][] matrix) {
        if (!sortColumnsAndCheckIfUnique(matrix)) return false;
        return isSortedAllColumns(matrix);
    }

    private static boolean sortColumnsAndCheckIfUnique(int[][] matrix) {
        int[] temp;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = j + 1; k < matrix.length; k++) {
                    if (matrix[j][i] > matrix[k][i]) {
                        temp = matrix[j];
                        matrix[j] = matrix[k];
                        matrix[k] = temp;
                    } else if (matrix[j][i] == matrix[k][i]) return false;
                }
            }
        }
        return true;
    }

    private static boolean isSortedAllColumns(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[j][i] > matrix[j + 1][i]) return false;
            }
        }
        return true;
    }
}
