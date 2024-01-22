package arcade.thecore;

import java.util.Arrays;

/*
In ChessLand there is a small but proud chess bishop with a recurring dream. In the dream the bishop
finds itself on an n × m chessboard with mirrors along each edge, and it is not a bishop but a ray of light.
This ray of light moves only along diagonals (the bishop can't imagine any other types of moves even in its dreams),
it never stops, and once it reaches an edge or a corner of the chessboard it reflects from it and moves on.

Given the initial position and the direction of the ray, find its position after k steps where a step means
either moving from one cell to the neighboring one or reflecting from a corner of the board.

Example
For boardSize = [3, 7], initPosition = [1, 2],
initDirection = [-1, 1], and k = 13, the output should be
solution(boardSize, initPosition, initDirection, k) = [0, 1].

Here is the bishop's path:
[1, 2] -> [0, 3] -(reflection from the top edge)-> [0, 4] ->
[1, 5] -> [2, 6] -(reflection from the bottom right corner)-> [2, 6] ->
[1, 5] -> [0, 4] -(reflection from the top edge)-> [0, 3] ->
[1, 2] -> [2, 1] -(reflection from the bottom edge)-> [2, 0] -(reflection from the left edge)->
[1, 0] -> [0, 1]

https://codesignal.s3.amazonaws.com/uploads/1664318502/example.png?raw=true
 */
public class CS126_ChessBishopDream {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 7}, new int[]{1, 2}, new int[]{-1, 1}, 13)));
    }

    public static int[] solution(int[] boardSize, int[] initPosition, int[] initDirection, int k) { // https://github.com/wachino
        int verticalSteps = (initDirection[0] == 1 ? initPosition[0] : boardSize[0] - initPosition[0] - 1) + k;
        int horizontalSteps = (initDirection[1] == 1 ? initPosition[1] : boardSize[1] - initPosition[1] - 1) + k;

        int verticalBoards = (int) (Math.floor((double) verticalSteps / boardSize[0]) % 2);
        int horizontalBoards = (int) (Math.floor((double) horizontalSteps / boardSize[1]) % 2);

        verticalBoards = (verticalBoards + (initDirection[0] == -1 ? 1 : 0)) % 2;
        horizontalBoards = (horizontalBoards + (initDirection[1] == -1 ? 1 : 0)) % 2;

        int[] lastPosition = {
                verticalSteps % boardSize[0],
                horizontalSteps % boardSize[1]
        };

        if (verticalBoards == 1) {
            lastPosition[0] = boardSize[0] - lastPosition[0] - 1;
        }

        if (horizontalBoards == 1) {
            lastPosition[1] = boardSize[1] - lastPosition[1] - 1;
        }

        return lastPosition;
    }
}
