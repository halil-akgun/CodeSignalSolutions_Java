package arcade.thecore;

import java.util.Arrays;

/*
Mark got a rectangular array matrix for his birthday, and now he's thinking about
all the fun things he can do with it. He likes shifting a lot, so he decides to shift
all of its i-contours in a clockwise direction if i is even, and counterclockwise if i is odd.

Here is how Mark defines i-contours:
the 0-contour of a rectangular array as the union of left and right columns as well as top and bottom rows;
consider the initial matrix without the 0-contour: its 0-contour is the 1-contour of the initial matrix;
define 2-contour, 3-contour, etc. in the same manner by removing 0-contours from the obtained arrays.
Implement a function that does exactly what Mark wants to do to his matrix.

Example
For
matrix = [[ 1,  2,  3,  4],
           [ 5,  6,  7,  8],
           [ 9, 10, 11, 12],
           [13, 14, 15, 16],
           [17, 18, 19, 20]]
the output should be
solution(matrix) = [[ 5,  1,  2,  3],
                     [ 9,  7, 11,  4],
                     [13,  6, 15,  8],
                     [17, 10, 14, 12],
                     [18, 19, 20, 16]]
For matrix = [[238, 239, 240, 241, 242, 243, 244, 245]],
the output should be
solution(matrix) = [[245, 238, 239, 240, 241, 242, 243, 244]].

Note, that if a contour is represented by a 1 × n array, its center is considered to be below it.

For
matrix = [[238],
           [239],
           [240],
           [241],
           [242],
           [243],
           [244],
           [245]]
the output should be
solution(matrix) = [[245],
                     [238],
                     [239],
                     [240],
                     [241],
                     [242],
                     [243],
                     [244]]
If a contour is represented by an n × 1 array, its center is considered to be to the left of it.
 */
public class CS109_ContoursShifting {
    public static void main(String[] args) {
        Arrays.stream(solution(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        })).map(Arrays::toString).forEach(System.out::println);
    }

    static int[][] solution(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int idx = 0;

        while (rows > 1 && cols > 1) {
            if (idx % 2 == 0) rotateContourClockwiseDirection(matrix, idx++);
            else rotateContourCounterclockwiseDirection(matrix, idx++);
            rows -= 2;
            cols -= 2;
        }
        System.out.println(rows);
        System.out.println(cols);
        if (rows == 1) rotateSingleRowClockwise(matrix, idx);
        else if (cols == 1) rotateSingleColClockwise(matrix, idx);

        return matrix;
    }

    private static void rotateContourClockwiseDirection(int[][] matrix, int idx) {
        int right = matrix[0].length - 1 - idx;
        int bottom = matrix.length - 1 - idx;
        int temp = matrix[idx][idx];

        // to the bottom
        for (int i = idx; i < bottom; i++) {
            matrix[i][idx] = matrix[i + 1][idx];
        }
        // to the right
        for (int i = idx; i < right; i++) {
            matrix[bottom][i] = matrix[bottom][i + 1];
        }
        // to the top
        for (int i = bottom; i > idx; i--) {
            matrix[i][right] = matrix[i - 1][right];
        }
        // to the left
        for (int i = right; i > idx; i--) {
            matrix[idx][i] = matrix[idx][i - 1];
        }
        matrix[idx][idx + 1] = temp;
    }

    private static void rotateContourCounterclockwiseDirection(int[][] matrix, int idx) {
        int right = matrix[0].length - 1 - idx;
        int bottom = matrix.length - 1 - idx;
        int temp = matrix[idx][idx];

        // to the right
        for (int i = idx; i < right; i++) {
            matrix[idx][i] = matrix[idx][i + 1];
        }
        // to the bottom
        for (int i = idx; i < bottom; i++) {
            matrix[i][right] = matrix[i + 1][right];
        }
        // to the left
        for (int i = right; i > idx; i--) {
            matrix[bottom][i] = matrix[bottom][i - 1];
        }
        // to the top
        for (int i = bottom; i > idx; i--) {
            matrix[i][idx] = matrix[i - 1][idx];
        }
        matrix[idx + 1][idx] = temp;
    }

    private static void rotateSingleRowClockwise(int[][] matrix, int idx) {
        int temp = matrix[idx][matrix[idx].length - 1 - idx];

        for (int i = matrix[0].length - 1 - idx; i > 0; i--) {
            matrix[idx][i] = matrix[idx][i - 1];
        }
        matrix[idx][idx] = temp;
    }

    private static void rotateSingleColClockwise(int[][] matrix, int idx) {
        int temp = matrix[matrix.length - 1 - idx][idx];

        for (int i = matrix.length - 1 - idx; i > idx; i--) {
            matrix[i][idx] = matrix[i - 1][idx];
        }
        matrix[idx][idx] = temp;
    }
}
