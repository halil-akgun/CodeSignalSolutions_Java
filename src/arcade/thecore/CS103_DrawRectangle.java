package arcade.thecore;

import java.util.Arrays;

/*
You are implementing a command-line version of the Paint app. Since the command line doesn't support colors,
you are using different characters to represent pixels. Your current goal is to support rectangle x1 y1 x2 y2
operation, which draws a rectangle that has an upper left corner at (x1, y1) and a lower right corner at (x2, y2).
Here the x-axis points from left to right, and the y-axis points from top to bottom.

Given the initial canvas state and the array that represents the coordinates of the two corners, return the canvas
state after the operation is applied. For the details about how rectangles are painted, see the example.

Example
For
canvas = [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
          ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
          ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
          ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
          ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
and rectangle = [1, 1, 4, 3], the output should be
solution(canvas, rectangle) = [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
             					['a', '*', '-', '-', '*', 'a', 'a', 'a'],
             					['a', '|', 'a', 'a', '|', 'a', 'a', 'a'],
             					['b', '*', '-', '-', '*', 'b', 'b', 'b'],
             					['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
Note that rectangle sides are depicted as -s and |s, asterisks (*) stand for its corners
and all of the other "pixels" remain the same.
 */
public class CS103_DrawRectangle {
    public static void main(String[] args) {
        Arrays.stream(solution(new char[][]{
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
                {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}
        }, new int[]{1, 1, 4, 3})).map(Arrays::toString).forEach(System.out::println);
    }

    static char[][] solution(char[][] canvas, int[] rectangle) {
        for (int i = rectangle[1]; i <= rectangle[3]; i++) {
            for (int j = rectangle[0]; j <= rectangle[2]; j++) {
                if ((i == rectangle[1] || i == rectangle[3]) && (j == rectangle[0] || j == rectangle[2])) {
                    canvas[i][j] = '*';
                } else if (i == rectangle[1] || i == rectangle[3]) {
                    canvas[i][j] = '-';
                } else if (j == rectangle[0] || j == rectangle[2]) {
                    canvas[i][j] = '|';
                }
            }
        }
        return canvas;
    }
}
