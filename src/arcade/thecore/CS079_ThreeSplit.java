package arcade.thecore;

import java.util.Arrays;

/*
You have a long strip of paper with integers written on it in a single line from left to right.
You wish to cut the paper into exactly three pieces such that each piece contains at least one
integer and the sum of the integers in each piece is the same. You cannot cut through a number,
i.e. each initial number will unambiguously belong to one of the pieces after cutting. How many ways can you do it?

It is guaranteed that the sum of all elements in the array is divisible by 3.

Example
For a = [0, -1, 0, -1, 0, -1], the output should be
solution(a) = 4.
Here are all possible ways:
[0, -1] [0, -1] [0, -1]
[0, -1] [0, -1, 0] [-1]
[0, -1, 0] [-1, 0] [-1]
[0, -1, 0] [-1] [0, -1]
 */
public class CS079_ThreeSplit {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, -1, 0, -1, 0, -1}));
    }

    static int solution(int[] a) {
        int result = 0;
        int total = Arrays.stream(a).sum();
        int sumPart1 = 0;
        int sumPart2 = 0;
        int sumPart3;
        for (int i = 1; i < a.length - 1; i++) {
            sumPart1 += a[i - 1];
            for (int j = i + 1; j < a.length; j++) {
                sumPart2 += a[j - 1];
                sumPart3 = total - sumPart1 - sumPart2;
                if (sumPart1 == sumPart2 && sumPart2 == sumPart3) {
                    result++;
                }
            }
            sumPart2 = 0;
        }
        return result;
    }
}
