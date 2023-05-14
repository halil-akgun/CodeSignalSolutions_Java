package arcade.thecore;

/*
You're given three integers, a, b and c. It is guaranteed that two of these integers are equal to each other.
What is the value of the third integer?

Example
For a = 2, b = 7, and c = 2, the output should be
solution(a, b, c) = 7.

The two equal numbers are a and c. The third number (b) equals 7, which is the answer.
 */
public class CS11_ExtraNumber {
    public static void main(String[] args) {
        System.out.println(solution(2, 7, 2));
    }

    static int solution(int a, int b, int c) {
        return a == b ? c : a == c ? b : a;
    }
}
