package arcade.thecore;

/*
You're given an arbitrary 32-bit integer n. Take its binary representation,
split bits into it in pairs (bit number 0 and 1, bit number 2 and 3, etc.) and swap bits
in each pair. Then return the result as a decimal number.

Example
For n = 13, the output should be
solution(n) = 14.

1310 = 11012 ~> {11}{01}2 ~> 11102 = 1410.

For n = 74, the output should be
solution(n) = 133.

7410 = 010010102 ~> {01}{00}{10}{10}2 ~> 100001012 = 13310.
Note the preceding zero written in front of the initial number: since both numbers are 32-bit integers,
they have 32 bits in their binary representation. The preceding zeros in other cases don't matter,
so they are omitted. Here, however, it does make a difference.
 */
public class CS022_SwapAdjacentBits {
    public static void main(String[] args) {
        System.out.println(solution(13));
    }

    static int solution(int n) {
        return (((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1));
    }
}
/*
The idea is to separate bits present at even positions with bits present at odd positions
using mask 0xAAAAAAAA and 0x55555555, respectively.

    Mask 0xAAAAAAAA has all its even bits set, and its bitwise AND with n will separate bits present
    at even positions in n.
    Similarly, mask 0x55555555 has all its odd bits set, and its bitwise AND with n will separate
    bits present at odd positions in n.

(0xAAAAAAAA)16 = (1010 1010 1010 1010 1010 1010 1010 1010)2
(0x55555555)16 = (0101 0101 0101 0101 0101 0101 0101 0101)2

After separating even and odd bits, right shift the even bits by 1 position and left shift
the odd bits by 1 position. Now that all even bits are at odd positions and all odd bits are
at even positions merge them by taking their OR. For example,

1. SEPARATE:

00101101011001010111000110001001   &    (n)
10101010101010101010101010101010        (0xAAAAAAAA)
————————————————————————————————
00101000001000000010000010001000        (Contains all even bits)


00101101011001010111000110001001   &    (n)
01010101010101010101010101010101        (0x55555555)
————————————————————————————————
00000101010001010101000100000001        (Contains all odd bits)


2. SHIFT & MERGE:

00010100000100000001000001000100   |    (Right shift even bits by 1)
00001010100010101010001000000010        (Left shift odd bits by 1)
————————————————————————————————
00011110100110101011001001000110        (Adjacent bits swapped)
 */