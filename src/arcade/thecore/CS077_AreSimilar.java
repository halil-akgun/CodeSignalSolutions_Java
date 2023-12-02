package arcade.thecore;

import java.util.Arrays;

/*
Two arrays are called similar if one can be obtained from another
by swapping at most one pair of elements in one of the arrays.
Given two arrays a and b, check whether they are similar.

Example
For a = [1, 2, 3] and b = [1, 2, 3], the output should be
solution(a, b) = true.
The arrays are equal, no need to swap any elements.

For a = [1, 2, 3] and b = [2, 1, 3], the output should be
solution(a, b) = true.
We can obtain b from a by swapping 2 and 1 in b.

For a = [1, 2, 2] and b = [2, 1, 1], the output should be
solution(a, b) = false.
Any swap of any two elements either in a or in b won't make a and b equal.
 */
public class CS077_AreSimilar {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, new int[]{1, 3, 2}));
    }

    static boolean solution(int[] a, int[] b) {
        int[] diffs1 = new int[2];
        int[] diffs2 = new int[2];
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            try {
                if (a[i] != b[i]) {
                    diffs1[idx] = a[i];
                    diffs2[idx] = b[i];
                    idx++;
                }
            } catch (Exception e) {
                return false;
            }
        }
        Arrays.sort(diffs1);
        Arrays.sort(diffs2);
        return Arrays.equals(diffs1, diffs2);
    }
}
