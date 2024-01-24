package arcade.thecore;

import java.util.Arrays;

/*
An amazon (also known as a queen + knight compound) is an imaginary chess piece that can move like a queen or
a knight (or, equivalently, like a rook, bishop, or knight). The diagram below shows all squares which the
amazon can attack from e4 (circles represent knight-like moves while crosses correspond to queen-like moves).

https://codesignal.s3.amazonaws.com/uploads/1664318503/amazon.png?raw=true

Recently, you've come across a diagram with only three pieces left on the board: a white amazon, the white king,
and the black king. It's black's move. You don't have time to determine whether the game is over or not,
but you'd like to figure it out in your head. Unfortunately, the diagram is smudged and you can't see
the position of the black king, so you'll need to consider all possible positions.

Given the positions of the white pieces on a standard chessboard (using algebraic notation),
your task is to determine the number of possible black king's positions such that:

it's checkmate (i.e. black's king is under the amazon's attack and it cannot make a valid move);
it's check (i.e. black's king is under the amazon's attack but it can reach a safe square in one move);
it's stalemate (i.e. black's king is on a safe square but it cannot make a valid move);
black's king is on a safe square and it can make a valid move.
Note that two kings cannot be placed on two adjacent squares (including two diagonally adjacent ones).

Example
For king = "d3" and amazon = "e4", the output should be
solution(king, amazon) = [5, 21, 0, 29].
https://codesignal.s3.amazonaws.com/uploads/1664318503/example1.png?raw=true
Red crosses correspond to the checkmate positions, orange pluses refer to
check positions, and green circles denote safe squares.

For king = "a1" and amazon = "g5", the output should be
solution(king, amazon) = [0, 29, 1, 29].
https://codesignal.s3.amazonaws.com/uploads/1664318503/example2.png?raw=true
The stalemate position is marked by a blue square.
 */
public class CS128_AmazonCheckmate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("d3", "e4")));
    }

    static int[] solution(String king, String amazon) { // https://github.com/wachino
        int kx = king.charAt(0) - 'a';
        int ky = Integer.parseInt(king.substring(1)) - 1;
        int ax = amazon.charAt(0) - 'a';
        int ay = Integer.parseInt(amazon.substring(1)) - 1;

        boolean[][] unsafe = new boolean[8][8];
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    line(unsafe, ax, ay, kx, ky, j, i);
                    if (ky + i >= 0 && ky + i < 8 && kx + j >= 0 && kx + j < 8) {
                        unsafe[ky + i][kx + j] = true;
                    }
                }
            }
        }
        leap(unsafe, ax, ay, 1, 2);
        leap(unsafe, ax, ay, 2, 1);

        int[] result = new int[4];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(j - kx) > 1 || Math.abs(i - ky) > 1) && (i != ay || j != ax)) {
                    boolean anySafe = false;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (k != 0 || l != 0) {
                                if (i + k >= 0 && i + k < 8 && j + l >= 0 && j + l < 8) {
                                    anySafe |= !unsafe[i + k][j + l];
                                }
                            }
                        }
                    }
                    result[(unsafe[i][j] ? 0 : 2) + (anySafe ? 1 : 0)]++;
                }
            }
        }
        return result;
    }

    private static void line(boolean[][] unsafe, int ax, int ay, int kx, int ky, int x, int y) {
        for (int i = ay + y, j = ax + x; i < 8 && i >= 0 && j < 8 && j >= 0; i += y, j += x) {
            if (j == kx && i == ky) {
                break;
            }
            unsafe[i][j] = true;
        }
    }

    private static void leap(boolean[][] unsafe, int ax, int ay, int x, int y) {
        for (int i = ay - y; i <= ay + y; i += y << 1) {
            if (i >= 0 && i < 8) {
                for (int j = ax - x; j <= ax + x; j += x << 1) {
                    if (j >= 0 && j < 8) {
                        unsafe[i][j] = true;
                    }
                }
            }
        }
    }
}
