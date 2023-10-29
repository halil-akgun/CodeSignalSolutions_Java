package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Let's say that number a feels comfortable with number b if a ≠ b and b lies in
the segment [a - s(a), a + s(a)], where s(x) is the sum of x's digits.

How many pairs (a, b) are there, such that a < b, both a and b lie on the segment [l, r],
and each number feels comfortable with the other (so a feels comfortable with b and b feels comfortable with a)?

Example
For l = 10 and r = 12, the output should be
solution(l, r) = 2.

Here are all values of s(x) to consider:
s(10) = 1, so 10 is comfortable with 9 and 11;
s(11) = 2, so 11 is comfortable with 9, 10, 12 and 13;
s(12) = 3, so 12 is comfortable with 9, 10, 11, 13, 14 and 15.
Thus, there are 2 pairs of numbers comfortable with each other within the segment [10; 12]: (10, 11) and (11, 12).
 */
public class CS047_ComfortableNumbers {
    public static void main(String[] args) {
        System.out.println(solution(1, 9));
    }

    static int solution(int l, int r) {
        int count = 0;
        Map<Integer, List<Integer>> values = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            for (int j = i - sumDigits(i); j <= i + sumDigits(i); j++) {
                if (i != j) temp.add(j);
            }
            values.put(i, temp);
            temp = new ArrayList<>();
        }
        for (Map.Entry<Integer, List<Integer>> a : values.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> b : values.entrySet()) {
                if (a.getValue().contains(b.getKey()) && b.getValue().contains(a.getKey())) count++;
            }
        }

        return count / 2;
    }

    static int sumDigits(int num) {
        return Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sum();
    }
}