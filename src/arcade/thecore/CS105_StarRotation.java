package arcade.thecore;

import java.util.Arrays;

/*
Consider a (2k+1) × (2k+1) square subarray of an integer integers matrix. Let's call the union of the square's two
longest diagonals, middle column and middle row a star. Given the coordinates of the star's center in the matrix and
its width, rotate it 45 · t degrees clockwise preserving position of all matrix elements that do not belong to the star.

Example
For
matrix = [[1, 0, 0, 2, 0, 0, 3],
          [0, 1, 0, 2, 0, 3, 0],
          [0, 0, 1, 2, 3, 0, 0],
          [8, 8, 8, 9, 4, 4, 4],
          [0, 0, 7, 6, 5, 0, 0],
          [0, 7, 0, 6, 0, 5, 0],
          [7, 0, 0, 6, 0, 0, 5]]
width = 7, center = [3, 3], and t = 1, the output should be
solution(matrix, width, center, t) = [[8, 0, 0, 1, 0, 0, 2],
                                      [0, 8, 0, 1, 0, 2, 0],
                                      [0, 0, 8, 1, 2, 0, 0],
                                      [7, 7, 7, 9, 3, 3, 3],
                                      [0, 0, 6, 5, 4, 0, 0],
                                      [0, 6, 0, 5, 0, 4, 0],
                                      [6, 0, 0, 5, 0, 0, 4]]
For
matrix = [[1, 0, 0, 2, 0, 0, 3],
          [0, 1, 0, 2, 0, 3, 0],
          [0, 0, 1, 2, 3, 0, 0],
          [8, 8, 8, 9, 4, 4, 4],
          [0, 0, 7, 6, 5, 0, 0]]
width = 3, center = [1, 5], and t = 81, the output should be
solution(matrix, width, center, t) = [[1, 0, 0, 2, 0, 0, 0],
                                      [0, 1, 0, 2, 3, 3, 3],
                                      [0, 0, 1, 2, 0, 0, 0],
                                      [8, 8, 8, 9, 4, 4, 4],
                                      [0, 0, 7, 6, 5, 0, 0]]
 */
public class CS105_StarRotation {
    public static void main(String[] args) {
        Arrays.stream(solution(new int[][]{
                {1, 0, 0, 2, 0, 0, 3},
                {0, 1, 0, 2, 0, 3, 0},
                {0, 0, 1, 2, 3, 0, 0},
                {8, 8, 8, 9, 4, 4, 4},
                {0, 0, 7, 6, 5, 0, 0},
                {0, 7, 0, 6, 0, 5, 0},
                {7, 0, 0, 6, 0, 0, 5}
        }, 7, new int[]{3, 3}, 1)).map(Arrays::toString).forEach(System.out::println);
    }

    static int[][] solution(int[][] matrix, int width, int[] center, int t) {
        int[][][] positions = new int[width / 2][][];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = getCurrentPositions(matrix, center, i);
            positions[i] = updatePositions(positions[i], t);
            mergePositions(matrix, positions[i], center);
        }
        return matrix;
    }

    private static void mergePositions(int[][] matrix, int[][] positions, int[] center) {
        for (int j = center[0] - positions.length / 2; j <= center[0] + positions.length / 2; j++) {
            if (center[1] + positions.length / 2 + 1 - (center[1] - positions.length / 2) >= 0)
                System.arraycopy(positions[j - center[0] + positions.length / 2],
                        -positions.length / 2 + positions.length / 2, matrix[j],
                        center[1] - positions.length / 2,
                        center[1] + positions.length / 2 + 1 - (center[1] - positions.length / 2));
        }
    }

    private static int[][] getCurrentPositions(int[][] matrix, int[] center, int i) {
        int[][] positions = new int[3 + i * 2][];
        int idx = 0;
        for (int j = center[0] - (i + 1); j <= center[0] + i + 1; j++) {
            int[] temp = new int[positions.length];
            int idx2 = 0;
            for (int k = center[1] - (i + 1); k <= center[1] + (i + 1); k++) {
                temp[idx2++] = matrix[j][k];
            }
            positions[idx++] = temp;
        }
        return positions;
    }

    private static int[][] updatePositions(int[][] part, int t) {
        int move = t % 8;
        int[][] basePositions = new int[part.length][part.length];
        basePositions[0][0] = 1;
        basePositions[0][part.length / 2] = 2;
        basePositions[0][part.length - 1] = 3;
        basePositions[part.length / 2][0] = 8;
        basePositions[part.length / 2][part.length - 1] = 4;
        basePositions[part.length - 1][0] = 7;
        basePositions[part.length - 1][part.length / 2] = 6;
        basePositions[part.length - 1][part.length - 1] = 5;

        int[][] updatedPositions = new int[part.length][part[0].length];
        for (int i = 0; i < part.length; i++) {
            System.arraycopy(part[i], 0, updatedPositions[i], 0, part[i].length);
        }

        for (int i = 0; i < part.length; i++) {
            for (int j = 0; j < part.length; j++) {
                if (basePositions[i][j] != 0) {
                    updatedPositions[i][j] = getValue(part, basePositions, basePositions[i][j], move);
                }
            }
        }
        return updatedPositions;
    }

    private static int getValue(int[][] part, int[][] basePositions, int i, int move) {
        int newPosition = (i - move) % 8;
        if (newPosition <= 0) {
            newPosition += 8;
        }
        for (int j = 0; j < basePositions.length; j++) {
            for (int k = 0; k < basePositions.length; k++) {
                if (basePositions[j][k] == newPosition) {
                    return part[j][k];
                }
            }
        }
        return 0;
    }
}
