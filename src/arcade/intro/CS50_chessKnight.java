package arcade.intro;

/*
Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically
and one square horizontally away from it. The complete move therefore looks like the letter L.
Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.
https://codesignal.s3.amazonaws.com/uploads/1664394255/knight.jpg?raw=true

Example
For cell = "a1", the output should be
solution(cell) = 2.

For cell = "c2", the output should be
solution(cell) = 6.
 */
public class CS50_chessKnight {
    public static void main(String[] args) {
        String cell = "a1";
        System.out.println(solution(cell));
    }

    static int solution(String cell) {
        int[] horseMoveRuleLetter = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] horseMoveRuleDigit = {1, -1, 1, -1, -2, -2, 2, 2};
        int result = 0;
        for (int i = 0; i < horseMoveRuleDigit.length; i++) {
            char letter = (char) (cell.charAt(0) + horseMoveRuleLetter[i]);
            char digit = (char) (cell.charAt(1) + horseMoveRuleDigit[i]);
            if (letter >= 'a' && letter <= 'h' && digit >= '1' && digit <= '8') result++;
        }
        return result;
    }
}
