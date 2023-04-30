package arcade.thecore;

/*
Given an integer n, return the largest number that contains exactly n digits.

Example
For n = 2, the output should be
solution(n) = 99.
 */
public class CS02_LargestNumber {
    public static void main(String[] args) {
        System.out.println(solution(7));
    }

    static int solution(int n) {
        return Integer.parseInt("9".repeat(n));
    }
}
