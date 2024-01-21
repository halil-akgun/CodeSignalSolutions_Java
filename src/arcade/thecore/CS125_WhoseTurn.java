package arcade.thecore;

/*
Imagine a standard chess board with only two white and two black knights placed in their
standard starting positions: the white knights on b1 and g1; the black knights on b8 and g8.
https://codesignal.s3.amazonaws.com/uploads/1664318503/initial_pos.png?raw=true
There are two players: one plays for white, the other for black. During each move, the player
picks one of his knights and moves it to an unoccupied square according to standard chess rules.
Thus, a knight on d5 can move to any of the following squares: b6, c7, e7, f6, f4, e3, c3, and b4,
as long as it is not occupied by either a friendly or an enemy knight.
https://codesignal.s3.amazonaws.com/uploads/1664394254/knight.jpg?raw=true
The players take turns in making moves, starting with the white player. Given the configuration
p of the knights after an unspecified number of moves, determine whose turn it is.

Example
For p = "b1;g1;b8;g8", the output should be
solution(p) = true.
The configuration corresponds to the initial state of the game. Thus, it's white's turn.
 */
public class CS125_WhoseTurn {
    public static void main(String[] args) {
        System.out.println(solution("f8;h1;f3;c2"));
    }

    static boolean solution(String p) { // https://github.com/wachino
        int[][] positions = new int[4][2];
        String[] positionStrings = p.split(";");

        for (int i = 0; i < 4; i++) {
            positions[i] = getPosition(positionStrings[i]);
        }

        return (positions[0][0] + positions[0][1] + positions[1][0] + positions[1][1]) % 2 ==
                (positions[2][0] + positions[2][1] + positions[3][0] + positions[3][1]) % 2;

    }

    public static int[] getPosition(String k) {
        char[] pos = k.toCharArray();
        pos[0] = (char) (1 + pos[0] - 'a');
        pos[1] = (char) Character.getNumericValue(pos[1]);
        return new int[]{pos[0], pos[1]};
    }
}
