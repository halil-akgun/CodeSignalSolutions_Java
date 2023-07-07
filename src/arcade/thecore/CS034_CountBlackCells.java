package arcade.thecore;

/*
Imagine a white rectangular grid of n rows and m columns divided into two parts by a diagonal line running from
the upper left to the lower right corner. Now let's paint the grid in two colors according to the following rules:

    - A cell is painted black if it has at least one point in common with the diagonal;
    - Otherwise, a cell is painted white.

Count the number of cells painted black.

Example
For n = 3 and m = 4, the output should be
solution(n, m) = 6.
There are 6 cells that have at least one common point with the diagonal and therefore are painted black.
https://codesignal.s3.amazonaws.com/uploads/1664394252/example1.jpg?raw=true

For n = 3 and m = 3, the output should be
solution(n, m) = 7.
7 cells have at least one common point with the diagonal and are painted black.
https://codesignal.s3.amazonaws.com/uploads/1664394252/example2.jpg?raw=true
 */
public class CS034_CountBlackCells {
    public static void main(String[] args) {
        System.out.println(solution(2, 5));
    }

    static int solution(int n, int m) {
//        if (n == m) return n + (n - 1) * 2;
//        int small = Math.min(n, m);
//        int big = Math.max(n, m);
//        if (big % small == 0) return big + (small - 1) * 2;
//        int smallestDivisor = calculateSmallestDivisor(small);
////        if (big % smallestDivisor == 0) return ((small / smallestDivisor) - 1) * 2 + big + small - 1;
//        return big + small - 1 + ((small / smallestDivisor) - 1);
////        return ((small - 1 + big) / small) * small;


//        i couldn't solve
//        github.com/socathie's solution:
        return n + m + gcd(n, m) - 2;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

//    private static int calculateSmallestDivisor(int small) {
//        for (int i = 2; i <= small; i++) {
//            if (small % i == 0) return i;
//        }
//        return small;
//    }
}
