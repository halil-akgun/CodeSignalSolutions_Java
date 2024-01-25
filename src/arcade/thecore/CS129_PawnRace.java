package arcade.thecore;

/*
Pawn race is a game for two people, played on an ordinary 8 × 8 chessboard. The first player has
a white pawn, the second one - a black pawn. Initially the pawns are placed somewhere on the board
so that the 1st and the 8th rows are not occupied. Players take turns to make a move.

White pawn moves upwards, black one moves downwards. The following moves are allowed:

- one-cell move on the same vertical in the allowed direction;
- two-cell move on the same vertical in the allowed direction, if the pawn is standing on the 2nd (for the white pawn)
  or the 7th (for the black pawn) row. Note that even with the two-cell move a pawn can't jump over the opponent's pawn;
- capture move one cell forward in the allowed direction and one cell to the left or to the right.

https://codesignal.s3.amazonaws.com/uploads/1664318502/move_types.png?raw=true

The purpose of the game is to reach the the 1st row (for the black pawn) or
the 8th row (for the white one), or to capture the opponent's pawn.

Given the initial positions and whose turn it is, determine who will win or declare it a draw
(i.e. it is impossible for any player to win). Assume that the players play optimally.

Example
For white = "e2", black = "e7", and toMove = 'w', the output should be
solution(white, black, toMove) = "draw";
For white = "e3", black = "d7", and toMove = 'b', the output should be
solution(white, black, toMove) = "black";
For white = "a7", black = "h2", and toMove = 'w', the output should be
solution(white, black, toMove) = "white".
 */
public class CS129_PawnRace {
    public static void main(String[] args) {
        System.out.println(solution("h4", "g7", 'w'));
    }

    static String solution(String white, String black, char toMove) {
        return isDraw(white, black) ? "draw" : getWinner(white, black, toMove);
    }

    private static boolean isDraw(String white, String black) {
        return white.charAt(0) == black.charAt(0) && white.charAt(1) < black.charAt(1);
    }

    private static String getWinner(String white, String black, char toMove) {
        int whiteY = Integer.parseInt(white.substring(1));
        int blackY = Integer.parseInt(black.substring(1));

        if (Math.abs(white.charAt(0) - black.charAt(0)) == 1 && whiteY < blackY) {
            while (whiteY + 1 != blackY) {
                if (toMove == 'w') {
                    if (whiteY == 2) {
                        whiteY = 4;
                        if (blackY == 4) return "black";
                        else if (blackY == 5) return "white";
                    } else whiteY++;
                    toMove = 'b';
                } else {
                    if (blackY == 7) {
                        blackY = 5;
                        if (whiteY == 5) return "white";
                        else if (whiteY == 4) return "black";
                    } else blackY--;
                    toMove = 'w';
                }
            }
            return toMove == 'w' ? "white" : "black";
        }

        while (!(whiteY == 8 || blackY == 1)) {
            if (toMove == 'w') {
                if (whiteY == 2) whiteY = 4;
                else whiteY++;
                toMove = 'b';
            } else {
                if (blackY == 7) blackY = 5;
                else blackY--;
                toMove = 'w';
            }
        }
        return whiteY == 8 ? "white" : "black";
    }
}
