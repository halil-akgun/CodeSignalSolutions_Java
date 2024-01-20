package arcade.thecore;

import java.util.Arrays;

/*
In the Land Of Chess, bishops don't really like each other. In fact, when two bishops happen
to stand on the same diagonal, they immediately rush towards the opposite ends of that same diagonal.

Given the initial positions (in chess notation) of two bishops, bishop1 and bishop2, calculate their
future positions. Keep in mind that bishops won't move unless they see each other along the same diagonal.

Example
For bishop1 = "d7" and bishop2 = "f5", the output should be
solution(bishop1, bishop2) = ["c8", "h3"].
https://codesignal.s3.amazonaws.com/uploads/1664394254/ex_1.jpg?raw=true

For bishop1 = "d8" and bishop2 = "b5", the output should be
solution(bishop1, bishop2) = ["b5", "d8"].
The bishops don't belong to the same diagonal, so they don't move.
https://codesignal.s3.amazonaws.com/uploads/1664394254/ex_2.jpg?raw=true
 */
public class CS124_BishopDiagonal {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("g3", "e1")));
    }

    static String[] solution(String bishop1, String bishop2) {
        int bishop1X = bishop1.charAt(0);
        int bishop1Y = bishop1.charAt(1);

        int bishop2X = bishop2.charAt(0);
        int bishop2Y = bishop2.charAt(1);

        if (Math.abs(bishop1X - bishop2X) == Math.abs(bishop1Y - bishop2Y)) {
            String a = calculateDiagonalEndpoint(bishop1X, bishop1Y, bishop2X, bishop2Y);
            String b = calculateDiagonalEndpoint(bishop2X, bishop2Y, bishop1X, bishop1Y);
            return Arrays.stream(new String[]{a, b}).sorted().toArray(String[]::new);
        }

        return Arrays.stream(new String[]{bishop2, bishop1}).sorted().toArray(String[]::new);
    }

    private static String calculateDiagonalEndpoint(int bishopX, int bishopY, int otherBishopX, int otherBishopY) {
        int newX = bishopX;
        int newY = bishopY;
        if (bishopX < otherBishopX) {
            // to left
            if (bishopY < otherBishopY) {
                // to bottom
                while (newX > 'a' && newY > '1') {
                    newX--;
                    newY--;
                }
            } else {
                // to top
                while (newX > 'a' && newY < '8') {
                    newX--;
                    newY++;
                }
            }
        } else {
            // to right
            if (bishopY < otherBishopY) {
                // to bottom
                while (newX < 'h' && newY > '1') {
                    newX++;
                    newY--;
                }
            } else {
                // to top
                while (newX < 'h' && newY < '8') {
                    newX++;
                    newY++;
                }
            }
        }
        return (char) (newX) + String.valueOf((char) (newY));
    }
}
