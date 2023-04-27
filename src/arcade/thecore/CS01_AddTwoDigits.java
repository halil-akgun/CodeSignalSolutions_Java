package arcade.thecore;
/*
You are given a two-digit integer n. Return the sum of its digits.

Example
For n = 29, the output should be
solution(n) = 11.
 */
public class CS01_AddTwoDigits {
    public static void main(String[] args) {
        System.out.println(solution(29));
    }
    static int solution(int n) {
        return (n % 10) + (n/10);
    }
}
