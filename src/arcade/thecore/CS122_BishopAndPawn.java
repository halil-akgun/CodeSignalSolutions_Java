package arcade.thecore;

/*
Given the positions of a white bishop and a black pawn on the standard chess board,
determine whether the bishop can capture the pawn in one move.

The bishop has no restrictions in distance for each move, but is limited to
diagonal movement. Check out the example below to see how it can move:
https://codesignal.s3.amazonaws.com/uploads/1664394254/bishop.jpg?raw=true

Example
For bishop = "a1" and pawn = "c3", the output should be
solution(bishop, pawn) = true.
https://codesignal.s3.amazonaws.com/uploads/1664394255/ex1.jpg?raw=true

For bishop = "h1" and pawn = "h3", the output should be
solution(bishop, pawn) = false.
https://codesignal.s3.amazonaws.com/uploads/1664394255/ex2.jpg?raw=true
 */
public class CS122_BishopAndPawn {
    public static void main(String[] args) {
        System.out.println(solution("a1", "c3"));
    }

    static boolean solution(String bishop, String pawn) {
        for (int i = bishop.charAt(0) + 1; i <= 'h'; i++) {
            if (pawn.charAt(0) == i && pawn.charAt(1) == bishop.charAt(1) + (i - bishop.charAt(0))) return true;
            if (pawn.charAt(0) == i && pawn.charAt(1) == bishop.charAt(1) - (i - bishop.charAt(0))) return true;
        }
        for (int i = bishop.charAt(0) - 1; i >= 'a'; i--) {
            if (pawn.charAt(0) == i && pawn.charAt(1) == bishop.charAt(1) + (bishop.charAt(0) - i)) return true;
            if (pawn.charAt(0) == i && pawn.charAt(1) == bishop.charAt(1) - (bishop.charAt(0) - i)) return true;
        }
        return false;

        // ChatGPT
//        int bishopX = bishop.charAt(0) - 'a';
//        int bishopY = bishop.charAt(1) - '1';
//
//        int pawnX = pawn.charAt(0) - 'a';
//        int pawnY = pawn.charAt(1) - '1';
//
//        return Math.abs(bishopX - pawnX) == Math.abs(bishopY - pawnY);
    }
}
