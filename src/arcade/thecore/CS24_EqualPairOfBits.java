package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
You're given two integers, n and m. Find position of the rightmost pair of equal bits in their binary
representations (it is guaranteed that such a pair exists), counting from right to left.

Return the value of 2position_of_the_found_pair (0-based).

Example
For n = 10 and m = 11, the output should be
solution(n, m) = 2.

1010 = 10102, 1110 = 10112, the position of the rightmost pair of equal bits is the bit
at position 1 (0-based) from the right in the binary representations.
So the answer is 21 = 2.
 */
public class CS24_EqualPairOfBits {
    public static void main(String[] args) {
        int n = 10;
        int m = 11;
        System.out.println(solution(n, m));  // Output: 2
    }

    static int solution(int n, int m) {
        return ~(n ^ m) & -~(n ^ m);
//        https://wind010.hashnode.dev/codesignal-24-equal-pair-of-bits
    }
}
