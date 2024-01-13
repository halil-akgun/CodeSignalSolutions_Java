package arcade.thecore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/*
You are given an array of integers a. A range sum query is defined by a pair of
non-negative integers l and r (l <= r). The output to a range sum query on the given
array a is the sum of all the elements of a that have indices from l to r, inclusive.

You have the array a and a list of range sum queries q. Find an algorithm that can rearrange the array
a in such a way that the total sum of all of the query outputs is maximized, and return this total sum.

Example
For a = [9, 7, 2, 4, 4] and q = [[1, 3], [1, 4], [0, 2]], the output should be
solution(a, q) = 62.

You can get this sum if the array a is rearranged to be [2, 9, 7, 4, 4]. In that case,
the first range sum query [1, 3] returns the sum 9 + 7 + 4 = 20, the second query [1, 4]
returns the sum 9 + 7 + 4 + 4 = 24, and the third query [0, 2] returns the sum 2 + 9 + 7 = 18.
The total sum will be 20 + 24 + 18 = 62.
 */
public class CS118_MaximumSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 7, 2, 4, 4}, new int[][]{{1, 3}, {1, 4}, {0, 2}}));
    }

    static int solution(int[] a, int[][] q) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : q) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().toList();
        int[] mostFrequentSortedIndexes = list.stream().sorted((x, y) -> y.getValue() - x.getValue()).mapToInt(Map.Entry::getKey).toArray();
        int[] otherIndexes = IntStream.rangeClosed(0, a.length - 1).filter(i -> !Arrays.stream(mostFrequentSortedIndexes).boxed().toList().contains(i)).toArray();

        Arrays.sort(a);
        int[] result = new int[a.length];

        int idx = a.length - 1;

        for (int index : mostFrequentSortedIndexes) {
            result[index] = a[idx--];
        }
        for (int otherIndex : otherIndexes) {
            result[otherIndex] = a[idx--];
        }

        return getSum(result, q);
    }

    private static int getSum(int[] result, int[][] q) {
        int sum = 0;
        for (int[] w : q) {
            for (int i = w[0]; i <= w[1]; i++) {
                sum += result[i];
            }
        }
        return sum;
    }
}
