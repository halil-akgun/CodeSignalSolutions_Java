package arcade.thecore;

/*
Define an integer's roundness as the number of trailing zeroes in it.

Given an integer n, check if it's possible to increase n's roundness by swapping some pair of its digits.

Example
For n = 902200100, the output should be
solution(n) = true.
One of the possible ways to increase roundness of n is to swap digit 1 with digit 0 preceding it:
roundness of 902201000 is 3, and roundness of n is 2.

For instance, one may swap the leftmost 0 with 1.
For n = 11000, the output should be
solution(n) = false.
Roundness of n is 3, and there is no way to increase it.
 */
public class CS031_IncreaseNumberRoundness {
    public static void main(String[] args) {
        System.out.println(solution(25111000));
    }

    static boolean solution(int n) {
        String temp = String.valueOf(n);
        for (int i = temp.length() - 1; i >= 0; i--) {
            if (i > 0 && temp.charAt(i) != '0' && temp.charAt(i - 1) == '0') return true;
        }
        return false; // Also, my solution was accepted.

//        jargente's solution:
//        return (n + "").matches(".*0[^0]+0*"); // It doesn't have to be consecutive. swapping any 2 digits is enough
    }
}
