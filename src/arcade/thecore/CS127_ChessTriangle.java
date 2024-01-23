package arcade.thecore;

/*
Consider a bishop, a knight and a rook on an n × m chessboard. They are said to form a
triangle if each piece attacks exactly one other piece and is attacked by exactly one piece.
Calculate the number of ways to choose positions of the pieces to form a triangle.

Note that the bishop attacks pieces sharing the common diagonal with it; the rook attacks in horizontal
and vertical directions; and, finally, the knight attacks squares which are two squares horizontally and
one square vertically, or two squares vertically and one square horizontally away from its position.
https://codesignal.s3.amazonaws.com/uploads/1664318501/moves.png?raw=true

Example
For n = 2 and m = 3, the output should be
solution(n, m) = 8.
https://codesignal.s3.amazonaws.com/uploads/1664318502/combinations.png?raw=true
 */
public class CS127_ChessTriangle {
    public static void main(String[] args) {
        System.out.println(solution(3, 3));
    }

    static int solution(int n, int m) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += countBishopMoves(i, j, n, m);
            }
        }
        return ans;
    }

    private static int countBishopMoves(int currentRow, int currentColumn, int n, int m) {
        int rookAttacks = 0;
        int bishopAttacks = 0;
        for (int targetRow = 0; targetRow < n; targetRow++) {
            for (int targetColumn = 0; targetColumn < m; targetColumn++) {
                if (targetRow + 2 == currentRow && targetColumn + 1 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow + 2 == currentRow && targetColumn - 1 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow + 1 == currentRow && targetColumn + 2 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow - 1 == currentRow && targetColumn + 2 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow + 1 == currentRow && targetColumn - 2 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow - 1 == currentRow && targetColumn - 2 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow - 2 == currentRow && targetColumn - 1 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
                if (targetRow - 2 == currentRow && targetColumn + 1 == currentColumn) {
                    rookAttacks += countRookAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                    bishopAttacks += countDiagonalAttacks(currentRow, currentColumn, targetRow, targetColumn, n, m);
                }
            }
        }
        return rookAttacks + bishopAttacks;
    }

    private static int countRookAttacks(int currentRow, int currentColumn, int targetRow, int targetColumn, int n, int m) {
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if ((row == currentRow || column == currentColumn) && Math.abs(row - targetRow) == Math.abs(column - targetColumn)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countDiagonalAttacks(int currentRow, int currentColumn, int targetRow, int targetColumn, int n, int m) {
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if ((row == targetRow || column == targetColumn) && Math.abs(row - currentRow) == Math.abs(column - currentColumn)) {
                    count++;
                }
            }
        }
        return count;
    }
}
