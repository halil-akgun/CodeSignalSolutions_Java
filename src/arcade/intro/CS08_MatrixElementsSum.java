package arcade.intro;

public class CS08_MatrixElementsSum {
    public static void main(String[] args) {
        /*
        After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has
        a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted!
        Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms
        below any of the free rooms.
        Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is
        to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values
        that don't appear below a 0).
        Example
        matrix = [[0, 1, 1, 2],
                  [0, 5, 0, 0],
                  [2, 0, 3, 3]]
        the output should be
        solution(matrix) = 9.
         */

        int matrix[][] = {{1, 1, 1, 0}, {0, 5, 0, 1}, {2, 1, 3, 10}};
        System.out.println("solution(matrix) = " + solution(matrix));

    }

    public static int solution(int[][] matrix) {
        boolean index0Control = false, index1Control = false, index2Control = false, index3Control = false;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0 & index0Control) continue;
                if (j == 1 & index1Control) continue;
                if (j == 2 & index2Control) continue;
                if (j == 3 & index3Control) continue;
                if (matrix[i][j] == 0) {
                    if (j == 0) index0Control = true;
                    if (j == 1) index1Control = true;
                    if (j == 2) index2Control = true;
                    if (j == 3) index3Control = true;
                    continue;
                } else {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

}
