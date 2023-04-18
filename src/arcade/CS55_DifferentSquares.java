package arcade;

import java.util.ArrayList;
import java.util.List;

/*
Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

Example
matrix = [[1, 2, 1],
          [2, 2, 2],
          [2, 2, 2],
          [1, 2, 3],
          [2, 2, 1]]
the output should be
solution(matrix) = 6.

Here are all 6 different 2 × 2 squares:

  * 1 2
    2 2
  * 2 1
    2 2
  * 2 2
    2 2
  * 2 2
    1 2
  * 2 2
    2 3
  * 2 3
    2 1
 */
public class CS55_DifferentSquares {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 1}, {2, 2, 2}, {2, 2, 2}, {1, 2, 3}, {2, 2, 1}};
        System.out.println(solution(matrix));
    }

    static int solution(int[][] matrix) {
        List<String> list = new ArrayList<>();
        StringBuilder squares = new StringBuilder();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                squares.append(matrix[i][j]);
                squares.append(matrix[i][j + 1]);
                squares.append(matrix[i + 1][j]);
                squares.append(matrix[i + 1][j + 1]);
                if (!list.contains(squares.toString())) list.add(squares.toString());
                squares.delete(0, 4);
            }
        }
        return list.size();
    }
}
