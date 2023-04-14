package arcade;

/*
Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop can capture the pawn in one move.

The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Check out the example below to see how it can move:
https://codesignal.s3.amazonaws.com/uploads/1664394254/bishop.jpg?raw=true

Example
For bishop = "a1" and pawn = "c3", the output should be
solution(bishop, pawn) = true.
https://codesignal.s3.amazonaws.com/uploads/1664394255/ex1.jpg?raw=true

For bishop = "h1" and pawn = "h3", the output should be
solution(bishop, pawn) = false.
https://codesignal.s3.amazonaws.com/uploads/1664394255/ex2.jpg?raw=true
 */
public class CS42_BishopAndPawn {
    public static void main(String[] args) {
        String bishop = "a1";
        String pawn = "c3";
        System.out.println(solution(bishop, pawn));
    }

    static boolean solution(String bishop, String pawn) {
        char a = bishop.charAt(0);
        char b = bishop.charAt(1);
        while (a > 'a' && b > '1') {
            a--;
            b--;
            if (pawn.equals(String.valueOf(a) + b)) return true;
        }
        a = bishop.charAt(0);
        b = bishop.charAt(1);
        while (a > 'a' && b < '8') {
            a--;
            b++;
            if (pawn.equals(String.valueOf(a) + b)) return true;
        }
        a = bishop.charAt(0);
        b = bishop.charAt(1);
        while (a < 'h' && b < '8') {
            a++;
            b++;
            if (pawn.equals(String.valueOf(a) + b)) return true;
        }
        a = bishop.charAt(0);
        b = bishop.charAt(1);
        while (a < 'h' && b > '1') {
            a++;
            b--;
            if (pawn.equals(String.valueOf(a) + b)) return true;
        }
        return false;
    }
}
