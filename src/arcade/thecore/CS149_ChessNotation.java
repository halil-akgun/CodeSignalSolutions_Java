package arcade.thecore;

/*
John has always had trouble remembering chess game positions. To help himself with remembering,
he decided to store game positions in strings. He came up with the following position notation:

- The notation is built for the current game position row by row from top to bottom, with '/' separating each row notation;
- Within each row, the contents of each square are described from the leftmost column to the rightmost;
- Each piece is identified by a single letter taken from the standard English names
  ('P' = pawn, 'N' = knight, 'B' = bishop, 'R' = rook, 'Q' = queen, 'K' = king);
- White pieces are designated using upper-case letters ("PNBRQK") while black pieces use lowercase ("pnbrqk");
- Empty squares are noted using digits 1 through 8 (the number of empty squares from the last piece);
- Empty lines are noted as "8".

For example, for the initial position (shown in the picture below) the notation will look like this:
"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"

https://codesignal.s3.amazonaws.com/uploads/1664394256/initial.jpg?raw=true

After the white pawn moves from e2 to e4, the notation will be as follows:

"rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR"

John has written down some positions using his notation, and now he wants to rotate the board 90 degrees clockwise and see what notation for the new board would look like. Help him with this task.

Example
For notation = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR", the output should be
solution(notation) = "RP4pr/NP4pn/BP4pb/QP4pq/K2P2pk/BP4pb/NP4pn/RP4pr".

The notation corresponds to the initial position with one move made (white pawn from e2 to e4).
After rotating the board, it will look like this:

https://codesignal.s3.amazonaws.com/uploads/1664394256/example.jpg?raw=true

So, the notation of the new position is "RP4pr/NP4pn/BP4pb/QP4pq/K2P2pk/BP4pb/NP4pn/RP4pr".
 */
public class CS149_ChessNotation {
    public static void main(String[] args) {
        System.out.println(solution("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR"));
    }

    static String solution(String notation) {
        String[][] notationArr = new String[8][8];
        String[] notationStr = notation.split("/");

        int idx;
        for (int i = 0; i < 8; i++) {
            idx = 0;
            for (int j = 0; j < notationStr[i].length(); j++) {
                if (Character.isDigit(notationStr[i].charAt(j))) {
                    idx += Character.getNumericValue(notationStr[i].charAt(j));
                    continue;
                }
                notationArr[i][idx++] = notationStr[i].charAt(j) + "";
            }
        }

        return rotate(notationArr);
    }

    private static String rotate(String[][] notationArr) {
        StringBuilder result = new StringBuilder();

        int emptyCount = 0;
        for (int i = 0; i < 8; i++) {
            result.append("/");
            for (int j = notationArr[i].length - 1; j >= 0; j--) {
                if (notationArr[j][i] == null) {
                    emptyCount++;
                    continue;
                }
                if (emptyCount > 0) {
                    result.append(emptyCount);
                    emptyCount = 0;
                }
                result.append(notationArr[j][i]);
            }
            if (emptyCount > 0) {
                result.append(emptyCount);
                emptyCount = 0;
            }
        }

        return result.substring(1);
    }
}
