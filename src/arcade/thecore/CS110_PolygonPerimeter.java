package arcade.thecore;

/*
You have a rectangular white board with some black cells. The black cells create
a connected black figure, i.e. it is possible to get from any black cell to
any other one through connected adjacent (sharing a common side) black cells.

Find the perimeter of the black figure assuming that a single cell has unit length.

It's guaranteed that there is at least one black cell on the table.

Example
For
matrix = [[false, true,  true ],
          [true,  true,  false],
          [true,  false, false]]
the output should be
solution(matrix) = 12.
https://codesignal.s3.amazonaws.com/uploads/1664318505/example1.png?raw=true

For
matrix = [[true, true,  true],
          [true, false, true],
          [true, true,  true]]
the output should be
solution(matrix) = 16.
https://codesignal.s3.amazonaws.com/uploads/1664318506/example2.png?raw=true
 */
public class CS110_PolygonPerimeter {
    public static void main(String[] args) {
        System.out.println(solution(new boolean[][]{
                {false, true, true},
                {true, true, false},
                {true, false, false}
        }));
    }

    static int solution(boolean[][] matrix) {
        boolean[][] temp = new boolean[matrix.length + 2][matrix[0].length + 2];
        int result = 0;
        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[0].length - 1 - 1 >= 0) System.arraycopy(matrix[i - 1], 0, temp[i], 1, temp[0].length - 1 - 1);
        }
        for (int i = 1; i < temp.length - 1; i++) {
            for (int j = 1; j < temp[0].length - 1; j++) {
                if (temp[i][j]) {
                    if (!temp[i - 1][j]) result += 1;
                    if (!temp[i + 1][j]) result += 1;
                    if (!temp[i][j - 1]) result += 1;
                    if (!temp[i][j + 1]) result += 1;
                }
            }
        }
        return result;
    }
}
