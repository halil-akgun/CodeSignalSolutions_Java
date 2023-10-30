package arcade.thecore;

/*
A rectangle with sides equal to even integers a and b is drawn on the Cartesian plane.
Its center (the intersection point of its diagonals) coincides with the point (0, 0), but the sides
of the rectangle are not parallel to the axes; instead, they are forming 45 degree angles with the axes.

How many points with integer coordinates are located inside the given rectangle (including on its sides)?

Example
For a = 6 and b = 4, the output should be
solution(a, b) = 23.

The following picture illustrates the example, and the 23 points are marked green.
https://codesignal.s3.amazonaws.com/uploads/1664318506/rectangle.png?raw=true
 */
public class CS049_RectangleRotation {
    public static void main(String[] args) {
        System.out.println(solution(30, 2));
    }

    static int solution(int a, int b) { // https://wachino.github.io/codefights/codefights-arcade/codefights-arcade-thecore/49_rectangleRotation/README.html
        double ld = (a / Math.sqrt(2)) / 2;
        double sd = (b / Math.sqrt(2)) / 2;
        int[] rect1 = {(int) (2 * Math.floor(ld) + 1), (int) (2 * Math.floor(sd) + 1)};
        int[] rect2 = {(int) (2 * Math.floor(ld) + (ld % 1 < 0.5 ? 0 : 2)), (int) (2 * Math.floor(sd) + (sd % 1 < 0.5 ? 0 : 2))};
        return rect1[0] * rect1[1] + rect2[0] * rect2[1];
    }
}
