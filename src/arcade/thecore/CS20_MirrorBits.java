package arcade.thecore;

/*
Reverse the order of the bits in a given integer.

Example
For a = 97, the output should be
solution(a) = 67.
97 equals to 1100001 in binary, which is 1000011 after mirroring, and that is 67 in base 10.

For a = 8, the output should be
solution(a) = 1.
 */
public class CS20_MirrorBits {
    public static void main(String[] args) {
        System.out.println(solution(97));
    }

    static int solution(int a) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(a));
        binary.reverse();
        return Integer.parseInt(binary.toString(), 2);
    }
}
