package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
Presented with the integer n, find the 0-based position of the second rightmost zero bit
in its binary representation (it is guaranteed that such a bit exists), counting from right to left.

Return the value of 2position_of_the_found_bit.

Example
For n = 37, the output should be
solution(n) = 8.

3710 = 1001012. The second rightmost zero bit is at position 3 (0-based) from the right
in the binary representation of n.
Thus, the answer is 23 = 8.
 */
public class CS21_SecondRightmostZeroBit {
    public static void main(String[] args) {
        System.out.println(solution(37));
    }

    static int solution(int n) {
        return 1 << Integer.numberOfTrailingZeros((n | (n + 1)) + 1);
    }
}

/*
37: 100101
     OR
38: 100110
      =
39: 100111

    100111 + 1 = 101000 (3 zeros at the end)

    1 << 3 = 1000 = 8
 */