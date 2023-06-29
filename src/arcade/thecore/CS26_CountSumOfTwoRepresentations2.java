package arcade.thecore;

import java.util.HashMap;
import java.util.HashSet;

/*
Given integers n, l and r, find the number of ways to represent n as a sum of
two integers A and B such that l ≤ A ≤ B ≤ r.

Example
For n = 6, l = 2, and r = 4, the output should be
solution(n, l, r) = 2.
There are just two ways to write 6 as A + B, where 2 ≤ A ≤ B ≤ 4: 6 = 2 + 4 and 6 = 3 + 3.
 */
public class CS26_CountSumOfTwoRepresentations2 {
    public static void main(String[] args) {
        System.out.println(solution(6, 2, 4));
    }

    static int solution(int n, int l, int r) {
//        int count = 0;
//        for (int i = l; i <= r; i++) {
//            for (int j = i; j <= r; j++) {
//                if (i + j == n) count++;
//            }
//        }
//        return count;
//        Tests passed: 6/12. Execution time limit exceeded on test 7: Program exceeded the execution time limit.


//        HashMap<Integer, Integer> sums = new HashMap<>();
//        for (int i = l; i <= r; i++) {
//            for (int j = i; j <= r; j++) {
//                sums.put(i + j, sums.getOrDefault(i + j, 0) + 1);
//            }
//        }
//        return sums.getOrDefault(n,0);
//        Tests passed: 6/12. Execution time limit exceeded on test 7: Program exceeded the execution time limit.


//        return helperMethod(n, l, l, r);
//        Exception in thread "main" java.lang.StackOverflowError - For n = 1000000, l = 490000, and r = 900000


        int maxA = Math.min(n - l, r);
        int minA = Math.max(n - r, l);

        if (maxA < minA) {
            return 0;
        }
        return (maxA - minA) / 2 + 1;
    }

//    private static int helperMethod(int n, int l, int r, int border) {
//        int count = 0;
//        if (l <= border) {
//            count = helperMethod2(n, l, r, border);
//            if (l + 1 <= border) {
//                count += helperMethod(n, l + 1, l + 1, border);
//            }
//        }
//        return count;
//    }

//    private static int helperMethod2(int n, int l, int r, int border) {
//        int count = 0;
//        if (l + r <= n && r <= border) {
//            count = helperMethod2(n, l, r + 1, border);
//            if (l + r == n) count++;
//        }
//        return count;
//    }
}
