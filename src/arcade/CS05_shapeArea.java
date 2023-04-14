package arcade;

/*
Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.

A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking
the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side.
You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
https://codesignal.s3.amazonaws.com/uploads/1664318501/area.png?raw=true

Example
For n = 2, the output should be
solution(n) = 5;
For n = 3, the output should be
solution(n) = 13.
 */
public class CS05_shapeArea {
    public static void main(String[] args) {
        System.out.println(solution(2));
    }

    static int solution(int n) {
        int sum = 1;
        int temp = 4;
        for (int i = 1; i < n; i++) {
            sum += temp;
            temp += 4;
        }
        return sum;
    }
}
