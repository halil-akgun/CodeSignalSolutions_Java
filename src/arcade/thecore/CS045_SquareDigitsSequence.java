package arcade.thecore;

import java.util.HashSet;

/*
Consider a sequence of numbers a0, a1, ..., an, in which an element is equal to the sum of squared digits
of the previous element. The sequence ends once an element that has already been in the sequence appears again.

Given the first element a0, find the length of the sequence.

Example
For a0 = 16, the output should be
solution(a0) = 9.
Here's how elements of the sequence are constructed:
a0 = 16
a1 = 1^2 + 6^2 = 37
a2 = 3^2 + 7^2 = 58
a3 = 5^2 + 8^2 = 89
a4 = 8^2 + 9^2 = 145
a5 = 1^2 + 4^2 + 5^2 = 42
a6 = 4^2 + 2^2 = 20
a7 = 2^2 + 0^2 = 4
a8 = 4^2 = 16, which has already occurred before (a0)
Thus, there are 9 elements in the sequence.

For a0 = 103, the output should be
solution(a0) = 4.
The sequence goes as follows: 103 -> 10 -> 1 -> 1, 4 elements altogether.
 */
public class CS045_SquareDigitsSequence {
    public static void main(String[] args) {
        System.out.println(solution(103));
//        System.out.println(1/10);
    }

    static int solution(int a0) {
        HashSet<Integer> set = new HashSet<>();
        int temp = a0;
        do {
            if (!set.contains(temp)) set.add(temp);
            else break;
            temp = squareOfDigits(temp);
        } while (temp != a0);
        return set.size() + 1;
    }

    static int squareOfDigits(int a) {
        int ans = 0;
        while (a > 0) {
            ans += (int) Math.pow(a % 10, 2);
            a = a / 10;
        }
        return ans;
    }
}
