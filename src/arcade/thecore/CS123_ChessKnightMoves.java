package arcade.thecore;

/*
Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

The knight can move to a square that is two squares horizontally and one square vertically, or two squares
vertically and one square horizontally away from it. The complete move therefore looks like the letter L.
Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.

Example
For cell = "a1", the output should be
solution(cell) = 2.
https://codesignal.s3.amazonaws.com/uploads/1664394253/ex_1.jpg?raw=true

For cell = "c2", the output should be
solution(cell) = 6.
https://codesignal.s3.amazonaws.com/uploads/1664394253/ex_2.jpg?raw=true
 */
public class CS123_ChessKnightMoves {
    public static void main(String[] args) {
        System.out.println(solution("a1"));
    }

    static int solution(String cell) {
        int x = cell.charAt(0);
        int y = cell.charAt(1);

        int count = 0;
        for (int i = 'a'; i <= 'h'; i++) {
            for (int j = '1'; j <= '8'; j++) {
                if (Math.abs(x - i) == 2 && Math.abs(y - j) == 1) count++;
                if (Math.abs(x - i) == 1 && Math.abs(y - j) == 2) count++;
            }
        }
        return count;
    }
}
